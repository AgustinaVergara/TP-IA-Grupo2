package frsf.cidisi.faia.examples.search.amongus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
        perception.setNodoActualAgente(nodoActual.clone());

        // Establecer los nodos vecinos
        if (nodoActual != null) {
            List<Nodo> nodosVecinos = new ArrayList<>();
            for (Nodo neighbor : state.getNave().getOrDefault(nodoActual, new ArrayList<>())) {
                nodosVecinos.add(neighbor.clone());
            }
            perception.setNodosVecinos(nodosVecinos);
        }

        // Verificar si se debe pasar el mapa completo
        if (state.getProximaVisionGlobal() == 0) {
            Map<Nodo, List<Nodo>> mapaCompleto = new HashMap<>();
            for (Map.Entry<Nodo, List<Nodo>> entry : state.getNave().entrySet()) {
                Nodo key = entry.getKey().clone();
                List<Nodo> value = new ArrayList<>();
                for (Nodo neighbor : entry.getValue()) {
                    value.add(neighbor.clone());
                }
                mapaCompleto.put(key, value);
            }
            perception.setMapaCompleto(mapaCompleto);
        }

        // Establecer la cantidad de tripulantes vivos y tareas pendientes
        perception.setTripulantesVivos(state.getTripulantesVivos());
        perception.setTareasPendientes(state.getTareasPendientes());
        perception.setEnergia(state.getEnergiaActual());

        // Clonar la lista de tripulantes y tareas
        List<Tripulante> tripulantes = new ArrayList<>();
        for (Tripulante tripulante : state.getTripulantes()) {
            tripulantes.add(tripulante.clone());
        }
        perception.setTripulantes(tripulantes);

        List<TareaAmongUs> tareas = new ArrayList<>();
        for (TareaAmongUs tarea : state.getTareas()) {
            tareas.add(tarea.clone());
        }
        perception.setTareas(tareas);

        return perception;
    }


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
