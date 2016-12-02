package tp03.ejercicio8.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import tp03.ejercicio8.ListaEnlazadaGenerica;
import tp03.ejercicio8.ListaGenerica;

public class ListaEnlazadaGenericaTest {

	ListaGenerica<Integer> l;
	
	@Before
	public void setUp() throws Exception {
		l = new ListaEnlazadaGenerica<Integer>();
	}

	@Test
	public void testComenzar() {
		//Probando con un elemento
		l.agregarEn(3, 1);
		l.comenzar();
		assertEquals(new Integer(3), l.proximo());
		
		//Probando con dos elementos
		l.agregarEn(2, 2);
		l.comenzar();
		assertEquals(new Integer(3), l.proximo());
		assertEquals(new Integer(2), l.proximo());
		
		//Probando de agregarEn un elemento al principio
		l.agregarEn(1, 1);
		l.comenzar();
		assertEquals(new Integer(1), l.proximo());
	}

	@Test
	public void testProximo() {
		for (int i = 1; i <= 100; i++)
			l.agregarEn(i, i);
		l.comenzar();
		for (int i = 1; i <= 100; i++) {
			assertEquals(new Integer(i), l.proximo());
		}
		assertTrue(l.fin());
	}

	@Test
	public void testEliminar() {
		//No se puede eliminar si no hay nada
		assertFalse(l.eliminar(3));
		assertEquals(0, l.tamanio());
		
		for (int i = 1; i <= 10; i++)
			l.agregarEn(i, i);
		
		//Test eliminar el primer elemento 
		l.eliminarEn(1);
		assertEquals(9, l.tamanio());
		assertEquals(new Integer(2), l.elemento(1));
		assertTrue(l.agregarEn(1, 1));  //completo la lista
		
		//Test eliminar el ultimo elemento y el atributo fin
		l.eliminarEn(10);
		assertEquals(9, l.tamanio());
		assertEquals(new Integer(9), l.elemento(l.tamanio()));
		
		//Test eliminar en el medio 
		l.eliminarEn(3);
		assertEquals(8, l.tamanio());
		assertEquals(new Integer(9), l.elemento(l.tamanio()));
				 
		//Test eliminar en el medio 
		l.eliminar(5);
		assertEquals(7, l.tamanio());
		assertEquals(new Integer(9), l.elemento(l.tamanio()));
		 
	}
	
  
	@Test
	public void testagregarEn() {
		//No se puede agregarEnEn en indices negativos
		assertFalse(l.agregarEn(1, -1));
		assertEquals(0, l.tamanio());
		
		//Test de agregarEn al principio cuando no hay nada
		assertTrue(l.agregarEn(3, 1));
		assertEquals(new Integer(3), l.elemento(1));
		assertEquals(1, l.tamanio());
		
		//Test de agregarEn al principio cuando hay algo
		assertTrue(l.agregarEn(1, 1));
		assertEquals(new Integer(1), l.elemento(1));
		assertEquals(new Integer(3), l.elemento(2));
		assertEquals(2, l.tamanio());
		
		//Test de agregarEn entremedio
		assertTrue(l.agregarEn(2, 2));
		assertEquals(new Integer(1), l.elemento(1));
		assertEquals(new Integer(2), l.elemento(2));
		assertEquals(new Integer(3), l.elemento(3));
		assertEquals(3, l.tamanio());
		
		//Test de agregarEn al final
		assertTrue(l.agregarEn(4, 4));
		assertEquals(new Integer(1), l.elemento(1));
		assertEquals(new Integer(2), l.elemento(2));
		assertEquals(new Integer(3), l.elemento(3));
		assertEquals(new Integer(4), l.elemento(4));
		assertEquals(4, l.tamanio());
	}

	@Test
	public void testEliminarEn() {
		for (int i = 1; i <= 10; i++)
			l.agregarEn(i, i);
		
		//No se puede borrar indices <1
		assertFalse(l.eliminarEn(0));
		assertEquals(10, l.tamanio());
		assertFalse(l.eliminarEn(-1));
		assertEquals(10, l.tamanio());
		
		//Test eliminar el primer elemento cuando hay mas
		assertTrue(l.eliminarEn(1));    
		assertEquals(new Integer(2), l.elemento(1));
		
		//Test eliminar un elemento del medio (el que esta en la posicion 3)
		assertTrue(l.eliminarEn(3));   
		assertEquals(new Integer(5), l.elemento(3));
		assertEquals(8, l.tamanio());
		
		//Test eliminar el ultimo elemento
		assertTrue(l.agregarEn(1, 1));  //completo la lista
		assertTrue(l.agregarEn(4, 4));
		
		assertTrue(l.eliminarEn(10));
		assertEquals(9, l.tamanio());
		for (int i = 1; i < l.tamanio(); i++)
			assertEquals(new Integer(i), l.elemento(i));
			
		//No se puede eliminar un indice >= tamaño.
		assertFalse(l.eliminarEn(10));
		assertEquals(9, l.tamanio());
		for (int i = 1; i <= l.tamanio(); i++)
			assertEquals(new Integer(i), l.elemento(i));
		
	}

	
	@Test
	public void testIncluye() {
		//No se tiene que poder encontrar algo cuando la lista esta vacia
		assertFalse(l.incluye(1));
		
		//Test de busqueda sobre el primer elemento
		l.agregarEn(1, 1);
		assertTrue(l.incluye(1));
		assertFalse(l.incluye(2));
		
		//Test con mas elementos
		l.agregarEn(2, 2);
		l.agregarEn(3, 3);
		assertTrue(l.incluye(3));
		assertFalse(l.incluye(4));
	}
	
	@Test
	public void testagregarFinal() {
		//Test de agregarEn al principio cuando no hay nada
		assertTrue(l.agregarFinal(1));
		assertEquals(1, l.tamanio());
		assertTrue(l.agregarFinal(2));
		assertEquals(2, l.tamanio());
		assertTrue(l.agregarFinal(3));
		assertEquals(3, l.tamanio());
	}	

	@Test
	public void testagregarInicio() {
		//Test de agregarEn al principio cuando no hay nada
		assertTrue(l.agregarInicio(3));
		assertEquals(1, l.tamanio());
		assertTrue(l.agregarInicio(2));
		assertEquals(2, l.tamanio());
		assertTrue(l.agregarInicio(1));
		assertEquals(3, l.tamanio());
	}
	
	
	@Test
	public void testVarios() {
		// Test de agregarEn al principio cuando no hay nada
		l.agregarInicio(3);

		l.agregarInicio(2);

		l.agregarInicio(1);
		l.agregarFinal(4);
		l.agregarEn(8, 2);
		l.agregarEn(5, 5);
		// l.eliminarEn(6);
		l.reemplazarEn(9, 6);
		l.reemplazarEn(10, 10);
		System.out.println(l);
		
		ListaGenerica<Integer> nueva = l.clonar();
		System.out.println(nueva);		
		l.agregarTodos(nueva);
		System.out.println(l);
		l.limpiar();
	}
	
	
}
