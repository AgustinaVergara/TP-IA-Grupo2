package frsf.cidisi.faia.examples.search.amongus;



import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;
import frsf.cidisi.faia.state.AgentState;

public class CostFunction implements IStepCostFunction {
	
	@Override
	public double calculateCost(NTree node) {
		AgentStateAmongUs agentStateAmongUs = ((AgentStateAmongUs) node.getAgentState());
		
		return agentStateAmongUs.getCost();
	}
	
	public double calculateCost(AgentState agentState) {
		
		return ((AgentStateAmongUs)agentState).getCost();
	}
}