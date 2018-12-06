package logico;

import java.util.ArrayList;
import java.util.Date;

public class Grupo {
   private String codigo_grupo;
   private String nombre;
   private Date fecha_creacion;
   private ArrayList<Artista> misArtistas;
public Grupo(String codigo_grupo, String nombre, Date fecha_creacion, ArrayList<Artista> misArtistas) {
	super();
	this.codigo_grupo = codigo_grupo;
	this.nombre = nombre;
	this.fecha_creacion = fecha_creacion;
	this.misArtistas = misArtistas;
}
public String getCodigo_grupo() {
	return codigo_grupo;
}
public String getNombre() {
	return nombre;
}
public Date getFecha_creacion() {
	return fecha_creacion;
}
public ArrayList<Artista> getMisArtistas() {
	return misArtistas;
}
public void setCodigo_grupo(String codigo_grupo) {
	this.codigo_grupo = codigo_grupo;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setFecha_creacion(Date fecha_creacion) {
	this.fecha_creacion = fecha_creacion;
}
public void setMisArtistas(ArrayList<Artista> misArtistas) {
	this.misArtistas = misArtistas;
}
   

}
