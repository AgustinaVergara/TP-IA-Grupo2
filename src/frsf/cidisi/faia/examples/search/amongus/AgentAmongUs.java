package frsf.cidisi.faia.examples.search.amongus;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.examples.search.amongus.actions.MoverAmongUs;
import frsf.cidisi.faia.examples.search.amongus.actions.MatarAmongUs;
import frsf.cidisi.faia.examples.search.amongus.actions.SabotearAmongUs;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.Search;

public class AgentAmongUs extends SearchBasedAgent {

    private ObjetivoAmongUs goal;

    public AgentAmongUs() {
        // Among Us goal
        this.goal = new ObjetivoAmongUs();

        // Among Us agent state
        AgentStateAmongUs amongUsState = new AgentStateAmongUs();
        this.setAgentState(amongUsState);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        
        operators.addElement(new MatarAmongUs());
        operators.addElement(new SabotearAmongUs());
        // Use instances of the generic move action, so it is not necessary to create a class for each movement
        for (int i = 1; i <= 4; i++) {
            operators.addElement(new MoverAmongUs(i));
        }

       
        
        // Create the Problem which the Among Us will resolve
        Problem problem = new Problem(goal, (AgentStateAmongUs) amongUsState, operators);
        this.setProblem(problem);

        // Configure the agent solver
        //DepthFirstSearch estrategia = new DepthFirstSearch();
        //Search searchSolver = new Search(estrategia);
        //searchSolver.setVisibleTree(Search.XML_TREE);
        //this.setSolver(searchSolver);
    }

    /**
     * This method is executed by the simulator to ask the agent for an action.
     */
    @Override
    public Action selectAction() {
        // Create the search strategy
    	 
    	DepthFirstSearch strategy = new DepthFirstSearch();
        //BreathFirstSearch strategy = new BreathFirstSearch();
        

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        // Generate a file with the search tree
        searchSolver.setVisibleTree(Search.EFAIA_TREE);
        searchSolver.setVisibleTree(Search.XML_TREE);

        // Set the Search solver
        this.setSolver(searchSolver);
        

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            //ACA ES QUE EXPLOTA
        	System.out.println("busca accion");
            selectedAction = this.getSolver().solve(new Object[]{this.getProblem()});            
            
        } catch (Exception ex) {
            Logger.getLogger(AgentAmongUs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Return the selected action
        System.out.println("Accion:" + selectedAction);
        
        return selectedAction;
    }

    /**
     * This method is executed by the simulator to give the agent a perception.
     * Then it updates its state.
     */
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }

    @Override
    public String toString() {
        return "AgentAmongUs [goal=" + goal + ", state=" + state + ", solver=" + solver + "]";
    }
}
