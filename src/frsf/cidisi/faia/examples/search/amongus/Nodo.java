package frsf.cidisi.faia.examples.search.amongus;

import java.util.List;
import java.util.Map;

public class Nodo {
	
	private Integer id;
	private String nombre;
	private List<Tripulante> listaTripulantes;
	private TareaAmongUs tarea;
	
	public Nodo(Integer id, String nombre) {
		super();
		this.id = id;
		this.setNombre(nombre);
	}
	
	public String toString() {
		return this.id.toString();
	}
	
	public List<Tripulante> getListaTripulantes() {
		return listaTripulantes;
	}

	public void setListaTripulantes(List<Tripulante> listaTripulantes) {
		this.listaTripulantes = listaTripulantes;
	}

	public TareaAmongUs getTarea() {
		return tarea;
	}

	public void setTarea(TareaAmongUs tarea) {
		this.tarea = tarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
