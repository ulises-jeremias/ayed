package tp03.ejercicio9;

import tp03.ejercicio6.ListaEnlazadaGenerica;


public class TestListaInvertidaDeGramas {

	public static void main(String[] args) {

		ListaInvertidaDeGramas lista = new ListaInvertidaDeGramas(2);
		
		lista.agregar("universal");
		lista.agregar("universidad");

		ListaEnlazadaGenerica<String> nuevo = new ListaEnlazadaGenerica<String>();
		
		lista.ImprimirListaInvertida();
		
		//nuevo = lista.recuperarListaDePalabras("uni");
		
		//System.out.println (nuevo);
	}
}
