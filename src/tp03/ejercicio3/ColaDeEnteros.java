package tp03.ejercicio3;

import tp03.ejercicio1.ListaDeEnteros;
import tp03.ejercicio1.ListaDeEnterosEnlazada;

public class ColaDeEnteros {
	ListaDeEnteros datos = new ListaDeEnterosEnlazada();
	
	public ColaDeEnteros(){
		datos.agregarEn(null, 1);
	}
	
	public void encolar(Integer elem){
		this.datos.agregarFinal(elem);
	}
	
	public Integer desencolar(){
		Integer x = this.datos.elemento(1);
		this.datos.eliminarEn(1);
		return x;
	}
	
	public Integer tope(){
		return datos.elemento(1);
	}
	
	public boolean esVacia(){
		return (datos.tamanio() == 0);
	}
	
}
