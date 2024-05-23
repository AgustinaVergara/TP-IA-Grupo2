package frsf.cidisi.faia.examples.search.amongus;

import java.util.Random;

public class Tripulante implements Cloneable {
    
    private Integer id;
    private Boolean estaVivo;
    private Integer ciclosParaMoverse;
    
    public Tripulante(Integer id) {
        this.id = id;
        this.estaVivo = true;
        
        Random random = new Random();
        this.ciclosParaMoverse = random.nextInt(4);
    }
    
    
    public Tripulante(Integer id, Boolean estaVivo, Integer ciclosParaMoverse) {
		super();
		this.id = id;
		this.estaVivo = estaVivo;
		this.ciclosParaMoverse = ciclosParaMoverse;
	}


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEstaVivo() {
        return estaVivo;
    }

    public void setEstaVivo(Boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    public Integer getCiclosParaMoverse() {
        return ciclosParaMoverse;
    }

    public void setCiclosParaMoverse(Integer ciclosParaMoverse) {
        this.ciclosParaMoverse = ciclosParaMoverse;
    }

    @Override
    public String toString() {
        return "Tripulante{" +
                "id=" + id +
                ", estaVivo=" + estaVivo +
                ", ciclosParaMoverse=" + ciclosParaMoverse +
                '}';
    }
    @Override
    public Tripulante clone() {
    	
    	Integer nuevoId = this.getId();
    	Boolean nuevoEstaVivo = this.getEstaVivo();
    	Integer nuevoCiclosParaMoverse = this.getCiclosParaMoverse();
    	
    	Tripulante nuevoTripulante = new Tripulante(nuevoId, nuevoEstaVivo, nuevoCiclosParaMoverse);
        return nuevoTripulante;
    }
    
    // Constructor de copia profunda
    public Tripulante(Tripulante otro) {
        this.id = otro.id;
        this.estaVivo = new Boolean(otro.estaVivo);
        this.ciclosParaMoverse = otro.ciclosParaMoverse;
    }
}
