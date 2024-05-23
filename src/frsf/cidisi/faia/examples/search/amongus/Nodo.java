package frsf.cidisi.faia.examples.search.amongus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Nodo implements Cloneable{
	
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
	
	public Nodo(Integer id, String nombre, List<Tripulante> listaTripulantes, TareaAmongUs tarea) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.listaTripulantes = listaTripulantes;
		this.tarea = tarea;
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

	/*public Object getId() {
		// TODO Auto-generated method stub
		return id;
	}*/
	
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
    public Nodo clone() {
        Integer nuevoId = this.getId();
		String nuevoNombre =this.getNombre();

        List<Tripulante> nuevaListaTripulantes = new ArrayList<>();
        for (Tripulante t : this.listaTripulantes) {
            nuevaListaTripulantes.add(t.clone());
        }

        TareaAmongUs nuevaTarea;
        if(this.tarea != null) {
        	nuevaTarea = this.tarea.clone();
        }else {
        	nuevaTarea = null;
        }
       
		Nodo nuevoNodo = new Nodo(nuevoId, nuevoNombre, nuevaListaTripulantes, nuevaTarea);
		return nuevoNodo;
    }
	
	
	public Nodo(Nodo otro) {
        this.id = otro.id;
        this.nombre = new String(otro.nombre);
        this.listaTripulantes = new ArrayList<>();
        for (Tripulante tripulante : otro.listaTripulantes) {
            this.listaTripulantes.add(new Tripulante(tripulante));
        }
    }
		
}
