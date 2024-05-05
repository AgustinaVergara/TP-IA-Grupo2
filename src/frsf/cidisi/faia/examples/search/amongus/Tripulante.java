package frsf.cidisi.faia.examples.search.amongus;

public class Tripulante {
	
	private Integer id;
	private Nodo ubicacion;
	private Boolean estaVivo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Nodo getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Nodo ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Boolean getEstaVivo() {
		return estaVivo;
	}
	public void setEstaVivo(Boolean estaVivo) {
		this.estaVivo = estaVivo;
	}

}
