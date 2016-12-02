package tp04.ejercicio5;

import tp04.ejercicio1.*;
import tp03.ejercicio7.PilaGenerica;

public class ProcesadorDeExpresiones<T> {
	
	public static ArbolBinario<Character> convertirPostfija(String expresion){
		ArbolBinario<Character> result;
		PilaGenerica<ArbolBinario<Character>> pila = new PilaGenerica<ArbolBinario<Character>>(); 
		for(int i=0; i<expresion.length(); i++) {
			Character c = expresion.charAt(i);
			result = new ArbolBinario<Character>(c);
			if ((c == '+') || (c == '-') || (c == '/') || (c == '*')) {
				result.agregarHijoDerecho(pila.desapilar());
				result.agregarHijoIzquierdo(pila.desapilar());
			}
			pila.apilar(result);
		}
		return (pila.desapilar());
	}
	
}
