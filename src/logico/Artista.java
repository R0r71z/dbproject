package logico;

import java.util.Date;

public class Artista extends Persona{
    private String codigo_artista;
    private String nombre_artistico;
    private String genero;
	public Artista(String pnombre, String papellido, String snombre, String sapellido, String mipais, String sexo,
			Date fecha_nacim, String codigo, String codigo_artista) {
		super(pnombre, papellido, snombre, sapellido, mipais, sexo, fecha_nacim, codigo);
		// TODO Auto-generated constructor stub
		this.codigo_artista = codigo_artista;
	}
	public String getCodigo_artista() {
		return codigo_artista;
	}
	public void setCodigo_artista(String codigo_artista) {
		this.codigo_artista = codigo_artista;
	}


}
