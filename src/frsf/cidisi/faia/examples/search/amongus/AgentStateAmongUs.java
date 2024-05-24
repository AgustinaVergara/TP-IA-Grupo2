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
	private Nodo nodo1;
	private Nodo nodo2;
	private Nodo nodo3;
	private Nodo nodo4;
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

	public AgentStateAmongUs(Map<Nodo, List<Nodo>> naveAgente, Nodo ubicacion, Integer energia, Integer energiaInicial,
			List<TareaAmongUs> tareas, Integer tareasPendientes, Integer tripulantesVivos, List<Tripulante> tripulantes,
			List<Nodo> nodosVecinos) {
		super();
		// Un LinkedHashMap mantiene el orden de inserción de los elementos, lo que
		// garantiza que las entradas se almacenen y se recuperen en el mismo orden en que se agregaron.
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
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		AgentStateAmongUs other = (AgentStateAmongUs) obj;
		return Objects.equals(naveAgente, other.naveAgente) && Objects.equals(ubicacion, other.ubicacion)
				&& Objects.equals(tareasPendientes, other.tareasPendientes)
				&& Objects.equals(tripulantesVivos, other.tripulantesVivos);
	}

	// Metodo clonar

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

		// Clonar mapa
		Map<Nodo, List<Nodo>> nuevaNaveAgente = new LinkedHashMap<>();
		for (Map.Entry<Nodo, List<Nodo>> entry : naveAgente.entrySet()) {
			Nodo claveClonada = entry.getKey().clone();
			List<Nodo> valorClonado = clonarListaNodos(entry.getValue());
			nuevaNaveAgente.put(claveClonada, valorClonado);
		}

		// Clonar listas

		List<TareaAmongUs> nuevaTareas = new ArrayList<>();
		for (TareaAmongUs tarea : this.getTareas()) {
			nuevaTareas.add(tarea.clone());
		}
		List<Tripulante> nuevaTripulantes = new ArrayList<>();
		for (Tripulante t : this.getTripulantes()) {
			nuevaTripulantes.add(t.clone());
		}

		List<Nodo> nuevaNodosVecinos = new ArrayList<>();
		for (Nodo nodo : this.getNodosVecinos()) {
			nuevaNodosVecinos.add(nodo.clone());
		}

		AgentStateAmongUs nuevoEstadoAgente = new AgentStateAmongUs(nuevaNaveAgente, nuevaUbicacion, nuevaEnergia,
				nuevaEnergiaInicial, nuevaTareas, nuevaTareasPendientes, nuevaTripulantesVivos, nuevaTripulantes,
				nuevaNodosVecinos);
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
		return "AgentStateAmongUs{" + "naveAgente=" + naveAgente + ", ubicacion=" + ubicacion + ", energia=" + energia
				+ ", energiaInicial=" + energiaInicial + ", tareas=" + tareas + ", tareasPendientes=" + tareasPendientes
				+ ", tripulantesVivos=" + tripulantesVivos + ", tripulantes=" + tripulantes + ", nodosVecinos="
				+ nodosVecinos + '}';
	}

	@Override
	public void initState() {
		this.ubicacion = null;
		this.energia = 50;
		this.energiaInicial = 50;
		this.tareas = new ArrayList<>();
		this.tareasPendientes = 0;
		this.tripulantesVivos = 0;
		this.tripulantes = new ArrayList<>();
		this.nodosVecinos = new ArrayList<>();

		this.naveAgente = new LinkedHashMap<>();

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
		naveAgente.put(nodo1, new ArrayList<>(Arrays.asList(nodo2, nodo12, nodo21)));
		naveAgente.put(nodo2, new ArrayList<>(Arrays.asList(nodo1, nodo3, nodo4)));
		naveAgente.put(nodo3, new ArrayList<>(Arrays.asList(nodo2)));
		naveAgente.put(nodo4, new ArrayList<>(Arrays.asList(nodo2, nodo5)));
		naveAgente.put(nodo5, new ArrayList<>(Arrays.asList(nodo4, nodo6, nodo7, nodo8)));
		naveAgente.put(nodo6, new ArrayList<>(Arrays.asList(nodo5)));
		naveAgente.put(nodo7, new ArrayList<>(Arrays.asList(nodo5)));
		naveAgente.put(nodo8, new ArrayList<>(Arrays.asList(nodo5, nodo9)));
		naveAgente.put(nodo9, new ArrayList<>(Arrays.asList(nodo8, nodo10, nodo11)));
		naveAgente.put(nodo10, new ArrayList<>(Arrays.asList(nodo9)));
		naveAgente.put(nodo11, new ArrayList<>(Arrays.asList(nodo9, nodo12, nodo13)));
		naveAgente.put(nodo12, new ArrayList<>(Arrays.asList(nodo1, nodo11, nodo15)));
		naveAgente.put(nodo13, new ArrayList<>(Arrays.asList(nodo11, nodo14, nodo16)));
		naveAgente.put(nodo14, new ArrayList<>(Arrays.asList(nodo13)));
		naveAgente.put(nodo15, new ArrayList<>(Arrays.asList(nodo12)));
		naveAgente.put(nodo16, new ArrayList<>(Arrays.asList(nodo13, nodo17)));
		naveAgente.put(nodo17, new ArrayList<>(Arrays.asList(nodo16, nodo18, nodo19, nodo20)));
		naveAgente.put(nodo18, new ArrayList<>(Arrays.asList(nodo17)));
		naveAgente.put(nodo19, new ArrayList<>(Arrays.asList(nodo17)));
		naveAgente.put(nodo20, new ArrayList<>(Arrays.asList(nodo17, nodo21)));
		naveAgente.put(nodo21, new ArrayList<>(Arrays.asList(nodo1, nodo20)));
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
