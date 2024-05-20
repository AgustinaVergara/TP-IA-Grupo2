package frsf.cidisi.faia.examples.search.amongus;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoAmongUs extends GoalTest {
	
	@Override
	public boolean isGoalState(AgentState agentState) {
	    if (((AgentStateAmongUs) agentState).getTripulantesVivos() == 0 &&
	            ((AgentStateAmongUs) agentState).getTareasPendientes() == 0 &&
	            ((AgentStateAmongUs) agentState).getEnergia() >= 0) {
	        return true;
	    } else if (((AgentStateAmongUs) agentState).getEnergia() == 0) {
	        return false;
	    } else {
	        return false;
	    }
	}

	 @Override
	    public String toString() {
	        return "ObjetivoAmongUs: Evaluates if the goal state is achieved based on the conditions: " +
	               "all crew members are dead, all tasks are completed, and energy is non-negative.";
	    }
}
