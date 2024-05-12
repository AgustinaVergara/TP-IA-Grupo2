package frsf.cidisi.faia.examples.search.amongus;

import java.util.List;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PerceptionAmongUs extends Perception {

    private Nodo nodoActualAgente;
    private List<Nodo> nodosVecinos;

    public PerceptionAmongUs(Agent agent, Environment environment) {
        super(agent, environment);
    }
    public PerceptionAmongUs() {
        super(); // Call the superclass constructor (optional)
    }

    @Override
    public void initPerception(Agent agent, Environment environment) {
    	EnvironmentAmongUs amongUsEnvironment = (EnvironmentAmongUs) environment;
    	EnvironmentStateAmongUs amongUsEnvironmentState = amongUsEnvironment.getEnvironmentState();
    	Nodo nodoActualAgente = amongUsEnvironmentState.getNodoActualAgente(); // Get agent's location
    	List<Nodo> nodosVecinos = amongUsEnvironmentState.getNave().get(nodoActualAgente); // Get neighbors from the map
    	this.nodoActualAgente = nodoActualAgente;
    	this.nodosVecinos = nodosVecinos;
        
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

    // Access information directly from neighboring nodes
    public List<Tripulante> getTripulantesEnNodo(Nodo nodo) {
        return nodo.getListaTripulantes();
    }

    public TareaAmongUs getTareaEnNodo(Nodo nodo) {
        return nodo.getTarea();
    }

    public String getNombreNodo(Nodo nodo) {
        return nodo.getNombre();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Estado percepcion Among Us\n");
        str.append("Nodo actual: ").append(nodoActualAgente.getId()).append(" - ").append(getNombreNodo(nodoActualAgente)).append("\n");
        str.append("Nodos vecinos: ");
        for (Nodo nodo : nodosVecinos) {
            str.append(nodo.getId()).append(" - ").append(getNombreNodo(nodo)).append(", ");
        }
        str.setLength(str.length() - 2); // Remove trailing comma and space
        str.append("\n");
        return str.toString();
    }
}