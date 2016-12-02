package tp03.ejercicio7;


import tp03.ejercicio6.ListaEnlazadaGenerica;

public class ColaGenerica<T> {
	private ListaEnlazadaGenerica<T> datos = new ListaEnlazadaGenerica<T>();
	
	public void encolar(T elem){
		datos.agregarFinal(elem);
	}
	
	public T desencolar() {
		T x = datos.elemento(1);
		datos.eliminarEn(1);
		return x;
	}
	
	public T tope(){
		return datos.elemento(1);
	}
	
	public boolean esVacia(){
		return datos.tamanio()==0;
	}
}
