package logico;

import java.util.Date;

public class Usuario extends Persona{
    private String codigo_usuario;
    private String password;
    private Date fecha_registro;
    private String correo;
    private String estado;
    
	public Usuario(String pnombre, String papellido, String snombre, String sapellido, String mipais, String sexo,
			Date fecha_nacim, String codigo, String idioma_preferencia, String codigo_usuario) {
		super(pnombre, papellido, snombre, sapellido, mipais, sexo, fecha_nacim, codigo, idioma_preferencia);
		// TODO Auto-generated constructor stub
		this.codigo_usuario = codigo_usuario;
	}
	
	
	public String getCodigo_usuario() {
		return codigo_usuario;
	}
	public void setCodigo_usuario(String codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}
	public String getPassword() {
		return password;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public String getCorreo() {
		return correo;
	}
	public String getEstado() {
		return estado;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
