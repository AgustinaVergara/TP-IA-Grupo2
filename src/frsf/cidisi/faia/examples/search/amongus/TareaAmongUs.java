package frsf.cidisi.faia.examples.search.amongus;

import java.util.Objects;

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
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TareaAmongUs other = (TareaAmongUs) obj;
        return Objects.equals(nombre, other.nombre) &&
               Objects.equals(realizada, other.realizada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, realizada);
    }
}

