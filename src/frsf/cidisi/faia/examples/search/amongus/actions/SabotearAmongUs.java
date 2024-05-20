package frsf.cidisi.faia.examples.search.amongus.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.examples.search.amongus.AgentStateAmongUs;
import frsf.cidisi.faia.examples.search.amongus.EnvironmentStateAmongUs;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class SabotearAmongUs extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		AgentStateAmongUs estadoAgente = (AgentStateAmongUs) s;
		 
		//En el nodo ubicacion del agente me fijo si tiene tarea y si la misma esta realizada o no
		if(estadoAgente.getUbicacion().getTarea() != null && !estadoAgente.getUbicacion().getTarea().getRealizada()) {
			//En el nodo de ubicacion del agente pongo la tarea realizada
			//System.out.println("rompi la maquina");
			estadoAgente.getUbicacion().getTarea().setRealizada(true);
			int aux = estadoAgente.getTareasPendientes() - 1;
			System.out.println(aux);
			estadoAgente.setEnergia(estadoAgente.getEnergia() - 1);
			estadoAgente.setTareasPendientes(aux);
			//En la lista de tareas del agente seteo la tarea como realizada
			estadoAgente.setTareaRealizada(estadoAgente.getUbicacion().getTarea().getNombre(), true);
			
			return estadoAgente;
		}
		;
		return null;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		
		AgentStateAmongUs estadoAgente = (AgentStateAmongUs) ast;
		EnvironmentStateAmongUs estadoAmbiente = (EnvironmentStateAmongUs)est;
		
		if(estadoAgente.getUbicacion().getTarea() != null) {
			estadoAmbiente.setEnergiaActual(estadoAmbiente.getEnergiaActual() - 1);
			estadoAmbiente.setTareasPendientes(estadoAmbiente.getTareasPendientes() -1 );
		}
		
		return estadoAmbiente;
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "sabotear";
	}

}
