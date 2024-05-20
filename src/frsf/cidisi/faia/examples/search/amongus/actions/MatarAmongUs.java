package frsf.cidisi.faia.examples.search.amongus.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.examples.search.amongus.AgentStateAmongUs;
import frsf.cidisi.faia.examples.search.amongus.EnvironmentStateAmongUs;
import frsf.cidisi.faia.examples.search.amongus.Tripulante;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class MatarAmongUs extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		
		AgentStateAmongUs estadoAgente = (AgentStateAmongUs) s;
		 
		//Si quedan tripulantes vivos y hay tripulantes en la habitacion
		if(estadoAgente.getTripulantesVivos() > 0 && estadoAgente.getUbicacion().getListaTripulantes().size() != 0) {
			Tripulante tripulanteAMatar = estadoAgente.getUbicacion().getListaTripulantes().get(0);
			
			
			int aux = estadoAgente.getTripulantesVivos() - 1;
			
			estadoAgente.setTripulantesVivos(aux);
			
			tripulanteAMatar.setEstaVivo(false);
			estadoAgente.getUbicacion().getListaTripulantes().remove(tripulanteAMatar);
			estadoAgente.getTripulantes().remove(0);
			estadoAgente.setEnergia(estadoAgente.getEnergia()-1);
			return estadoAgente;
		}
		
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
		
		//Actualizo la energia y los tripulantes vivos
		estadoAmbiente.setEnergiaActual(estadoAgente.getEnergia() - 1);
		estadoAmbiente.setTripulantesVivos(estadoAmbiente.getTripulantesVivos()-1);
		
		
		return estadoAmbiente;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "matar";
	}
	
	

}