package tp03.ejercicio6;

public class NodoGenerico<T> {
	
	private T dato;
	private NodoGenerico<T> siguiente;


	public T getDato() {
		return dato;
	}

	public NodoGenerico<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoGenerico<T> siguiente) {
		this.siguiente = siguiente;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	

}
