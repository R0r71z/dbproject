package logico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	private Connection conn;
	private Statement stmt;
    private static String host = "ec2-54-204-40-248.compute-1.amazonaws.com";
    private static String database = "d56lh9r4ivgcuv";
    private static String user = "rrnuzvjrwcimic";
    private static String pass = "235b9af1ee88a82c9cdb6829ac6f9d66eb4f576071a1aebe82c14a06111af6f7";
	
	public DB() {
		super();

	      try {
	         Class.forName("org.postgresql.Driver");
	         connect();
	      } catch ( Exception e ) {
	          System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	          System.exit(0);
	   }
	}
	
	private void connect() {
		if (conn == null) {
			try {
				conn = DriverManager
				        .getConnection("jdbc:postgresql://" + host + ":5432/" + database,
				        user, pass);
				conn.setAutoCommit(false);
				setStatement();
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}

	}
	
	private void setStatement() {
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet select(String query) {
		ResultSet rs = null;
		setStatement();
		try {
			rs = stmt.executeQuery("SELECT " + query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void close() {
        try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public Usuario getDBUser(String username) {
		Persona user = null;
		ResultSet uRS = select("* from usuarios where nombre_usuario = '" + username + "';");
		ResultSet pRS = select("* from personas as P, usuarios as U where U.nombre_usuario = '" + username + "' AND P.codigo_persona = U.persona;");
		int idPersona = -1;
		
		String password= null, codigo_usuario= null, correo= null, estado = null;
		Date fecha_registro= null, fecha_nac = null ;
		String pnombre = null, papellido = null, snombre= null, sapellido= null,
				pais= null, sexo= null, codigo_persona = null;
		
		try {
			if (uRS.next()) {
				password = uRS.getString("password");
				codigo_usuario = uRS.getString("codigo_usuario");
				correo = uRS.getString("correo");
				estado = uRS.getString("estado");
				fecha_registro = uRS.getDate("fecharegistro");
			}
			
			if (pRS.next()) {
				pnombre = pRS.getString("pnombre");
				papellido = pRS.getString("papellido");
				snombre = pRS.getString("snombre");
				sapellido = pRS.getString("sapellido");
				sexo = pRS.getString("sexo");
				codigo_persona = pRS.getString("codigo_persona");
				idPersona = pRS.getInt("codigo_persona");
				
			}
			ResultSet paises = select("nombre from paises as PA, personas as P where P.pais_origen = PA.codigo_pais AND P.codigo_persona = " + idPersona + ";");
			
			if (paises.next()) {
				pais = paises.getString("nombre");
			}
			
			user = new Usuario(
					pnombre,
					papellido,
					snombre,
					sapellido,
					pais,
					sexo,
					fecha_nac,
					codigo_persona,
					codigo_usuario,
					username,
					password,
					fecha_registro,
					correo,
					estado
				);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Usuario) user;
	}

}


