package frsf.cidisi.faia.examples.search.amongus;

import java.util.List;
import java.util.Map;

public class Nodo {
	
	private Integer id;
	private String nombre;
	
	public Nodo(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public String toString() {
		return this.id.toString();
	}
	
	
}
