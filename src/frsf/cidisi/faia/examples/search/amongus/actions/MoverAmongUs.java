package frsf.cidisi.faia.examples.search.amongus.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.cidisi.faia.examples.search.amongus.*;

public class MoverAmongUs extends SearchAction{

	private int nodoSiguiente;
	
	public MoverAmongUs(int nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}
	

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		//Actualiza el estado del agente luego de moverse
		//ACA PONER LA LOGICA PARA QUE MUEVA AL SIGUIENTE NODO
		AgentStateAmongUs estadoAgente = (AgentStateAmongUs) s;
		
		//Como nodoSiguiente es un int hago un for sobre los nodos adyacente comparando los id cuando encuentre el que coincide hago el movimiento
		for(Nodo nodo : estadoAgente.getNodosVecinos(estadoAgente.getUbicacion())) {
			if((int)nodo.getId() == this.nodoSiguiente) {
				//Actualizo energia, ubicación 
				estadoAgente.setEnergia(estadoAgente.getEnergia() - 1);
				estadoAgente.setUbicacion(nodo);
				
				break;
			}
		}
		
		return estadoAgente;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		//Actualiza el estado del ambiente luego de moverse
		//ACA PONER LA LOGICA PARA ACTUALIZAR POSICION Y ENERGIA DEL AMBIENTE
		
		AgentStateAmongUs estadoAgente = (AgentStateAmongUs) ast;
		EnvironmentStateAmongUs estadoAmbiente = (EnvironmentStateAmongUs)est;
		
		for(Nodo nodo : estadoAgente.getNodosVecinos(estadoAgente.getUbicacion())) {
			if((int)nodo.getId() == this.nodoSiguiente) {
				
				estadoAmbiente.setEnergiaActual(estadoAgente.getEnergia() - 1);
				estadoAmbiente.setNodoActualAgente(nodo);
				//Para que no siga buscando coincidencias
				break;
			}
		}
		
		return estadoAmbiente;
	}

	@Override
	public String toString() {
		String str;
		
		str = "Moviendo a: " + this.nodoSiguiente;
		return str;
	}
	
}