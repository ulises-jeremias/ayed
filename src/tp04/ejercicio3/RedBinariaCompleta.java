package tp04.ejercicio3;

import tp04.ejercicio1.ArbolBinario;

public class RedBinariaCompleta<T> {
	public static int calcular(ArbolBinario<Integer> arbol) {
		if(!arbol.esVacio()){
			int suma = 0;
			int [] max = new int[1];
			calcularRetardo(arbol, max, suma);
			return max[0];
		} else {
			return (-1);
		}
	}
	
	private static void calcularRetardo(ArbolBinario<Integer> arbol, int [] max, int suma) {
		suma += arbol.getDatoRaiz();
		if(arbol.esHoja() && suma > max[0]) {
			max[0] = suma;
		}
		if(!arbol.getHijoIzquierdo().esVacio()) {
			calcularRetardo(arbol.getHijoIzquierdo(), max, suma);
		}
		if(!arbol.getHijoDerecho().esVacio()) {
			calcularRetardo(arbol.getHijoDerecho(), max, suma);
		}
	}
	
	public static void main(String[] args){
		ArbolBinario<Integer> raiz = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> hijo1 = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> hijo2 = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> hijo11 = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijo12 = new ArbolBinario<Integer>(4);
		ArbolBinario<Integer> hijo21 = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> hijo22 = new ArbolBinario<Integer>(7);
		
		
		
		//armar arbol
		
		hijo1.agregarHijoIzquierdo(hijo11);
		hijo1.agregarHijoDerecho(hijo12);
		hijo2.agregarHijoIzquierdo(hijo21);
		hijo2.agregarHijoDerecho(hijo22);
		raiz.agregarHijoIzquierdo(hijo1);
		raiz.agregarHijoDerecho(hijo2);
		
		
		ArbolBinario<Integer> ab = new ArbolBinario<Integer>(new Integer(40));
		ArbolBinario<Integer> hijoIzquierdo = new ArbolBinario<Integer>(25);
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Integer>(10));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<Integer>(32));
		ArbolBinario<Integer> hijoDerecho = new ArbolBinario<Integer>(78);
		ab.agregarHijoIzquierdo(hijoIzquierdo);
		ab.agregarHijoDerecho(hijoDerecho);

		
		System.out.println(calcular(ab));
	}

}
