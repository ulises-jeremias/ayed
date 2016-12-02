package tp04.ejercicio4;

import tp03.ejercicio7.ColaGenerica;
import tp04.ejercicio1.*;

public class ProcesadorDeArbolBinario<T> {
	private ArbolBinario<Integer> arbol;
	
	public void setArbol (ArbolBinario<Integer> arbol){
		this.arbol=arbol;
	}
	
	public ArbolBinario<Integer> getDato (){
		return arbol;
	}
	
	public int sumaElementosProfundidad (int p){
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		ArbolBinario<Integer> aux = null;
		int nivel = 0;
		int result = 0;
		cola.encolar(this.arbol);
		cola.encolar(null);
		while(!cola.esVacia() && p>=nivel) {
			aux = cola.desencolar();
			if(!aux.esVacio()) {
				if(p==nivel){
					result += aux.getDatoRaiz();
				} else {
					if(!aux.getHijoIzquierdo().esVacio()) {
						cola.encolar(aux.getHijoIzquierdo());
					}
					if(!aux.getHijoDerecho().esVacio()) {
						cola.encolar(aux.getHijoDerecho());
					}
				}
			} else {
				if(!cola.esVacia()) {
					nivel++;
					cola.encolar(null);
				}
			}
		}
		if(p < nivel) {
			return (-1);
		} else {
			return result;
		}
	}
}
