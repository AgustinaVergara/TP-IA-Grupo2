package frsf.cidisi.faia.examples.search.amongus;

import java.util.List;
import java.util.Map;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.environment.Environment;

public class PerceptionAmongUs extends Perception {

    private Nodo nodoActualAgente;
    private List<Nodo> nodosVecinos;
    private Map<Nodo, List<Nodo>> mapaCompleto;
    private int tripulantesVivos;
    private int tareasPendientes;
    private List<TareaAmongUs> tareas;
    private int energia;
    private List<Tripulante> tripulantes;

    public PerceptionAmongUs(Agent agent, Environment environment) {
        super(agent, environment);
    }

    public PerceptionAmongUs() {
        super();
    }

    @Override
    public void initPerception(Agent agent, Environment environment) {
        EnvironmentAmongUs amongUsEnvironment = (EnvironmentAmongUs) environment;
        EnvironmentStateAmongUs amongUsEnvironmentState = amongUsEnvironment.getEnvironmentState();

        // Obtener la posición actual del agente desde el estado del entorno
        this.nodoActualAgente = amongUsEnvironmentState.getNodoActualAgente();

        // Obtener los nodos vecinos desde el mapa del entorno
        this.nodosVecinos = amongUsEnvironmentState.getNodosVecinos(this.nodoActualAgente);

        // Verificar si se debe pasar el mapa completo
        if (amongUsEnvironmentState.getProximaVisionGlobal() == 0) {
            this.mapaCompleto = amongUsEnvironmentState.getNave();
        }

        // Obtener la cantidad de tripulantes vivos y tareas pendientes
        this.tripulantesVivos = amongUsEnvironmentState.getTripulantesVivos();
        this.tareasPendientes = amongUsEnvironmentState.getTareasPendientes();
        this.tripulantes = amongUsEnvironmentState.getTripulantes();
        this.tareas = amongUsEnvironmentState.getTareas();
        this.energia = amongUsEnvironmentState.getEnergiaActual();
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public Nodo getNodoActualAgente() {
        return nodoActualAgente;
    }

    public void setNodoActualAgente(Nodo nodoActualAgente) {
        this.nodoActualAgente = nodoActualAgente;
    }

    public List<Nodo> getNodosVecinos() {
        return nodosVecinos;
    }

    public void setNodosVecinos(List<Nodo> nodosVecinos) {
        this.nodosVecinos = nodosVecinos;
    }

    public Map<Nodo, List<Nodo>> getMapaCompleto() {
        return mapaCompleto;
    }

    public void setMapaCompleto(Map<Nodo, List<Nodo>> mapaCompleto) {
        this.mapaCompleto = mapaCompleto;
    }

    public int getTripulantesVivos() {
        return tripulantesVivos;
    }

    public void setTripulantesVivos(int tripulantesVivos) {
        this.tripulantesVivos = tripulantesVivos;
    }

    public int getTareasPendientes() {
        return tareasPendientes;
    }

    public void setTareasPendientes(int tareasPendientes) {
        this.tareasPendientes = tareasPendientes;
    }

    public List<TareaAmongUs> getTareas() {
        return tareas;
    }

    public void setTareas(List<TareaAmongUs> tareas) {
        this.tareas = tareas;
    }

    public List<Tripulante> getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(List<Tripulante> tripulantes) {
        this.tripulantes = tripulantes;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Estado percepción Among Us\n");
        if (nodoActualAgente != null) {
            str.append("Nodo actual: ").append(nodoActualAgente.getId()).append(" - ").append(nodoActualAgente.getNombre()).append("\n");
        } else {
            str.append("Nodo actual: null\n");
        }
        str.append("Nodos vecinos: ");
        if (nodosVecinos != null) {
            for (Nodo nodo : nodosVecinos) {
                str.append(nodo.getId()).append(" - ").append(nodo.getNombre()).append(", ");
            }
            str.setLength(str.length() - 2); // Eliminar la última coma y espacio
        } else {
            str.append("null");
        }
        str.append("\n");
        str.append("Tripulantes vivos: ").append(tripulantesVivos).append("\n");
        str.append("Tareas pendientes: ").append(tareasPendientes).append("\n");
        if (mapaCompleto != null) {
            str.append("Mapa completo: ").append(mapaCompleto).append("\n");
        }
        str.append("Energia: ").append(energia).append("\n");
        return str.toString();
    }
}
