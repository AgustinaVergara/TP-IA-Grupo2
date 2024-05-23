package frsf.cidisi.faia.examples.search.amongus;

import java.util.ArrayList;
import java.util.List;

public class Nodo implements Cloneable {
    
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

    @Override
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

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
    public Nodo clone() {
        Integer nuevoId = this.getId();
        String nuevoNombre = this.getNombre();

        List<Tripulante> nuevaListaTripulantes = new ArrayList<>();
        for (Tripulante t : this.listaTripulantes) {
            nuevaListaTripulantes.add(t.clone());
        }

        TareaAmongUs nuevaTarea = (this.tarea != null) ? this.tarea.clone() : null;
       
        return new Nodo(nuevoId, nuevoNombre, nuevaListaTripulantes, nuevaTarea);
    }
    
    public Nodo(Nodo otro) {
        this.id = otro.id;
        this.nombre = new String(otro.nombre);
        this.listaTripulantes = new ArrayList<>();
        for (Tripulante tripulante : otro.listaTripulantes) {
            this.listaTripulantes.add(new Tripulante(tripulante));
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Nodo nodo = (Nodo) obj;
        return id.equals(nodo.id) && nombre.equals(nodo.nombre);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nombre.hashCode();
        return result;
    }
}
