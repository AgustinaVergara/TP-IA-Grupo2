package frsf.cidisi.faia.examples.search.amongus;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.examples.search.pacman.PacmanEnvironmentState;

public class EnvironmentAmongUs extends Environment{
	
	
	public EnvironmentAmongUs() {
		EnvironmentStateAmongUs environment = new EnvironmentStateAmongUs();
		this.environmentState = environment;
	}
	
	@Override
    public EnvironmentStateAmongUs getEnvironmentState() {
        return (EnvironmentStateAmongUs) super.getEnvironmentState();
    }

	
	@Override
	public Perception getPercept() {
		
		//aca controlamos si es la percepcion general o los adyacentes nada más 
		//en la percepcion general le pasamos el mapa entero y el se lo copia
		
		PerceptionAmongUs perception = new PerceptionAmongUs();


		return perception;
	}

}
