package tp03.ejercicio5;

public class Tablet extends Mobile{
	private int pulgadas;
	
	public Tablet (){};
	
	public Tablet (int pulgadas){
		super();
		this.pulgadas=pulgadas;
	}
	
	public Tablet (String marca, String sistemaOperativo, String modelo, int costo, int pulgadas){
		super (marca, sistemaOperativo, modelo, costo);
		this.pulgadas= pulgadas;
	}
	
	public int getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}
	
	@Override
	public String toString() {
		return (super.toString() + " - Pulgadas= " + pulgadas) ;
	}
	
}
