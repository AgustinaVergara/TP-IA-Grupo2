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
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.Search;

public class AgentAmongUs extends SearchBasedAgent {
    
    public AgentAmongUs() {
        // Objetivo Among Us 
        ObjetivoAmongUs objetivo = new ObjetivoAmongUs();

        // Among Us Agent State
        AgentStateAmongUs amongUsState = new AgentStateAmongUs();
        this.setAgentState(amongUsState);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        
        // De este modo utilizamos instancias de la accion Mover generica y no es necesario crear una clase para cada movimiento
        for(int i=1; i<=21; i++) {
            operators.addElement(new MoverAmongUs(i));
        }
        
        operators.addElement(new SabotearAmongUs());
        operators.addElement(new MatarAmongUs());

        // Create the Problem which the Among Us will resolve
        Problem problem = new Problem(objetivo, amongUsState, operators);
        this.setProblem(problem);
        
        // Configurar el solver del agente
        DepthFirstSearch estrategia = new DepthFirstSearch();
        Search searchSolver = new Search(estrategia);
        searchSolver.setVisibleTree(Search.XML_TREE);
        this.setSolver(searchSolver);
    }
    
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
    
    @Override
    public Action selectAction() {
        Action selectedAction = null;
        try {
            selectedAction = this.getSolver().solve(new Object[] {this.getProblem()});
        } catch (Exception e) {
            Logger.getLogger(AgentAmongUs.class.getName()).log(Level.SEVERE, null, e);
        }
        return selectedAction;
    }
}
