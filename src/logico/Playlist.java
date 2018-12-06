package logico;

import java.util.ArrayList;
import java.util.Date;

public class Playlist {
  private String codigo;
  private Usuario miUsuario;
  private String nombre;
  private Date fecha_creacion;
  private ArrayList<Cancion> miscanciones;
public Playlist(String codigo, Usuario miUsuario, String nombre, Date fecha_creacion) {
	super();
	this.codigo = codigo;
	this.miUsuario = miUsuario;
	this.nombre = nombre;
	this.fecha_creacion = fecha_creacion;
}
public String getCodigo() {
	return codigo;
}
public Usuario getMiUsuario() {
	return miUsuario;
}
public String getNombre() {
	return nombre;
}
public Date getFecha_creacion() {
	return fecha_creacion;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public void setMiUsuario(Usuario miUsuario) {
	this.miUsuario = miUsuario;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setFecha_creacion(Date fecha_creacion) {
	this.fecha_creacion = fecha_creacion;
}
public ArrayList<Cancion> getMiscanciones() {
	return miscanciones;
}
public void setMiscanciones(ArrayList<Cancion> miscanciones) {
	this.miscanciones = miscanciones;
}

@Override
public String toString() {
	return getNombre();
}
  
	

}
