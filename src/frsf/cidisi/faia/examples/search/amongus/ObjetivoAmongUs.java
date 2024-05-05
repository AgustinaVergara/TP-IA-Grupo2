package frsf.cidisi.faia.examples.search.amongus;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoAmongUs extends GoalTest {
	
	@Override
	public boolean isGoalState(AgentState agentState) {
		if(((AgentStateAmongUs) agentState).getTripulantesVivos()==0 &&(((AgentStateAmongUs) agentState).getTareasPendientes() == 0)) {
			if(((AgentStateAmongUs) agentState).getEnergia()>=0) {
				return true;
			}else {
				return false; 
			}
		}
		return false;
	}

}
