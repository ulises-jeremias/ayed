package tp04.ejercicio4;

import tp04.ejercicio1.*;

public class TestProcesadorDeArbolBinario<T> {
	public static void main(String[] args) {

		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(new Integer(40));
		ArbolBinario<Integer> hijoIzquierdo = new ArbolBinario<Integer>(25);
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Integer>(10));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<Integer>(32));
		ArbolBinario<Integer> hijoDerecho = new ArbolBinario<Integer>(78);
		ab.agregarHijoIzquierdo(hijoIzquierdo);
		ab.agregarHijoDerecho(hijoDerecho);

		ProcesadorDeArbolBinario queAnde = new ProcesadorDeArbolBinario();
		
		queAnde.setArbol(ab);
		
		System.out.println(queAnde.sumaElementosProfundidad(1));

	}
}
