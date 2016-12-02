package tp03.ejercicio5;

public class SmartPhone extends Mobile{
	private int numero;
	
	
	public SmartPhone(){}
	
	public SmartPhone(int numero){
		this.numero = numero;
	}
	
	public SmartPhone (String marca, String sistemaOperativo, String modelo, int costo, int numero){
		super (marca, sistemaOperativo, modelo, costo);
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	

	@Override
	public String toString() {
		return (super.toString() + "- Numero:" + numero);
	}
	
	public boolean equals(Object o){
		boolean result=false;
		result = super.equals (o);
		if (!result){
			return result;
		}
		if (o instanceof SmartPhone){
			SmartPhone s = new SmartPhone();
			if (s.getNumero() != this.getNumero()){
				result= false;
			}
		}
		return result;
	}
	
}
