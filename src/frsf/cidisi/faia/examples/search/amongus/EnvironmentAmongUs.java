package frsf.cidisi.faia.examples.search.amongus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.*;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class EnvironmentAmongUs extends Environment {

    public EnvironmentAmongUs() {
        EnvironmentStateAmongUs environment = new EnvironmentStateAmongUs();
        this.environmentState = environment;
    }

    @Override
    public EnvironmentStateAmongUs getEnvironmentState() {
        return (EnvironmentStateAmongUs) super.getEnvironmentState();
    }
     
    @Override
    public Perception getPercept() {
        // Actualizar el estado de los tripulantes
        this.ciclosTripulantes();

        PerceptionAmongUs perception = new PerceptionAmongUs();
        EnvironmentStateAmongUs state = getEnvironmentState();

        // Obtener el nodo actual del agente
        Nodo nodoActual = state.getNodoActualAgente();
        perception.setNodoActualAgente(nodoActual);

        // Establecer los nodos vecinos
        if (nodoActual != null) {
        	
            perception.setNodosVecinos(state.getNave().get(nodoActual));
        }

        // Verificar si se debe pasar el mapa completo
        if (state.getProximaVisionGlobal() == 0) {
            perception.setMapaCompleto(state.getNave()); 
        }

        // Establecer la cantidad de tripulantes vivos y tareas pendientes
        perception.setTripulantesVivos(state.getTripulantesVivos());
        perception.setTareasPendientes(state.getTareasPendientes());
        perception.setEnergia(state.getEnergiaActual());
       
        perception.setTripulantes(state.getTripulantes());   
        perception.setTareas(state.getTareas());
        

        
        return perception;
    }
/*CHATGPT
    @Override
    public Perception getPercept() {
        // Actualizar el estado de los tripulantes
        this.ciclosTripulantes();

        PerceptionAmongUs perception = new PerceptionAmongUs();
        EnvironmentStateAmongUs state = getEnvironmentState();

        // Obtener el nodo actual del agente
        Nodo nodoActual = state.getNodoActualAgente();
        if (nodoActual != null) {
            perception.setNodoActualAgente(new Nodo(nodoActual)); // Asegúrate que Nodo tenga un constructor de copia
        }

        // Establecer los nodos vecinos
        if (nodoActual != null) {
            // Realizar una copia profunda del mapa de nodos vecinos
            List<Nodo> nodosVecinos = state.getNave().get(nodoActual)
                .stream()
                .map(Nodo::new) // Constructor de copia para Nodo
                .collect(Collectors.toList());
            perception.setNodosVecinos(nodosVecinos);
        }

        // Verificar si se debe pasar el mapa completo
        if (state.getProximaVisionGlobal() == 0) {
            // Realizar una copia profunda del mapa completo de la nave
            Map<Nodo, List<Nodo>> naveCopia = new HashMap<Nodo, List<Nodo>>();
            for (Map.Entry<Nodo, List<Nodo>> entry : state.getNave().entrySet()) {
                Nodo keyCopy = new Nodo(entry.getKey()); // Constructor de copia para Nodo
                List<Nodo> valueCopy = entry.getValue().stream().map(Nodo::new).collect(Collectors.toList()); // Copia profunda
                naveCopia.put(keyCopy, valueCopy);
            }
            perception.setMapaCompleto(naveCopia);
        }

        // Establecer la cantidad de tripulantes vivos y tareas pendientes
        perception.setTripulantesVivos((state.getTripulantesVivos())); // Copia profunda de la lista de tripulantes vivos
        perception.setTareasPendientes((state.getTareasPendientes())); // Copia profunda de la lista de tareas pendientes
        perception.setEnergia(state.getEnergiaActual());
       
        // Realizar copias profundas de las listas de tripulantes y tareas
        perception.setTripulantes(state.getTripulantes().stream().map(Tripulante::new).collect(Collectors.toList())); // Constructor de copia para Tripulante
        perception.setTareas(state.getTareas().stream().map(TareaAmongUs::new).collect(Collectors.toList())); // Constructor de copia para Tarea

        return perception;
    }

*/
    
    
    private void ciclosTripulantes() {
        EnvironmentStateAmongUs state = (EnvironmentStateAmongUs) this.environmentState;

        // Reducir el atributo proximaVisionGlobal
        if (state.getProximaVisionGlobal() > 0) {
            state.setProximaVisionGlobal(state.getProximaVisionGlobal() - 1);
        } else {
            state.setProximaVisionGlobal(new Random().nextInt(3) + 2);
        }

        for (Nodo nodo : state.getNave().keySet()) {
            List<Nodo> adyacentes = state.getNave().get(nodo);
            if (adyacentes != null && !adyacentes.isEmpty()) {
                Iterator<Tripulante> iterator = nodo.getListaTripulantes().iterator();
                while (iterator.hasNext()) {
                    Tripulante tripulante = iterator.next();
                    if (tripulante.getCiclosParaMoverse() > 0) {
                        tripulante.setCiclosParaMoverse(tripulante.getCiclosParaMoverse() - 1);
                    } else {
                        int randomIndex = new Random().nextInt(adyacentes.size());
                        Nodo nuevoNodo = adyacentes.get(randomIndex);
                        iterator.remove(); // Eliminar el tripulante del nodo actual
                        nuevoNodo.getListaTripulantes().add(tripulante); // Agregar el tripulante al nuevo nodo
                        tripulante.setCiclosParaMoverse(new Random().nextInt(3) + 1);
                    }
                }
            }
        }
    }
    

    @Override
    public String toString() {
        return environmentState.toString();
    }
}
