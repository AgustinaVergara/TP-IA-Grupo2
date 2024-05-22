package frsf.cidisi.faia.examples.search.amongus;

public class TareaAmongUs {
    
    private String nombre;
    private Boolean realizada;
    
    public TareaAmongUs(String nombre) {
        this.nombre = nombre;
        this.realizada = false;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(Boolean realizada) {
        this.realizada = realizada;
    }

    @Override
    public String toString() {
        return "TareaAmongUs{" +
                "nombre='" + nombre + '\'' +
                ", realizada=" + realizada +
                '}';
    }
    
    public TareaAmongUs clone() {
        TareaAmongUs cloned = new TareaAmongUs(this.nombre);
        cloned.setRealizada(this.realizada);
        return cloned;
    }
}

