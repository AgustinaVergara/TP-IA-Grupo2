package frsf.cidisi.faia.examples.search.amongus;

import java.util.Random;

public class Tripulante {
    
    private Integer id;
    private Boolean estaVivo;
    private Integer ciclosParaMoverse;
    
    public Tripulante(Integer id) {
        this.id = id;
        this.estaVivo = true;
        
        Random random = new Random();
        this.ciclosParaMoverse = random.nextInt(4);
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
}
