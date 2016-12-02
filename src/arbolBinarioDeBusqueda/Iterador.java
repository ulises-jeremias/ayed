package arbolBinarioDeBusqueda;

import listasGenericas.ListaGenerica;
import nodoBinario.NodoBinario;

public class Iterador<T extends Comparable<T>> {
	
	private ListaGenerica<NodoBinario<T>> lista;

	public Iterador(){
		this.lista = null;
		this.lista.comenzar();
	}
	
	public Iterador(ArbolBinarioDeBusqueda<T> ABB){
		this.lista = null;
		this.lista.comenzar();
		if(!ABB.esVacio()){
			this.inOrden(ABB);
		}
	}
	
	private void inOrden(ArbolBinarioDeBusqueda<T> ABB){
		if(!ABB.getHijoIzquierdo().esVacio()){
			inOrden(ABB.getHijoIzquierdo());
		}
		if (ABB.getDatoRaiz() != null) {
			this.lista.agregarFinal(new NodoBinario<T>(ABB.getDatoRaiz()));
		}
		if(!ABB.getHijoDerecho().esVacio()){
			inOrden(ABB.getHijoDerecho());
		}	
	}
	
	public boolean hasNext(){
		return !lista.fin();
	}
	
	public T next(){
		return lista.proximo().getDato();
	}
}

