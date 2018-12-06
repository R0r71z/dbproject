package logico;

import java.util.ArrayList;
import java.util.Date;

public class Cancion {
  private String codigo;
  private String titulo;
  private Date fecha_estreno;
  private int duracion;
  private ArrayList<Artista> artistas_colaboradores;
  private String album;
public Cancion(String codigo, String titulo, Date fecha_estreno, int duracion, String album) {
	super();
	this.codigo = codigo;
	this.titulo = titulo;
	this.fecha_estreno = fecha_estreno;
	this.duracion = duracion;
	this.album = album;
}
public String getCodigo() {
	return codigo;
}
public String getTitulo() {
	return titulo;
}
public Date getFecha_estreno() {
	return fecha_estreno;
}
public int getDuracion() {
	return duracion;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public void setFecha_estreno(Date fecha_estreno) {
	this.fecha_estreno = fecha_estreno;
}
public void setDuracion(int duracion) {
	this.duracion = duracion;
}
public ArrayList<Artista> getArtistas_colaboradores() {
	return artistas_colaboradores;
}
public void setArtistas_colaboradores(ArrayList<Artista> artistas_colaboradores) {
	this.artistas_colaboradores = artistas_colaboradores;
}
public String getAlbum() {
	return album;
}

  
}
