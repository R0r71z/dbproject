package logico;

import java.util.Date;

public class Persona {
	protected String pnombre;
	protected String papellido;
	protected String snombre;
	protected String sapellido;
	protected String mipais;
	protected String sexo;
	protected Date fecha_nacim;
	protected String codigo;
	protected String idioma_preferencia;
	
	public Persona(String pnombre, String papellido, String snombre, String sapellido, String mipais, String sexo,
			Date fecha_nacim, String codigo, String idioma_preferencia) {
		// TODO Auto-generated constructor stub
		super();
		this.pnombre = pnombre;
		this.papellido = papellido;
		this.snombre = snombre;
		this.sapellido = sapellido;
		this.mipais = mipais;
		this.sexo = sexo;
		this.codigo = codigo;
		this.fecha_nacim = fecha_nacim;
		this.idioma_preferencia = idioma_preferencia;
		
	}
	public String getPnombre() {
		return pnombre;
	}
	public String getPapellido() {
		return papellido;
	}
	public String getSnombre() {
		return snombre;
	}
	public String getSapellido() {
		return sapellido;
	}
	public String getMipais() {
		return mipais;
	}
	public String getSexo() {
		return sexo;
	}
	public Date getFecha_nacim() {
		return fecha_nacim;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getIdioma_preferencia() {
		return idioma_preferencia;
	}
	public void setPnombre(String pnombre) {
		this.pnombre = pnombre;
	}
	public void setPapellido(String papellido) {
		this.papellido = papellido;
	}
	public void setSnombre(String snombre) {
		this.snombre = snombre;
	}
	public void setSapellido(String sapellido) {
		this.sapellido = sapellido;
	}
	public void setMipais(String mipais) {
		this.mipais = mipais;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setFecha_nacim(Date fecha_nacim) {
		this.fecha_nacim = fecha_nacim;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setIdioma_preferencia(String idioma_preferencia) {
		this.idioma_preferencia = idioma_preferencia;
	}

	

}
