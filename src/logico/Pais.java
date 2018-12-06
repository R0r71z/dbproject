package logico;

public class Pais {
	private Integer codigo_pais;
	private String nombre;
	private String abreviacion;
	
	public Pais(Integer codigo_pais, String nombre, String abreviacion) {
		super();
		this.codigo_pais = codigo_pais;
		this.nombre = nombre;
		this.abreviacion = abreviacion;
	}

	public Integer getCodigo_pais() {
		return codigo_pais;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getAbreviacion() {
		return abreviacion;
	}
	
	@Override
	public String toString() {
		return getAbreviacion();
	}
	
}
