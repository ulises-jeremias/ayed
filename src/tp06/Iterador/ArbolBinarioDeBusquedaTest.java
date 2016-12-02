package tp06.Iterador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import arbolBinarioDeBusqueda.*;


public class ArbolBinarioDeBusquedaTest {

	ArbolBinarioDeBusqueda<String> arbol;
	
	@Before
	public void setUp(){
		arbol = new ArbolBinarioDeBusqueda<String>();
	}
	
	@Test
	public void creacion() {
		assertTrue(arbol.esVacio());
	}
	
	@Test
	public void creacionConElemento(){
		arbol = new ArbolBinarioDeBusqueda<String>("Hola");

		assertFalse(arbol.esVacio());
		assertTrue(arbol.getHijoDerecho().esVacio());
		assertTrue(arbol.getHijoIzquierdo().esVacio());
	}
	
	@Test
	public void carga(){
		arbol.agregar("hola");
		arbol.agregar("mundo");
		
		assertEquals("mundo", arbol.getHijoDerecho().getDatoRaiz());
		
		arbol.agregar("otro");
		//mantiene la posicion del anterior
		assertEquals("mundo", arbol.getHijoDerecho().getDatoRaiz());
		//agrego el nuevo al final de la rama derecha
		assertEquals("otro", arbol.getHijoDerecho()
						.getHijoDerecho().getDatoRaiz());
		
		arbol.agregar("al comienzo");
		assertEquals("al comienzo", arbol.getHijoIzquierdo().getDatoRaiz());
		
		arbol.printTree();
	}
	
	@Test
	public void busqueda(){
		arbol.agregar("hola");
		arbol.agregar("otro");
		arbol.agregar("mundo");

		assertTrue(arbol.incluye("hola"));
		assertTrue(arbol.incluye("otro"));
		assertTrue(arbol.incluye("mundo"));
		
		assertEquals("mundo", arbol.buscar("mundo"));
		assertNull(arbol.buscar("no esta"));
		
		assertFalse(arbol.incluye("al comienzo"));
		assertFalse(arbol.incluye("zz fin"));
	}
	
	@Test
	public void eliminacion(){
		
		arbol.agregar("hola");
		arbol.agregar("otro");
		arbol.agregar("mundo");
		arbol.agregar("zzz");
		
		arbol.eliminar("no esta");

		
		arbol.eliminar("otro");
		assertEquals("hola", arbol.getDatoRaiz());
		assertEquals("mundo", arbol.getHijoDerecho().getDatoRaiz());
		
		arbol.eliminar("hola");
		assertEquals("mundo",arbol.getDatoRaiz());
		assertEquals("zzz", arbol.getHijoDerecho().getDatoRaiz());
	}
	
	@Test
	public void iteracion(){

		// manejo del caso vacio
		Iterador<String> it = new Iterador<String>(arbol);
		assertFalse(it.hasNext());

		// ahora con datos
		arbol.agregar("e");
		arbol.agregar("c");
		arbol.agregar("d");
		arbol.agregar("f");
		arbol.agregar("a");
		arbol.agregar("b");
		arbol.agregar("g");
		arbol.agregar("i");
		arbol.agregar("h");
		
		it = new Iterador<String>(arbol);
		
		assertTrue(it.hasNext());
		assertEquals("a", it.next());
		assertTrue(it.hasNext());
		assertEquals("b", it.next());
		assertTrue(it.hasNext());
		assertEquals("c", it.next());
		assertTrue(it.hasNext());
		assertEquals("d", it.next());
		assertTrue(it.hasNext());
		assertEquals("e", it.next());
		assertTrue(it.hasNext());
		assertEquals("f", it.next());
		assertTrue(it.hasNext());
		assertEquals("g", it.next());
		assertTrue(it.hasNext());
		assertEquals("h", it.next());
		assertTrue(it.hasNext());
		assertEquals("i", it.next());
		assertFalse(it.hasNext());

		
	}
}

