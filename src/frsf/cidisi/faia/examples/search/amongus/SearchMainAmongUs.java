package frsf.cidisi.faia.examples.search.amongus;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class SearchMainAmongUs {
	
	public static void main(String[] args) throws PrologConnectorException{
		//AmongUsAgent amongUsAgent  =  new AmongUsAgent();
		
		EnvironmentStateAmongUs  amongUsEnvironment = new EnvironmentStateAmongUs();
		System.out.println(amongUsEnvironment.toString());
		
		//SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(amongUsEnvironment, amongUsAgent);
		
		//simulator.start();
		
	}
	
}
