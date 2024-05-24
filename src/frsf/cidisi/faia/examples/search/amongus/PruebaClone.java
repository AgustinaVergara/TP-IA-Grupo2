package frsf.cidisi.faia.examples.search.amongus;


import java.util.*;

import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class PruebaClone {
	
	public static void main(String[] args) {
	
	Map<Nodo, List<Nodo>> naveAgente = new LinkedHashMap<>();
    Tripulante t1 = new Tripulante(1,true,2);
    Tripulante t2 = new Tripulante(2,true,3);
    
    TareaAmongUs ta1 = new TareaAmongUs("Tarea",false);
    TareaAmongUs ta2 = new TareaAmongUs("Tarea",false);
    
    Nodo nodo1 = new Nodo(1, "Cafeteria");
    Nodo nodo2 = new Nodo(2, "Pasillo1");
    Nodo nodo3 = new Nodo(3, "Medbay");
    Nodo nodo4 = new Nodo(4, "UpperEngine");
    Nodo nodo5 = new Nodo(5, "Pasillo2");
    Nodo nodo6 = new Nodo(6, "Reactor");
    Nodo nodo7 = new Nodo(7, "Security");
    Nodo nodo8 = new Nodo(8, "LowerEngine");
    Nodo nodo9 = new Nodo(9, "Pasillo3");
    Nodo nodo10 = new Nodo(10, "Electrical");
    Nodo nodo11 = new Nodo(11, "Storage");
    Nodo nodo12 = new Nodo(12, "Pasillo5");
    Nodo nodo13 = new Nodo(13, "Pasillo4");
    Nodo nodo14 = new Nodo(14, "Communication");
    Nodo nodo15 = new Nodo(15, "Admin");
    Nodo nodo16 = new Nodo(16, "Shield");
    Nodo nodo17 = new Nodo(17, "Pasillo6");
    Nodo nodo18 = new Nodo(18, "Navigation");
    Nodo nodo19 = new Nodo(19, "O2");
    Nodo nodo20 = new Nodo(20, "Weapons");
    Nodo nodo21 = new Nodo(21, "Pasillo7");
    
    // Crear aristas
    naveAgente.put(nodo1, new ArrayList<>(Arrays.asList(nodo2, nodo12, nodo21)));
    naveAgente.put(nodo2, new ArrayList<>(Arrays.asList(nodo1, nodo3, nodo4)));
    naveAgente.put(nodo3, new ArrayList<>(Arrays.asList(nodo2)));
    naveAgente.put(nodo4, new ArrayList<>(Arrays.asList(nodo2, nodo5)));
    naveAgente.put(nodo5, new ArrayList<>(Arrays.asList(nodo4, nodo6, nodo7, nodo8)));
    naveAgente.put(nodo6, new ArrayList<>(Arrays.asList(nodo5)));
    naveAgente.put(nodo7, new ArrayList<>(Arrays.asList(nodo5)));
    naveAgente.put(nodo8, new ArrayList<>(Arrays.asList(nodo5, nodo9)));
    naveAgente.put(nodo9, new ArrayList<>(Arrays.asList(nodo8, nodo10, nodo11)));
    naveAgente.put(nodo10, new ArrayList<>(Arrays.asList(nodo9)));
    naveAgente.put(nodo11, new ArrayList<>(Arrays.asList(nodo9, nodo12, nodo13)));
    naveAgente.put(nodo12, new ArrayList<>(Arrays.asList(nodo1, nodo11, nodo15)));
    naveAgente.put(nodo13, new ArrayList<>(Arrays.asList(nodo11, nodo14, nodo16)));
    naveAgente.put(nodo14, new ArrayList<>(Arrays.asList(nodo13)));
    naveAgente.put(nodo15, new ArrayList<>(Arrays.asList(nodo12)));
    naveAgente.put(nodo16, new ArrayList<>(Arrays.asList(nodo13, nodo17)));
    naveAgente.put(nodo17, new ArrayList<>(Arrays.asList(nodo16, nodo18, nodo19, nodo20)));
    naveAgente.put(nodo18, new ArrayList<>(Arrays.asList(nodo17)));
    naveAgente.put(nodo19, new ArrayList<>(Arrays.asList(nodo17)));
    naveAgente.put(nodo20, new ArrayList<>(Arrays.asList(nodo17, nodo21)));
    naveAgente.put(nodo21, new ArrayList<>(Arrays.asList(nodo1, nodo20)));
    
    

    List<TareaAmongUs> tareas = new ArrayList<>(Arrays.asList(ta1, ta2));
    List<Tripulante> tripulantes = new ArrayList<>(Arrays.asList(t1, t2));
    List<Nodo> nodosVecinos = new ArrayList<>(Arrays.asList(nodo2, nodo3));
  
    Nodo ubicacion = nodo13;
    Integer energia = 90;
    Integer energiaInicial = 100;
    Integer tareasPendientes = 2;
    Integer tripulantesVivos = 4;

	
    AgentStateAmongUs original = new AgentStateAmongUs(naveAgente, ubicacion, energia, energiaInicial, tareas,tareasPendientes, 
    		tripulantesVivos, tripulantes, nodosVecinos);
	
	AgentStateAmongUs clon = (AgentStateAmongUs) original.clone();
	
	System.out.println("Original: " + original);
	System.out.println("Cloninal: " + clon);
	
		
	System.out.println("Original: " + original);
	System.out.println("Cloninal: " + clon);
	System.out.println("Ubicacion: " + clon.getUbicacion());
	System.out.println("nodos vecinos " +clon.getNodosVecinos());
}
}