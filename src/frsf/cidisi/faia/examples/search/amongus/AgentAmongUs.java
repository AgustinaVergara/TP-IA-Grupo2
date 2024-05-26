package frsf.cidisi.faia.examples.search.amongus;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.io.IOException;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.examples.search.amongus.actions.MoverAmongUs;
import frsf.cidisi.faia.examples.search.amongus.actions.MatarAmongUs;
import frsf.cidisi.faia.examples.search.amongus.actions.SabotearAmongUs;
import frsf.cidisi.faia.solver.search.AStarSearch;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.Search;
import frsf.cidisi.faia.solver.search.UniformCostSearch;
import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;

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
        for (int i = 1; i <= 21; i++) {
            operators.addElement(new MoverAmongUs(i));
        }

       
        
        // Create the Problem which the Among Us will resolve
        Problem problem = new Problem(goal, (AgentStateAmongUs) amongUsState, operators);
        this.setProblem(problem);

    }

    /**
     * This method is executed by the simulator to ask the agent for an action.
     */
    @Override
    public Action selectAction() {
        // Create the search strategy
    	 
    	//DepthFirstSearch strategy = new DepthFirstSearch();
        //BreathFirstSearch strategy = new BreathFirstSearch();
    	//IStepCostFunction  costFunction = new CostFunction();
        //UniformCostSearch strategy= new UniformCostSearch(costFunction);
        
        IStepCostFunction cost = new CostFunction();
        IEstimatedCostFunction heuristic = new HeuristicaAmongUs();
        AStarSearch strategy = new AStarSearch(cost, heuristic);

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        // Generate a file with the search tree
        searchSolver.setVisibleTree(Search.EFAIA_TREE);
        //searchSolver.setVisibleTree(Search.XML_TREE);
        

        // Set the Search solver
        this.setSolver(searchSolver);
        

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            //ACA ES QUE EXPLOTA
            selectedAction = this.getSolver().solve(new Object[]{this.getProblem()});
            
        } catch (Exception ex) {
            Logger.getLogger(AgentAmongUs.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        
        //Guardo las acciones seleccionadas en un archivo
        if(selectedAction != null) {
        	log(selectedAction.toString());
        }else {
        	log("objetivoAlcanzado");
        }
        
        
        return selectedAction;
    }

    public static void log(String mensaje) {
        try {
            FileWriter writer = new FileWriter(SearchMainAmongUs.archivoLog, true); // true para añadir al final del archivo
            writer.write(mensaje + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            e.printStackTrace();
        }
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
