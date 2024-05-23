package frsf.cidisi.faia.examples.search.amongus;


import java.util.*;

import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class PruebaClone {
	
	public static void main(String[] args) {
	
	Nodo nodo1 = new Nodo(1, "Habitacion1");
    Nodo nodo2 = new Nodo(2, "Habitacion2");
    Nodo nodo3 = new Nodo(3, "Habitacion3");
    Nodo nodo4 = new Nodo(4, "Habitacion4");
    
    Tripulante t1 = new Tripulante(1,true,2);
    Tripulante t2 = new Tripulante(2,true,3);
    
    TareaAmongUs ta1 = new TareaAmongUs("Tarea",false);
    TareaAmongUs ta2 = new TareaAmongUs("Tarea",false);
    
    Map<Nodo, List<Nodo>> naveAgente = new LinkedHashMap<>();
    naveAgente.put(nodo1, new ArrayList<>(Arrays.asList(nodo2, nodo3)));
    naveAgente.put(nodo2, new ArrayList<>(Arrays.asList(nodo1, nodo4)));
    naveAgente.put(nodo3, new ArrayList<>(Arrays.asList(nodo1)));
    naveAgente.put(nodo4, new ArrayList<>(Arrays.asList(nodo2)));
    

    List<TareaAmongUs> tareas = new ArrayList<>(Arrays.asList(ta1, ta2));
    List<Tripulante> tripulantes = new ArrayList<>(Arrays.asList(t1, t2));
    List<Nodo> nodosVecinos = new ArrayList<>(Arrays.asList(nodo2, nodo3));
  
    Nodo ubicacion = nodo1;
    Integer energia = 90;
    Integer energiaInicial = 100;
    Integer tareasPendientes = 2;
    Integer tripulantesVivos = 4;

	
    AgentStateAmongUs original = new AgentStateAmongUs(naveAgente, ubicacion, energia, energiaInicial, tareas,tareasPendientes, 
    		tripulantesVivos, tripulantes, nodosVecinos);
	
	AgentStateAmongUs clon = (AgentStateAmongUs) original.clone();
	
	System.out.println("Original: " + original);
	System.out.println("Cloninal: " + clon);
	
	clon.getUbicacion().setId(5);	
	System.out.println("Original: " + original);
	System.out.println("Cloninal: " + clon);
	System.out.println("Ubicacion: " + clon.getUbicacion());
	System.out.println("nodos vecinos " +clon.getNodosVecinos());
}
}