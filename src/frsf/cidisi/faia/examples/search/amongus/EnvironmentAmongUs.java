package frsf.cidisi.faia.examples.search.amongus;

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
        perception.setTripulantes(state.getTripulantes());
        perception.setTareas(state.getTareas());

        // Retornar la percepción actualizada
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
            Iterator<Tripulante> iterator = nodo.getListaTripulantes().iterator();
            while (iterator.hasNext()) {
                Tripulante tripulante = iterator.next();
                if (tripulante.getCiclosParaMoverse() > 0) {
                    tripulante.setCiclosParaMoverse(tripulante.getCiclosParaMoverse() - 1);
                } else {
                    List<Nodo> adyacentes = state.getNave().get(nodo);
                    if (!adyacentes.isEmpty()) {
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
