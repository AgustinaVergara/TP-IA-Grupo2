package frsf.cidisi.faia.examples.search.amongus;

import java.util.*;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class AgentStateAmongUs extends SearchBasedAgentState {
    
    private Map<Nodo, List<Nodo>> naveAgente;
    private Nodo ubicacion;
    private Integer energia;
    private Integer energiaInicial;
    private List<TareaAmongUs> tareas;
    private Integer tareasPendientes;
    private Integer tripulantesVivos;
    private List<Tripulante> tripulantes;

    public AgentStateAmongUs(Map<Nodo, List<Nodo>> naveAgente, Nodo ubicacion, Integer energia, Integer energiaInicial,
            List<TareaAmongUs> tareas, Integer tareasPendientes, Integer tripulantesVivos,
            List<Tripulante> tripulantes) {
super();
this.naveAgente = naveAgente;
this.ubicacion = ubicacion;
this.energia = energia;
this.energiaInicial = energiaInicial;
this.tareas = (tareas != null) ? new ArrayList<>(tareas) : new ArrayList<>();
this.tareasPendientes = tareasPendientes;
this.tripulantesVivos = tripulantesVivos;
this.tripulantes = (tripulantes != null) ? new ArrayList<>(tripulantes) : new ArrayList<>();

}



    public AgentStateAmongUs() {
        this.initState();
    }

    @Override
    public void initState() {
        this.naveAgente = new HashMap<>();
        this.ubicacion = null; // o alguna ubicación inicial válida
        this.energia = 100; // valor inicial de energía
        this.energiaInicial = 100; // valor inicial de energía
        this.tareas = new ArrayList<>();
        this.tareasPendientes = 0;
        this.tripulantesVivos = 0; // o algún valor inicial válido
        this.tripulantes = new ArrayList<>();
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AgentStateAmongUs that = (AgentStateAmongUs) obj;
        return Objects.equals(naveAgente, that.naveAgente) &&
                Objects.equals(ubicacion, that.ubicacion) &&
                Objects.equals(energia, that.energia) &&
                Objects.equals(energiaInicial, that.energiaInicial) &&
                Objects.equals(tareas, that.tareas) &&
                Objects.equals(tareasPendientes, that.tareasPendientes) &&
                Objects.equals(tripulantesVivos, that.tripulantesVivos) &&
                Objects.equals(tripulantes, that.tripulantes);
                
    }

    @Override
    public SearchBasedAgentState clone() {
    	
        return new AgentStateAmongUs(
                new HashMap<>(this.naveAgente),
                this.ubicacion,
                this.energia,
                this.energiaInicial,
                new ArrayList<>(this.tareas),
                this.tareasPendientes,
                this.tripulantesVivos,
                new ArrayList<>(this.tripulantes)
                
        );
    }

    @Override
    public void updateState(Perception p) {
        PerceptionAmongUs percepcion = (PerceptionAmongUs) p;

        if (percepcion.getMapaCompleto() != null) {
            // Copiar el mapa completo de la percepción al estado del agente
            this.naveAgente = new HashMap<>(percepcion.getMapaCompleto());
        }

        // Actualizar la ubicación del agente
        this.setUbicacion(percepcion.getNodoActualAgente());

        // Actualizar la información de los nodos adyacentes en el mapa del agente
        Nodo nodoActual = percepcion.getNodoActualAgente();
        List<Nodo> nodosVecinos = percepcion.getNodosVecinos();
        if (nodoActual != null && nodosVecinos != null) {
            this.naveAgente.put(nodoActual, new ArrayList<>(nodosVecinos));
        }

        // Actualizar la cantidad de tripulantes vivos y tareas pendientes
        this.tripulantesVivos = percepcion.getTripulantesVivos();
        this.tareasPendientes = percepcion.getTareasPendientes();
    }




    @Override
    public String toString() {
        return "AgentStateAmongUs{" +
                "naveAgente=" + naveAgente +
                ", ubicacion=" + ubicacion +
                ", energia=" + energia +
                ", energiaInicial=" + energiaInicial +
                ", tareas=" + tareas +
                ", tareasPendientes=" + tareasPendientes +
                ", tripulantesVivos=" + tripulantesVivos +
                ", tripulantes=" + tripulantes +
                '}';
    }

    // Getters y Setters

    public Map<Nodo, List<Nodo>> getNaveAgente() {
        return naveAgente;
    }

    public void setNaveAgente(Map<Nodo, List<Nodo>> naveAgente) {
        this.naveAgente = naveAgente;
    }

    public Nodo getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Nodo ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public Integer getEnergiaInicial() {
        return energiaInicial;
    }

    public void setEnergiaInicial(Integer energiaInicial) {
        this.energiaInicial = energiaInicial;
    }

    public List<TareaAmongUs> getTareas() {
        return tareas;
    }

    public void setTareas(List<TareaAmongUs> tareas) {
        this.tareas = tareas;
    }

    public Integer getTareasPendientes() {
        return tareasPendientes;
    }

    public void setTareasPendientes(Integer tareasPendientes) {
        this.tareasPendientes = tareasPendientes;
    }

    public Integer getTripulantesVivos() {
        return tripulantesVivos;
    }

    public void setTripulantesVivos(Integer tripulantesVivos) {
        this.tripulantesVivos = tripulantesVivos;
    }

    public List<Tripulante> getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(List<Tripulante> tripulantes) {
        this.tripulantes = tripulantes;
    }

    public void setTareaRealizada(String nombreTarea, boolean realizada) {
        for (TareaAmongUs tarea : tareas) {
            if (tarea.getNombre().equals(nombreTarea)) {
                tarea.setRealizada(realizada);
                break;
            }
        }
    }

    public List<Nodo> getNodosVecinos(Nodo nodo) {
        // Verificar si el nodo está presente en el mapa de la nave
        if (naveAgente.containsKey(nodo)) {
            // Devolver la lista de nodos vecinos del nodo dado
            return naveAgente.get(nodo);
        } else {
            // El nodo no está presente en el mapa, retornar una lista vacía
            return new ArrayList<>();
        }
    }

	
}
