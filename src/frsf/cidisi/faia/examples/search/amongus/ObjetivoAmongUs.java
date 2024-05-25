package frsf.cidisi.faia.examples.search.amongus;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoAmongUs extends GoalTest {
	
	@Override
	public boolean isGoalState(AgentState agentState) {
		AgentStateAmongUs estadoAgente = (AgentStateAmongUs) agentState;
//		System.out.println("energia:"+estadoAgente.getEnergia());
//		System.out.println("tareas: "+estadoAgente.getTareasPendientes());
//		System.out.println("tripulantes"+estadoAgente.getTripulantesVivos());
		if(estadoAgente.getEnergia() > 0) {
			if(estadoAgente.getTareasPendientes() == 0) {
				if(estadoAgente.getTripulantesVivos() == 0) {
					return true;
				}
				return false;
			}
			return false;
		}else {
			return false;
		}
		
	}
	
	 @Override
	    public String toString() {
	        return "ObjetivoAmongUs: Evaluates if the goal state is achieved based on the conditions: " +
	               "all crew members are dead, all tasks are completed, and energy is non-negative.";
	    }
}
