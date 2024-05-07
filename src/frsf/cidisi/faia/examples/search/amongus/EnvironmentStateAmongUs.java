package frsf.cidisi.faia.examples.search.amongus;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.*;


import frsf.cidisi.faia.state.EnvironmentState;

public class EnvironmentStateAmongUs extends EnvironmentState{
	
	private Integer energiaInicial;
	private Nodo ubicaciónInicial; 
	private Map<Nodo, List<Nodo>> nave;
	
	private Nodo nodo1;
	private Nodo nodo2;
	private Nodo nodo3;
	private Nodo nodo4;
	private Nodo nodo5;
	private Nodo nodo6;
	private Nodo nodo7;
	private Nodo nodo8;
	private Nodo nodo9;
	private Nodo nodo10;
	private Nodo nodo11;
	private Nodo nodo12;
	private Nodo nodo13;
	private Nodo nodo14;
	private Nodo nodo15;
	private Nodo nodo16;
	private Nodo nodo17;
	private Nodo nodo18;
	private Nodo nodo19;
	private Nodo nodo20;
	private Nodo nodo21;
	
	//Constructors
	public EnvironmentStateAmongUs() {
		super();
		//Representa el grafo, donde las claves son los nodos y los valores son listas de nodos adyacentes 
		nave = new HashMap<>();
		
		//Inicializar nodos
		this.nodo1 = new Nodo(1,"Cafeteria");
		this.nodo2 = new Nodo(2,"Pasillo1");
		this.nodo3 = new Nodo(3,"Medbay");
		this.nodo4 = new Nodo(4,"UpperEngine");
		this.nodo5 = new Nodo(5,"Pasillo2");
		this.nodo6 = new Nodo(6,"Reactor");
		this.nodo7 = new Nodo(7,"Security");
		this.nodo8 = new Nodo(8,"LowerEngine");
		this.nodo9 = new Nodo(9,"Pasillo3");
		this.nodo10 = new Nodo(10,"Electrical");
		this.nodo11 = new Nodo(11,"Storage");
		this.nodo12 = new Nodo(12,"Pasillo5");
		this.nodo13 = new Nodo(13,"Pasillo4");
		this.nodo14 = new Nodo(14,"Communication");
		this.nodo15 = new Nodo(15,"Admin");
		this.nodo16 = new Nodo(16,"Shield");
		this.nodo17 = new Nodo(17,"Pasillo6");
		this.nodo18 = new Nodo(18,"Navigation");
		this.nodo19 = new Nodo(19,"O2");
		this.nodo20 = new Nodo(20,"Weapons");
		this.nodo21 = new Nodo(21,"Pasillo7");
		
		//Crear aristas
		//Utilizo put(nodo, new ArrayList<>()) --> put es una funcion de HashMap que  agrega una nueva entrada al mapa nave
		nave.put(nodo1, new ArrayList<>(Arrays.asList(nodo2, nodo12, nodo21)));
		nave.put(nodo2, new ArrayList<>(Arrays.asList(nodo1, nodo3, nodo4)));
		nave.put(nodo3, new ArrayList<>(Arrays.asList(nodo2)));
		nave.put(nodo4, new ArrayList<>(Arrays.asList(nodo2,nodo5)));
		nave.put(nodo5, new ArrayList<>(Arrays.asList(nodo4, nodo6, nodo7, nodo8)));
		nave.put(nodo6, new ArrayList<>(Arrays.asList(nodo5)));
		nave.put(nodo7, new ArrayList<>(Arrays.asList(nodo5)));
		nave.put(nodo8, new ArrayList<>(Arrays.asList(nodo5, nodo9)));
		nave.put(nodo9, new ArrayList<>(Arrays.asList(nodo8, nodo10, nodo11)));
		nave.put(nodo10, new ArrayList<>(Arrays.asList(nodo9)));
		nave.put(nodo11, new ArrayList<>(Arrays.asList(nodo9, nodo12, nodo13)));
		nave.put(nodo12, new ArrayList<>(Arrays.asList(nodo1, nodo11, nodo15)));
		nave.put(nodo13, new ArrayList<>(Arrays.asList(nodo11,nodo14,nodo16)));
		nave.put(nodo14, new ArrayList<>(Arrays.asList(nodo13)));
		nave.put(nodo15, new ArrayList<>(Arrays.asList(nodo12)));
		nave.put(nodo16, new ArrayList<>(Arrays.asList(nodo13, nodo17)));
		nave.put(nodo17, new ArrayList<>(Arrays.asList(nodo16, nodo18, nodo19, nodo20)));
		nave.put(nodo18, new ArrayList<>(Arrays.asList(nodo17)));
		nave.put(nodo19, new ArrayList<>(Arrays.asList(nodo17)));
		nave.put(nodo20, new ArrayList<>(Arrays.asList(nodo17, nodo21)));
		nave.put(nodo21, new ArrayList<>(Arrays.asList(nodo1, nodo20)));
		
		this.initState();
	
	}
	
	@Override
	public void initState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

	    // Iterar sobre cada nodo en el grafo
	    for (Map.Entry<Nodo, List<Nodo>> entry : nave.entrySet()) {
	        Nodo nodo = entry.getKey();
	        List<Nodo> adyacentes = entry.getValue();
	        
	        // Agregar el nodo y sus adyacentes a la representación del grafo
	        sb.append(nodo.toString()).append(" -> ");
	        for (Nodo adyacente : adyacentes) {
	            sb.append(adyacente.toString()).append(", ");
	        }
	        sb.append("\n");
	    }

	    return sb.toString();
	}

}
