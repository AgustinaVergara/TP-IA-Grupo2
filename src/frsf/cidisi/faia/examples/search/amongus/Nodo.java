package frsf.cidisi.faia.examples.search.amongus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Nodo {
	
	private Integer id;
	private String nombre;
	private List<Tripulante> listaTripulantes;
	private TareaAmongUs tarea;
	
	public Nodo(Integer id, String nombre) {
		super();
		this.id = id;
		this.setNombre(nombre);
		this.listaTripulantes = new ArrayList<>();
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
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Nodo other = (Nodo) obj;
        return Objects.equals(id, other.id) &&
               Objects.equals(nombre, other.nombre) &&
               Objects.equals(listaTripulantes, other.listaTripulantes) &&
               Objects.equals(tarea, other.tarea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, listaTripulantes, tarea);
    }
		
}
