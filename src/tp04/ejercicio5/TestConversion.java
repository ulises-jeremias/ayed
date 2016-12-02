package tp04.ejercicio5;

import tp04.ejercicio1.*;

public class TestConversion {

	public static void main(String[] args) {

		String aux = "ab+c*de+/";
		
		ArbolBinario<Character> arbol = ProcesadorDeExpresiones.convertirPostfija(aux);
		
		arbol.imprimirPostOrden();
	}

}