package tp03.ejercicio7;

import tp03.ejercicio6.ListaEnlazadaGenerica;

public class PilaGenerica<T> {
	private ListaEnlazadaGenerica<T> datos = new ListaEnlazadaGenerica<T>();
	
	public void apilar(T elem){
		datos.agregarEn(elem, 1);
	}
	
	public T desapilar(){
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
