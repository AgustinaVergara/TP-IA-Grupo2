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
    private List<Nodo> nodosVecinos;

    public AgentStateAmongUs(Map<Nodo, List<Nodo>> naveAgente, Nodo ubicacion, Integer energia, Integer energiaInicial,
                             List<TareaAmongUs> tareas, Integer tareasPendientes, Integer tripulantesVivos,
                             List<Tripulante> tripulantes, List<Nodo> nodosVecinos) {
        super();
        this.naveAgente = new HashMap<>(naveAgente);
        this.ubicacion = ubicacion;
        this.energia = energia;
        this.energiaInicial = energiaInicial;
        this.tareas = new ArrayList<>(tareas);
        this.tareasPendientes = tareasPendientes;
        this.tripulantesVivos = tripulantesVivos;
        this.tripulantes = new ArrayList<>(tripulantes);
        this.nodosVecinos = new ArrayList<>(nodosVecinos);
    }

    public AgentStateAmongUs() {
        super();
        this.initState();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AgentStateAmongUs other = (AgentStateAmongUs) obj;
        return Objects.equals(naveAgente, other.naveAgente) &&
               Objects.equals(ubicacion, other.ubicacion) &&
               Objects.equals(energia, other.energia) &&
               Objects.equals(energiaInicial, other.energiaInicial) &&
               Objects.equals(tareas, other.tareas) &&
               Objects.equals(tareasPendientes, other.tareasPendientes) &&
               Objects.equals(tripulantesVivos, other.tripulantesVivos) &&
               Objects.equals(tripulantes, other.tripulantes) &&
               Objects.equals(nodosVecinos, other.nodosVecinos);
    }

    @Override
    public SearchBasedAgentState clone() {
        Map<Nodo, List<Nodo>> clonedNaveAgente = new HashMap<>();
        for (Map.Entry<Nodo, List<Nodo>> entry : this.naveAgente.entrySet()) {
            clonedNaveAgente.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }

        List<TareaAmongUs> clonedTareas = new ArrayList<>();
        for (TareaAmongUs tarea : this.tareas) {
            clonedTareas.add(new TareaAmongUs(tarea.getNombre()));
        }

        List<Tripulante> clonedTripulantes = new ArrayList<>();
        for (Tripulante tripulante : this.tripulantes) {
            Tripulante clonedTripulante = new Tripulante(tripulante.getId());
            clonedTripulante.setEstaVivo(tripulante.getEstaVivo());
            clonedTripulante.setCiclosParaMoverse(tripulante.getCiclosParaMoverse());
            clonedTripulantes.add(clonedTripulante);
        }

        return new AgentStateAmongUs(
                clonedNaveAgente,
                this.ubicacion,
                this.energia,
                this.energiaInicial,
                clonedTareas,
                this.tareasPendientes,
                this.tripulantesVivos,
                clonedTripulantes,
                new ArrayList<>(this.nodosVecinos)
        );
    }

    @Override
    public void updateState(Perception p) {
        PerceptionAmongUs percepcion = (PerceptionAmongUs) p;

        if (percepcion.getMapaCompleto() != null) {
            this.naveAgente = new HashMap<>(percepcion.getMapaCompleto());
        }

        this.setUbicacion(percepcion.getNodoActualAgente());

        Nodo nodoActual = percepcion.getNodoActualAgente();
        List<Nodo> nodosVecinos = percepcion.getNodosVecinos();
        if (nodoActual != null && nodosVecinos != null) {
            this.naveAgente.put(nodoActual, new ArrayList<>(nodosVecinos));
            this.nodosVecinos = new ArrayList<>(nodosVecinos);
        }

        this.tripulantesVivos = percepcion.getTripulantesVivos();
        this.tareasPendientes = percepcion.getTareasPendientes();
        this.tripulantes = new ArrayList<>(percepcion.getTripulantes());
        this.tareas = new ArrayList<>(percepcion.getTareas());
        this.energia = percepcion.getEnergia();
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
                ", nodosVecinos=" + nodosVecinos +
                '}';
    }

    @Override
    public void initState() {
        this.naveAgente = new HashMap<>();
        this.ubicacion = null;
        this.energia = 1;
        this.energiaInicial = 1;
        this.tareas = new ArrayList<>();
        this.tareasPendientes = 0;
        this.tripulantesVivos = 0;
        this.tripulantes = new ArrayList<>();
        this.nodosVecinos = new ArrayList<>();
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

    public List<Nodo> getNodosVecinos() {
        return nodosVecinos;
    }

    public void setNodosVecinos(List<Nodo> nodosVecinos) {
        this.nodosVecinos = nodosVecinos;
    }

    public List<Nodo> getNodosVecinos(Nodo nodo) {
        return naveAgente.getOrDefault(nodo, new ArrayList<>());
    }

    public void setNodosVecinos(Nodo nodo, List<Nodo> nodosVecinos) {
        this.naveAgente.put(nodo, nodosVecinos);
    }

    public void setTareaRealizada(String nombreTarea, boolean realizada) {
        for (TareaAmongUs tarea : tareas) {
            if (tarea.getNombre().equals(nombreTarea)) {
                tarea.setRealizada(realizada);
                break;
            }
        }
    }
}
