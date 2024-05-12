package frsf.cidisi.faia.examples.search.amongus;

import java.util.List;
import java.util.Map;

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
	

	public AgentStateAmongUs(Map<Nodo, List<Nodo>> naveAgente, Nodo ubicacion, Integer energia, Integer energiaInicial,
			List<TareaAmongUs> tareas, Integer tareasPendientes, Integer tripulantesVivos,
			List<Tripulante> tripulantes) {
		super();
		this.naveAgente = naveAgente;
		this.ubicacion = ubicacion;
		this.energia = energia;
		this.energiaInicial = energiaInicial;
		this.tareas = tareas;
		this.tareasPendientes = tareasPendientes;
		this.tripulantesVivos = tripulantesVivos;
		this.tripulantes = tripulantes;
	}

	public AgentStateAmongUs() {
		//VER ESTE QUE TIENE QUE TENER PORQUE LO NECESITAMOS PARA LA CLASE AGENT AMONG US SIN ARGUMENTOS 
		// TODO Auto-generated constructor stub
		this.initState();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SearchBasedAgentState clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateState(Perception p) {
	    // Convertir la percepción a PerceptionAmongUs
	    PerceptionAmongUs percepcion = (PerceptionAmongUs) p;

	    // Actualizar la ubicación actual del agente
	    this.setUbicacion(percepcion.getNodoActualAgente());

	    // Obtener los nodos vecinos de la ubicación actual
	    List<Nodo> nodosVecinos = percepcion.getNodosVecinos();

	    // Recorrer los nodos vecinos y actualizar su información en la estructura `naveAgente`
	    for (Nodo nodoVecino : nodosVecinos) {
	        // Si el nodo vecino ya existe en la estructura `naveAgente`, actualizar su información
	        if (this.naveAgente.containsKey(nodoVecino)) {
	            // Obtener la información actual del nodo vecino de la estructura `naveAgente`
	            Nodo nodoVecinoEnNaveAgente = (Nodo) this.naveAgente.get(nodoVecino);

	      // Actualizar la información del nodo vecino en la estructura `naveAgente` utilizando la información de la percepción
	            nodoVecinoEnNaveAgente.setListaTripulantes(percepcion.getTripulantesEnNodo(nodoVecino));
	            nodoVecinoEnNaveAgente.setTarea(percepcion.getTareaEnNodo(nodoVecino));
	        }
	    }
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initState() {
		// TODO Auto-generated method stub
		
	}

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

}
