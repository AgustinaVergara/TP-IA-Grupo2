package frsf.cidisi.faia.examples.search.amongus;

import java.util.Vector;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.examples.search.amongus.actions.MoverAmongUs;
import frsf.cidisi.faia.examples.search.amongus.actions.MatarAmongUs;
import frsf.cidisi.faia.examples.search.amongus.actions.SabotearAmongUs;

public class AgentAmongUs extends SearchBasedAgent {
	
	public AgentAmongUs() {
		// Objetivo Among Us 
	    ObjetivoAmongUs objetivo = new ObjetivoAmongUs();

	    // Among Us Agent State
	    AgentStateAmongUs amongUsState = new AgentStateAmongUs();
	    this.setAgentState(amongUsState);
	    

	    // Create the operators
	    Vector<SearchAction> operators = new Vector<SearchAction>();
	    operators.addElement(new MoverAmongUs());
	    operators.addElement(new SabotearAmongUs());
	    operators.addElement(new MatarAmongUs());

	    // Create the Problem which the Pacman will resolve
	    Problem problem = new Problem(objetivo, amongUsState, operators);
	    this.setProblem(problem);
	}
    
	@Override
	public void see(Perception p) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Action selectAction() {
		// TODO Auto-generated method stub
		return null;
	}
   
	
}
