package frsf.cidisi.faia.examples.search.amongus;

import java.io.File;
import java.io.IOException;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class SearchMainAmongUs {
	public static File archivoLog;
	public static void main(String[] args) throws PrologConnectorException{
		
		// Crear instancia del Agente:
		AgentAmongUs amongUsAgent  =  new AgentAmongUs();
		
		// Crear instancia de EnvironmentAmongUs
		EnvironmentAmongUs  amongUsEnvironment = new EnvironmentAmongUs();
		amongUsEnvironment.getEnvironmentState().initState();
		//((AgentStateAmongUs)amongUsAgent.getAgentState()).setUbicacion(((EnvironmentStateAmongUs)amongUsEnvironment.getEnvironmentState()).getNodoActualAgente());
		
		SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(amongUsEnvironment, amongUsAgent);
		
		
		//System.out.println(amongUsEnvironment.toString());
		 
		
		// Crear instancia del simulador:
		//SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(amongUsEnvironment, amongUsAgent);
		//faia en SearchBasedAgentSimulator pide EnvironmentAmongUs (el q extiende de Environment) y no EnvironmentStateAmongUs
		
		//simulator.start();
		try {
			  archivoLog = new File("logAcciones.txt");
		      if (archivoLog.createNewFile()) {
		        System.out.println("File created: " + archivoLog.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		simulator.start();
		
	}
	
}
