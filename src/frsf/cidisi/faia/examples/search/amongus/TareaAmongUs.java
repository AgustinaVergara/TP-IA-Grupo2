package frsf.cidisi.faia.examples.search.amongus;

public class TareaAmongUs implements Cloneable{
    
    private String nombre;
    private Boolean realizada;
    
    public TareaAmongUs(String nombre) {
        this.nombre = nombre;
        this.realizada = false;
    }
    
    
    public TareaAmongUs(String nombre, Boolean realizada) {
		super();
		this.nombre = nombre;
		this.realizada = realizada;
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
    public TareaAmongUs clone() {
        String nuevoNombre = this.getNombre();
        Boolean nuevoRealizada = this.getRealizada();
        
        TareaAmongUs nuevaTarea = new TareaAmongUs(nuevoNombre, nuevoRealizada);
        return nuevaTarea;
    }
    
    
}

