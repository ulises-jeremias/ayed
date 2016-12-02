package tp03.ejercicio5;

public abstract class Mobile {
	private String marca;
	private String sistemaOperativo;
	public String modelo;
	private int costo;
	
	public Mobile() {}; //CONSTRUCTOR NULO
	
	public Mobile(String marca, String sistemaOperativo, String modelo, int costo) {
		this.marca= marca;
		this.sistemaOperativo= sistemaOperativo;
		this.modelo= modelo;
		this.costo= costo;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getSistemaOperativo() {
		return sistemaOperativo;
	}
	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public boolean equals(Object o){
		boolean result=false;
		if ((o!=null) && (o instanceof Mobile)){
		Mobile m=(Mobile)o;
		if ((m.getMarca()==this.getMarca()) && (m.getSistemaOperativo()==this.getSistemaOperativo())&&(m.getModelo()==this.getModelo()) && (m.getCosto()==this.getCosto())) 
			result=true;
		}
		return result; }

	
	public String toString() {
		return ("Marca: " + marca + " - Sistema Operativo: " + sistemaOperativo + " - Modelo: " + modelo + " - Costo: $"
				+ costo);
	}
}
