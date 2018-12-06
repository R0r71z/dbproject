package logico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	private void setConnection() {
		try {
			conn = DriverManager
			        .getConnection("jdbc:postgresql://" + host + ":5432/" + database,
			        user, pass);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void connect() {
		if (conn == null) {
			setConnection();
			setStatement();
		}

	}
	
	private void setStatement() {
		try {
			if (conn == null) {
				setConnection();
			}
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
	
	public void insert(String table, String columns, String values) {
		connect();
		try {
			stmt.executeUpdate("INSERT INTO " + table +" ("+columns+") VALUES ("+values+");");
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
	}
	
	public void close() {
        try {
			stmt.close();
			conn = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public Usuario getDBUser(String username) {
		connect();
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
			} else {
				return null;
			}
			
			if (pRS.next()) {
				pnombre = pRS.getString("pnombre");
				papellido = pRS.getString("papellido");
				snombre = pRS.getString("snombre");
				sapellido = pRS.getString("sapellido");
				sexo = pRS.getString("sexo");
				codigo_persona = pRS.getString("codigo_persona");
				idPersona = pRS.getInt("codigo_persona");
				fecha_nac = pRS.getDate("fechanacim");
				
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
		close();
		return (Usuario) user;
	}
	
	public ArrayList<Pais> getPaises() {
		ArrayList<Pais> paises = new ArrayList<>();
		ResultSet p = select("* from paises;");
		try {
			while (p.next()) {
				Pais aux = new Pais(p.getInt("codigo_pais"), p.getString("nombre"), p.getString("abreviacion"));
				paises.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paises;
	}
	
	public int generateNextCode(String entity) {
		ResultSet rs = select("codigo_" + entity + " from " + entity + "s;");
		int aux = -1;
		try {
			while(rs.next()) {
				if (rs.getInt("codigo_"+entity) > aux) {
					aux = rs.getInt("codigo_"+entity);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux+1;
	}

	public void registerUser(Integer codigoPersona, Integer codigoUsuario, String username, String password, String pnombre,
			String papellido, Integer idPais, String fecha_nacim, String correo, Integer cedula, String sexo) {
		
		insert("personas",
				"codigo_persona,pnombre,papellido,fechanacim,sexo,pais_origen,cedula",
				codigoPersona.toString() + ","
						+ "'" + pnombre + "',"
						+ "'" + papellido + "',"
						+ "'" + fecha_nacim + "',"
						+ "'" + sexo + "',"
						+ idPais.toString() + ","
						+ (cedula != null ? cedula : "NULL"));
		
		insert("usuarios", "codigo_usuario,persona,password,fecharegistro,correo,estado,nombre_usuario", 
				codigoUsuario.toString() + ","
				+ codigoPersona.toString() + ","
				+ "'" + password + "',now(),"
				+ (correo != null ? "'" + correo + "'" : "NULL")
				+ ",'Activo','"
				+ username + "'");
		System.out.println("Usuario agregado correctamente.");
	}
	
	public String getAlbum(int idCancion) {
		String album = null;
		int idAlbum = -1;
		
		ResultSet rs = select("nombre from albumes as ALB, canciones as CA, albumes_canciones as AC where AC.album = ALB.codigo_album AND AC.cancion = CA.codigo_cancion"
				+ " AND CA.codigo_cancion = "+idCancion+";");
		
		try {
			if (rs.next()) {
				album = rs.getString("nombre");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return album;
	}
	
	public ArrayList<Playlist> getPlayLists(String username) {
		ArrayList<Playlist> playlists = new ArrayList<>();
		ResultSet PLRS = select("* from playlists as PL, usuarios as USR where PL.usuario = USR.codigo_usuario AND USR.nombre_usuario = '"+username+"';");
		int idPlaylist = -1;
		int idCancion = -1;
		int idArtista = -1;
		
		try {
			while (PLRS.next()) {
				idPlaylist = PLRS.getInt("codigo_playlist");
				Playlist aux = new Playlist(((Integer) idPlaylist).toString(), getDBUser(username), PLRS.getString("nombre"), PLRS.getDate("fecha_creacion"));
				
				ResultSet CCRS = select("* from canciones as CC, playlists_canciones as PLCC, playlists as PL where PL.codigo_playlist = "
						+ idPlaylist + " AND " + "PLCC.playlist = PL.codigo_playlist AND PLCC.cancion = CC.codigo_cancion;"
				);
				
				ArrayList<Cancion> canciones = new ArrayList<>();
				
				while(CCRS.next()) {
					idCancion = CCRS.getInt("codigo_cancion");
					Cancion aux2 = new Cancion( ((Integer) idCancion).toString(), CCRS.getString("titulo"), CCRS.getDate("fechaestreno"), CCRS.getInt("duracion"), getAlbum(idCancion));
					
					ResultSet colaboradores = select("* from artistas as ART, colaborador_cancion as CC where CC.artista = ART.codigo_artista AND CC.cancion = " +
					idCancion + ";"
							);
					ArrayList<Artista> colabs = new ArrayList<>();
					while(colaboradores.next()) {
						idArtista = colaboradores.getInt("codigo_artista");
						
						String pnombre = null, papellido = null, snombre= null, sapellido= null,
								pais= null, sexo= null, codigo_persona = null, genero = null, nombre_artistico = colaboradores.getString("nombre_artistico");
						Date fecha_nac = null;
						
						ResultSet pRS = select("* from personas as P, artistas as ART where ART.codigo_artista = " + idArtista + " AND P.codigo_persona = ART.persona;");
						int idPersona = -1;
						
						if (pRS.next()) {
							pnombre = pRS.getString("pnombre");
							papellido = pRS.getString("papellido");
							snombre = pRS.getString("snombre");
							sapellido = pRS.getString("sapellido");
							sexo = pRS.getString("sexo");
							codigo_persona = pRS.getString("codigo_persona");
							idPersona = pRS.getInt("codigo_persona");
							fecha_nac = pRS.getDate("fechanacim");
							
						}
						
						ResultSet paises = select("nombre from paises as PA, personas as P where P.pais_origen = PA.codigo_pais AND P.codigo_persona = " + idPersona + ";");
						
						if (paises.next()) {
							pais = paises.getString("nombre");
						}
						
						ResultSet generos = select("nombre from generos as GE, artistas as ART, artistas_generos as ARTGE where ARTGE.artista = ART.codigo_artista AND "
								+ "ARTGE.genero = GE.codigo_genero AND ART.codigo_artista = " + idArtista + ";");
						
						if (generos.next()) {
							genero = generos.getString("nombre");
						}
						
						Artista aux3 = new Artista(pnombre, papellido,
								snombre, sapellido,pais, sexo, fecha_nac,
								codigo_persona, ((Integer)idArtista).toString(),
								genero, nombre_artistico
								);
						colabs.add(aux3);
					}
					aux2.setArtistas_colaboradores(colabs);
					canciones.add(aux2);
				}
				aux.setMiscanciones(canciones);
				playlists.add(aux);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return playlists;
	}

}


