package tp04.ejercicio1;

import tp03.ejercicio8.ListaGenerica;
import tp03.ejercicio8.ListaEnlazadaGenerica;

public class ArbolBinario<T> {

	private NodoBinario<T> raiz;

	public ArbolBinario(T dato) {
		this.raiz = new NodoBinario<T>(dato);
	}

	private ArbolBinario(NodoBinario<T> nodo) {
		this.raiz = nodo;
	}

	private NodoBinario<T> getRaiz() {
		return raiz;
	}

	public T getDatoRaiz() {
		if (this.getRaiz() != null) {
			return this.getRaiz().getDato();
		} else {
			return null;
		}
	}

	public ArbolBinario<T> getHijoIzquierdo() {
		return new ArbolBinario<T>(this.raiz.getHijoIzquierdo());
	}

	public ArbolBinario<T> getHijoDerecho() {
		return new ArbolBinario<T>(this.raiz.getHijoDerecho());
	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}

	public void eliminarHijoIzquierdo() {
		this.raiz.setHijoIzquierdo(null);
	}

	public void eliminarHijoDerecho() {
		this.raiz.setHijoDerecho(null);
	}

	public boolean esVacio() {
		return this.getDatoRaiz() == null;
	}

	public boolean esHoja() {
		return this.getDatoRaiz() != null && this.getHijoIzquierdo().esVacio() && this.getHijoDerecho().esVacio();
	}

	public void inOrden(ArbolBinario<T> arbol, ListaGenerica<T> frontera) {
		if(!arbol.getHijoIzquierdo().esVacio()){
			this.inOrden(arbol.getHijoIzquierdo(), frontera);
		}
		if(arbol.getHijoIzquierdo().esVacio() && arbol.getHijoDerecho().esVacio()){
			frontera.agregarFinal(arbol.getDatoRaiz());
		}
		if(!arbol.getHijoDerecho().esVacio()) {
			this.inOrden(arbol.getHijoDerecho(), frontera);
		}
	}
	
	public ListaGenerica<T> frontera() {
		ListaGenerica<T> frontera = new ListaEnlazadaGenerica<T>();
		this.inOrden(this, frontera);
		return frontera;
	}

	public boolean lleno() {
		boolean query = false;
		
		return query;
	}

	public boolean completo() {
		
		return true;

	}
	
	public void imprimirPostOrden() {
		imprimirPostOrden(this);
	}
	
	private void imprimirPostOrden(ArbolBinario<T> arbol){
		if(!arbol.getHijoIzquierdo().esVacio()){
			imprimirPostOrden(arbol.getHijoIzquierdo());
		}
		if(!arbol.getHijoDerecho().esVacio()){
			imprimirPostOrden(arbol.getHijoDerecho());
		}
		if(arbol.getDatoRaiz() != null){
			System.out.println(arbol.getDatoRaiz());
		}
	}
}