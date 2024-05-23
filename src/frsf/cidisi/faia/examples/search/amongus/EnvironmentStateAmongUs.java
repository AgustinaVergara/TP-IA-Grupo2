package frsf.cidisi.faia.examples.search.amongus;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.*;

import frsf.cidisi.faia.state.EnvironmentState;

public class EnvironmentStateAmongUs extends EnvironmentState {
    // Definiciones de atributos
    private Integer energiaInicial;
    private Integer energiaActual;
    private Nodo ubicaciónInicial; //es necesario guardar la ubicacion inicial?
    private Nodo nodoActualAgente;
    private Integer tripulantesVivos;
    private Integer tareasPendientes;
    private Integer proximaVisionGlobal;
    private List<TareaAmongUs> tareas;
    private List<Tripulante> tripulantes;
    private Map<Nodo, List<Nodo>> nave;
    
    // Definiciones de nodos
    private Nodo nodo1;
    private Nodo nodo2;
    private Nodo nodo3;
    private Nodo nodo4;
    /*
    private Nodo nodo5;
    private Nodo nodo6;
    private Nodo nodo7;
    private Nodo nodo8;
    private Nodo nodo9;
    private Nodo nodo10;
    private Nodo nodo11;
    private Nodo nodo12;
    private Nodo nodo13;
    private Nodo nodo14;
    private Nodo nodo15;
    private Nodo nodo16;
    private Nodo nodo17;
    private Nodo nodo18;
    private Nodo nodo19;
    private Nodo nodo20;
    private Nodo nodo21;
*/
    // En este metodo configuro el estado inicial del juego
    public void initState() {
       /* // Representa el grafo, donde las claves son los nodos y los valores son listas de nodos adyacentes 
        nave = new HashMap<>();
        
        // Inicializar nodos
        nodo1 = new Nodo(1, "Cafeteria");
        nodo2 = new Nodo(2, "Pasillo1");
        nodo3 = new Nodo(3, "Medbay");
        nodo4 = new Nodo(4, "UpperEngine");
        nodo5 = new Nodo(5, "Pasillo2");
        nodo6 = new Nodo(6, "Reactor");
        nodo7 = new Nodo(7, "Security");
        nodo8 = new Nodo(8, "LowerEngine");
        nodo9 = new Nodo(9, "Pasillo3");
        nodo10 = new Nodo(10, "Electrical");
        nodo11 = new Nodo(11, "Storage");
        nodo12 = new Nodo(12, "Pasillo5");
        nodo13 = new Nodo(13, "Pasillo4");
        nodo14 = new Nodo(14, "Communication");
        nodo15 = new Nodo(15, "Admin");
        nodo16 = new Nodo(16, "Shield");
        nodo17 = new Nodo(17, "Pasillo6");
        nodo18 = new Nodo(18, "Navigation");
        nodo19 = new Nodo(19, "O2");
        nodo20 = new Nodo(20, "Weapons");
        nodo21 = new Nodo(21, "Pasillo7");
        
        // Crear aristas
        nave.put(nodo1, new ArrayList<>(Arrays.asList(nodo2, nodo12, nodo21)));
        nave.put(nodo2, new ArrayList<>(Arrays.asList(nodo1, nodo3, nodo4)));
        nave.put(nodo3, new ArrayList<>(Arrays.asList(nodo2)));
        nave.put(nodo4, new ArrayList<>(Arrays.asList(nodo2, nodo5)));
        nave.put(nodo5, new ArrayList<>(Arrays.asList(nodo4, nodo6, nodo7, nodo8)));
        nave.put(nodo6, new ArrayList<>(Arrays.asList(nodo5)));
        nave.put(nodo7, new ArrayList<>(Arrays.asList(nodo5)));
        nave.put(nodo8, new ArrayList<>(Arrays.asList(nodo5, nodo9)));
        nave.put(nodo9, new ArrayList<>(Arrays.asList(nodo8, nodo10, nodo11)));
        nave.put(nodo10, new ArrayList<>(Arrays.asList(nodo9)));
        nave.put(nodo11, new ArrayList<>(Arrays.asList(nodo9, nodo12, nodo13)));
        nave.put(nodo12, new ArrayList<>(Arrays.asList(nodo1, nodo11, nodo15)));
        nave.put(nodo13, new ArrayList<>(Arrays.asList(nodo11, nodo14, nodo16)));
        nave.put(nodo14, new ArrayList<>(Arrays.asList(nodo13)));
        nave.put(nodo15, new ArrayList<>(Arrays.asList(nodo12)));
        nave.put(nodo16, new ArrayList<>(Arrays.asList(nodo13, nodo17)));
        nave.put(nodo17, new ArrayList<>(Arrays.asList(nodo16, nodo18, nodo19, nodo20)));
        nave.put(nodo18, new ArrayList<>(Arrays.asList(nodo17)));
        nave.put(nodo19, new ArrayList<>(Arrays.asList(nodo17)));
        nave.put(nodo20, new ArrayList<>(Arrays.asList(nodo17, nodo21)));
        nave.put(nodo21, new ArrayList<>(Arrays.asList(nodo1, nodo20)));
        */
    	nave = new LinkedHashMap<>();
        
        // Inicializar nodos
        nodo1 = new Nodo(1, "Habitacion1");
        nodo2 = new Nodo(2, "Habitacion2");
        nodo3 = new Nodo(3, "Habitacion3");
        nodo4 = new Nodo(4, "Habitacion4");
        
        // Crear aristas
        nave.put(nodo1, new ArrayList<>(Arrays.asList(nodo2, nodo3))); // Habitacion1 conectada con Habitacion2 y Habitacion3
        nave.put(nodo2, new ArrayList<>(Arrays.asList(nodo1, nodo4))); // Habitacion2 conectada con Habitacion1 y Habitacion4
        nave.put(nodo3, new ArrayList<>(Arrays.asList(nodo1)));         // Habitacion3 conectada con Habitacion1
        nave.put(nodo4, new ArrayList<>(Arrays.asList(nodo2)));         // Habitacion4 conectada con Habitacion2
    
        // Asignar la posición inicial del agente
        List<Nodo> allNodes = new ArrayList<>(nave.keySet());
        int randomNodeIndex = new Random().nextInt(allNodes.size());
        Nodo nodoInicialAgente = allNodes.get(randomNodeIndex);
        this.nodoActualAgente = nodoInicialAgente;
        System.out.println("Nodo actual del agente: " + this.nodoActualAgente);
        energiaInicial = 100;
        energiaActual = energiaInicial;
        tripulantesVivos = 1;
        proximaVisionGlobal = 1; //primera percep global
        tareasPendientes = 2;
        
        generarObjetivos(tripulantesVivos);
    }

    public void generarObjetivos(int cantidadTripulantes) {
        ArrayList<Tripulante> listaTripulantes = new ArrayList<>();
        ArrayList<TareaAmongUs> listaTareas = new ArrayList<>();
        List<Nodo> allNodes = new ArrayList<>(nave.keySet());

        // Generar en posiciones aleatorias
        for (int i = 0; i < cantidadTripulantes; i++) {
            int randomNodeIndex = new Random().nextInt(allNodes.size());
            Nodo randomNode = allNodes.get(randomNodeIndex);
            Tripulante nuevoTripulante = new Tripulante(i);
            listaTripulantes.add(nuevoTripulante);
            randomNode.getListaTripulantes().add(nuevoTripulante);
        }
        
        Set<Integer> nodosAsignadosIndices = new HashSet<>();
        while (nodosAsignadosIndices.size() < tareasPendientes) {
            int randomNodeIndex = new Random().nextInt(allNodes.size());
            Nodo randomNode = allNodes.get(randomNodeIndex);

            if (!nodosAsignadosIndices.contains(randomNodeIndex)) {
                nodosAsignadosIndices.add(randomNodeIndex);
                TareaAmongUs nuevaTarea = new TareaAmongUs("Tarea Aleatoria");
                randomNode.setTarea(nuevaTarea);
                listaTareas.add(nuevaTarea);
            }
        }
        this.tripulantes = listaTripulantes;
        this.tareas=listaTareas;
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
        StringBuilder sb = new StringBuilder();

        // Iterar sobre cada nodo en el grafo
        for (Map.Entry<Nodo, List<Nodo>> entry : nave.entrySet()) {
            Nodo nodo = entry.getKey();
            List<Nodo> adyacentes = entry.getValue();

            // Agregar detalles del nodo
            sb.append("Nodo ID: ").append(nodo.getId()).append(", Nombre: ").append(nodo.getNombre()).append("\n");

            // Agregar detalles de los tripulantes en el nodo
            List<Tripulante> tripulantes = nodo.getListaTripulantes();
            sb.append("   Tripulantes: ");
            if (tripulantes.isEmpty()) {
                sb.append("Ninguno");
            } else {
                for (Tripulante tripulante : tripulantes) {
                    sb.append(tripulante.getId()).append(", ");
                }
                sb.setLength(sb.length() - 2); // Eliminar la coma extra al final
            }
            sb.append("\n");

            // Agregar detalles de la tarea asignada al nodo
            TareaAmongUs tarea = nodo.getTarea();
            if (tarea != null) {
                sb.append("   Tarea realizada: ").append(tarea.getRealizada()).append("\n");
            } else {
                sb.append("   Tarea: Ninguna\n");
            }

            // Agregar adyacentes
            sb.append("   Adyacentes: ");
            for (Nodo adyacente : adyacentes) {
                sb.append(adyacente.getId()).append(", ");
            }
            sb.setLength(sb.length() - 2); // Eliminar la coma extra al final
            sb.append("\n\n");
        }

        return sb.toString();
    }

    // Getters y setters
    public Integer getTripulantesVivos() {
        return tripulantesVivos;
    }

    public void setTripulantesVivos(Integer tripulantesVivos) {
        this.tripulantesVivos = tripulantesVivos;
    }

    public Integer getEnergiaActual() {
        return energiaActual;
    }

    public void setEnergiaActual(Integer energiaActual) {
        this.energiaActual = energiaActual;
    }

    public Integer getEnergiaInicial() {
        return energiaInicial;
    }

    public void setEnergiaInicial(Integer energiaInicial) {
        this.energiaInicial = energiaInicial;
    }

    public Nodo getUbicaciónInicial() {
        return ubicaciónInicial;
    }

    public void setUbicaciónInicial(Nodo ubicaciónInicial) {
        this.ubicaciónInicial = ubicaciónInicial;
    }

    public Nodo getNodoActualAgente() {
        return nodoActualAgente;
    }

    public void setNodoActualAgente(Nodo nodoActualAgente) {
        this.nodoActualAgente = nodoActualAgente;
    }

    public Integer getTareasPendientes() {
        return tareasPendientes;
    }

    public void setTareasPendientes(Integer tareasPendientes) {
        this.tareasPendientes = tareasPendientes;
    }

    public Integer getProximaVisionGlobal() {
        return proximaVisionGlobal;
    }

    public void setProximaVisionGlobal(Integer proximaVisionGlobal) {
        this.proximaVisionGlobal = proximaVisionGlobal;
    }

    public Map<Nodo, List<Nodo>> getNave() {
        return nave;
    }

    public void setNave(Map<Nodo, List<Nodo>> nave) {
        this.nave = nave;
    }
    public List<Nodo> getNodosVecinos(Nodo nodo) {
        // Verificar si el nodo está presente en el mapa de la nave
        if (nave.containsKey(nodo)) {
            // Devolver la lista de nodos vecinos del nodo dado
            return nave.get(nodo);
        } else {
            // El nodo no está presente en el mapa, retornar una lista vacía
            return new ArrayList<>();
        }
    }

}
