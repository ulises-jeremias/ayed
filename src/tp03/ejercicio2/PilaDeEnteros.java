package tp03.ejercicio2;

import tp03.ejercicio1.ListaDeEnteros;
import tp03.ejercicio1.ListaDeEnterosEnlazada;

public class PilaDeEnteros {
	ListaDeEnteros datos = new ListaDeEnterosEnlazada();
	
	public PilaDeEnteros(){
		datos.agregarEn(null, 1);
	}
	
	public void apilar(Integer elem){
		datos.agregarInicio(elem);
	}
	
	public int desapilar(){
		int x = datos.elemento(datos.tamanio());
		datos.eliminarEn(datos.tamanio());
		return x;
	}
	
	public int tope(){
		return datos.elemento(datos.tamanio());
	}
	
	public boolean esVacia(){
		return (datos.tamanio() == 0);
	}
}
