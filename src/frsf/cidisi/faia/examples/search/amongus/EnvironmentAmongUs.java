package frsf.cidisi.faia.examples.search.amongus;

import java.util.List;
import java.util.Random;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.examples.search.pacman.PacmanEnvironmentState;

public class EnvironmentAmongUs extends Environment{
	
	
	public EnvironmentAmongUs() {
		EnvironmentStateAmongUs environment = new EnvironmentStateAmongUs(6);
		this.environmentState = environment;
	}
	
	@Override
    public EnvironmentStateAmongUs getEnvironmentState() {
        return (EnvironmentStateAmongUs) super.getEnvironmentState();
    }

	
	@Override
	public Perception getPercept() {
		
		//aca controlamos si es la percepcion general o los adyacentes nada más 
		//en la percepcion general le pasamos el mapa entero y el se lo copia|
		
		this.ciclosTripulantes();
		PerceptionAmongUs perception = new PerceptionAmongUs();
		
		EnvironmentStateAmongUs state = getEnvironmentState();

	    // Obtener el nodo actual del agente
	    Nodo nodoActual = null;
	    for (Nodo nodo : state.getNave().keySet()) {
	        if (nodo.getId() == state.getNodoActualAgente()) {
	            nodoActual = nodo;
	            break;
	        }
	    }

	    // Establecer los nodos vecinos
	    perception.setNodosVecinos(state.getNave().get(nodoActual));

	    // Establecer el nodo actual del agente
	    perception.setNodoActualAgente(nodoActual);

	    // Retornar la percepción actualizada
	    return perception;
	}
	
	private void ciclosTripulantes() {//agregar el avance de los ciclso hasta percepcion magica
		
	    for (Nodo nodo : ((EnvironmentStateAmongUs)this.environmentState).getNave().keySet()) {
	        List<Tripulante> tripulantes = nodo.getListaTripulantes();
	        
	        for (Tripulante tripulante : tripulantes) {
	            if (tripulante.getCiclosParaMoverse() > 0) { // Si todavía no se tiene que mover, resto uno
	                tripulante.setCiclosParaMoverse(tripulante.getCiclosParaMoverse() - 1);
	            } else { // Si se tiene que mover
	                List<Nodo> adyacentes = ((EnvironmentStateAmongUs)this.environmentState).getNave().get(nodo);
	                // Mover el tripulante a un nodo adyacente aleatorio
	                int randomIndex = new Random().nextInt(adyacentes.size());
	                Nodo nuevoNodo = adyacentes.get(randomIndex);

	                // Quitar el tripulante del nodo actual y agregarlo al nuevo nodo
	                nodo.getListaTripulantes().remove(tripulante);
	                nuevoNodo.getListaTripulantes().add(tripulante);

	                // Asignar el nuevo nodo como nodo actual del tripulante
	                tripulante.setCiclosParaMoverse(new Random().nextInt(3) + 1); // Setear un random entre 1 y 3 para los ciclos
	            }
	        }
	    }
	}

}
