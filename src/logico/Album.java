package logico;

import java.util.ArrayList;

public class Album {
   private String codigo;
   private String nombre;
   private Integer release_year;
   private ArrayList<Cancion> miscanciones;
   private ArrayList<Artista> artistasOwners;
public Album(String codigo, String nombre, Integer release_year, ArrayList<Cancion> miscanciones,ArrayList<Artista> artistasOwners) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
	this.release_year = release_year;
	this.miscanciones = miscanciones;
	this.artistasOwners = artistasOwners;
}
public String getCodigo() {
	return codigo;
}
public String getNombre() {
	return nombre;
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
public void setMiscanciones(ArrayList<Cancion> miscanciones) {
	this.miscanciones = miscanciones;
}
public Integer getRelease_year() {
	return release_year;
}
public ArrayList<Artista> getArtistasOwners() {
	return artistasOwners;
}

}
