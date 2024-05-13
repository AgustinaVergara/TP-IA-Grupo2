package frsf.cidisi.faia.examples.search.amongus;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class SearchMainAmongUs {
	
	public static void main(String[] args) throws PrologConnectorException{
		
		// Crear instancia del Agente:
		//AgentAmongUs amongUsAgent  =  new AgentAmongUs();
		
		// Crear instancia de EnvironmentAmongUs
		//EnvironmentAmongUs  amongUsEnvironment = new EnvironmentAmongUs();
		
		EnvironmentStateAmongUs  amongUsEnvironment = new EnvironmentStateAmongUs(6); //
		System.out.println(amongUsEnvironment.toString());
		
		// Crear instancia del simulador:
		//SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(amongUsEnvironment, amongUsAgent);
		//faia en SearchBasedAgentSimulator pide EnvironmentAmongUs (el q extiende de Environment) y no EnvironmentStateAmongUs
		
		//simulator.start();
		
	}
	
}
