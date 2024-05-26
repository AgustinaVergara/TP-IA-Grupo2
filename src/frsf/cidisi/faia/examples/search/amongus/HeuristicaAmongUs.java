package frsf.cidisi.faia.examples.search.amongus;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class HeuristicaAmongUs implements IEstimatedCostFunction {
	
	@Override
    public double getEstimatedCost(NTree node) {
        AgentStateAmongUs agentState = (AgentStateAmongUs) node.getAgentState();

        return (agentState.getTareasPendientes()+ agentState.getTripulantesVivos()) ;
    }

}