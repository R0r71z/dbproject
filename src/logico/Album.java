package logico;

import java.util.ArrayList;

public class Album {
   private String codigo;
   private String nombre;
   private String descripcion;
   private ArrayList<Cancion> miscanciones;
   private ArrayList<Artista> artistasOwners;
public Album(String codigo, String nombre, String descripcion, ArrayList<Cancion> miscanciones) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.miscanciones = miscanciones;
}
public String getCodigo() {
	return codigo;
}
public String getNombre() {
	return nombre;
}
public String getDescripcion() {
	return descripcion;
}
public ArrayList<Cancion> getMiscanciones() {
	return miscanciones;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public void setMiscanciones(ArrayList<Cancion> miscanciones) {
	this.miscanciones = miscanciones;
}

}
