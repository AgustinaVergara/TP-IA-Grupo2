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
        //Un LinkedHashMap mantiene el orden de inserción de los elementos, lo que garantiza que las entradas se almacenen y se 
        //recuperen en el mismo orden en que se agregaron.
        this.naveAgente = new LinkedHashMap<>(naveAgente);
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
               Objects.equals(tareasPendientes, other.tareasPendientes) &&
               Objects.equals(tripulantesVivos, other.tripulantesVivos);
    }
   /*
    @Override
    public SearchBasedAgentState clone() {
    
        return new AgentStateAmongUs(
        		new HashMap<> (this.naveAgente),
                this.ubicacion,
                this.energia,
                this.energiaInicial,
                new ArrayList<>(this.tareas),
                this.tareasPendientes,
                this.tripulantesVivos,
                new ArrayList<>(this.tripulantes),
                new ArrayList<>(this.nodosVecinos)
        );
    }
   */ 
   
    
    //MI METODO CLONAR
    
    private static List<Nodo> clonarListaNodos(List<Nodo> listaNodos) {
        List<Nodo> nuevaLista = new ArrayList<>();
        for (Nodo nodo : listaNodos) {
            nuevaLista.add(nodo.clone());
        }
        return nuevaLista;
    }
    @Override
    public SearchBasedAgentState clone() {
    	
    	Nodo nuevaUbicacion = this.getUbicacion().clone();
    	Integer nuevaEnergia = this.getEnergia(); 
		Integer nuevaEnergiaInicial = this.getEnergiaInicial();
		Integer nuevaTareasPendientes = this.getTareasPendientes();
		Integer nuevaTripulantesVivos = this.getTripulantesVivos();
		
		//Clonar mapa 
    	Map<Nodo,List<Nodo>> nuevaNaveAgente = new LinkedHashMap<>();
    	for (Map.Entry<Nodo, List<Nodo>> entry : naveAgente.entrySet()) {
            Nodo claveClonada = entry.getKey().clone();
            List<Nodo> valorClonado = clonarListaNodos(entry.getValue());
            nuevaNaveAgente.put(claveClonada, valorClonado);
        }
    	
		//Clonar listas
		
		List<TareaAmongUs> nuevaTareas= new ArrayList<>();
		for(TareaAmongUs tarea : this.getTareas()) {
			nuevaTareas.add(tarea.clone());
		}
		List<Tripulante> nuevaTripulantes= new ArrayList<>();
        for(Tripulante t : this.getTripulantes()) {
        	nuevaTripulantes.add(t.clone());
        }
		
		List<Nodo> nuevaNodosVecinos= new ArrayList<>();
        for (Nodo nodo : this.getNodosVecinos()) {
        	nuevaNodosVecinos.add(nodo.clone());
        }
    	
    	AgentStateAmongUs nuevoEstadoAgente = new AgentStateAmongUs(nuevaNaveAgente, nuevaUbicacion, nuevaEnergia, 
    			nuevaEnergiaInicial,nuevaTareas, nuevaTareasPendientes, nuevaTripulantesVivos,
                nuevaTripulantes, nuevaNodosVecinos);
    	//System.out.println(this);
    	//System.out.println(nuevoEstadoAgente);
        return nuevoEstadoAgente;
    }
     
    
    @Override
    public void updateState(Perception p) {
        PerceptionAmongUs percepcion = (PerceptionAmongUs) p;
        

        if (percepcion.getMapaCompleto() != null) {
            this.naveAgente = new LinkedHashMap<>(percepcion.getMapaCompleto());
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
        //this.naveAgente = new HashMap<>();
        this.ubicacion = null;
        this.energia = 1;
        this.energiaInicial = 1;
        this.tareas = new ArrayList<>();
        this.tareasPendientes = 0;
        this.tripulantesVivos = 0;
        this.tripulantes = new ArrayList<>();
        this.nodosVecinos = new ArrayList<>();
        
        this.naveAgente = new HashMap<>();
        
        // Inicializar nodos
        Nodo nodo1 = new Nodo(1, "Habitacion1");
        Nodo nodo2 = new Nodo(2, "Habitacion2");
        Nodo nodo3 = new Nodo(3, "Habitacion3");
        Nodo nodo4 = new Nodo(4, "Habitacion4");
        
        // Crear aristas
        naveAgente.put(nodo1, new ArrayList<>(Arrays.asList(nodo2, nodo3))); // Habitacion1 conectada con Habitacion2 y Habitacion3
        naveAgente.put(nodo2, new ArrayList<>(Arrays.asList(nodo1, nodo4))); // Habitacion2 conectada con Habitacion1 y Habitacion4
        naveAgente.put(nodo3, new ArrayList<>(Arrays.asList(nodo1)));         // Habitacion3 conectada con Habitacion1
        naveAgente.put(nodo4, new ArrayList<>(Arrays.asList(nodo2)));         // Habitacion4 conectada con Habitacion2
    
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
    	List<Nodo> nodosAsociados = naveAgente.get(nodo);
    	System.out.println("nodos"+nodosAsociados);
        return nodosAsociados;
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
