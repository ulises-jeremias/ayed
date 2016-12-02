package grafos.test;


import grafos.Arista;
import grafos.GrafoImplListAdy;
import grafos.VerticeImplListAdy;
import junit.framework.TestCase;
import tp03.ejercicio8.ListaGenerica;


public class TestGrafoImplListAdy extends TestCase {
	GrafoImplListAdy<Integer> grafo;
	

	protected void setUp() throws Exception {
		super.setUp();
		grafo = new GrafoImplListAdy<Integer>();
	}


	protected void tearDown() throws Exception {
		super.tearDown();
	}


	public void testAgregarYeliminarVertice() {
		int tamAntes = grafo.listaDeVertices().tamanio();
		VerticeImplListAdy<Integer> vert1 = new VerticeImplListAdy<Integer>(1);
		VerticeImplListAdy<Integer> vert2 = new VerticeImplListAdy<Integer>(2);
		VerticeImplListAdy<Integer> vert3 = new VerticeImplListAdy<Integer>(3);
		grafo.agregarVertice(vert1);
		grafo.agregarVertice(vert2);
		grafo.agregarVertice(vert3);
		grafo.conectar(vert1, vert2);
		grafo.conectar(vert1, vert3);
		grafo.conectar(vert2, vert1);
		grafo.conectar(vert2, vert3);
		grafo.conectar(vert3, vert1);
		grafo.conectar(vert3, vert2);
		int tamDesp = grafo.listaDeVertices().tamanio();
		
		assertTrue(tamDesp == tamAntes+3);
		grafo.eliminarVertice(vert1);
		grafo.eliminarVertice(vert2);
		grafo.eliminarVertice(vert3);
		//for (int i = 1;i<= grafo.listaDeVertices().tamanio();i++)
		//	System.out.println("elemento: "+grafo.listaDeVertices().elemento(i).dato()+" posicion: "+grafo.listaDeVertices().elemento(i).posicion());
		
		int tamFin = grafo.listaDeVertices().tamanio();
		
		assertTrue(tamFin == tamAntes);
	}


	public void testConectarYdesconectar() {
		VerticeImplListAdy<Integer> vert1 = new VerticeImplListAdy<Integer>(1);
		VerticeImplListAdy<Integer> vert2 = new VerticeImplListAdy<Integer>(2);
		grafo.agregarVertice(vert1);
		grafo.agregarVertice(vert2);
		grafo.conectar(vert1, vert2);
		boolean ok = false;
		
		ListaGenerica<Arista<Integer>> lista = grafo.listaDeAdyacentes(vert1);
		Arista<Integer> arista;
		lista.comenzar();
		while(!lista.fin()){
			arista = lista.proximo();
			if (arista.verticeDestino() == vert2){
				ok= true;
			}
		
		}

		assertTrue(ok);
		
		grafo.desConectar(vert1, vert2);
		ok=false;
		lista = grafo.listaDeAdyacentes(vert1);
		lista.comenzar();
		while(!lista.fin()){
			arista = lista.proximo();
			if (arista.verticeDestino() == vert2){
				ok= true;
			}
			
		}
		assertFalse(ok);
	}


	public void testEsAdyacente() {
		VerticeImplListAdy<Integer> vert1 = new VerticeImplListAdy<Integer>(1);
		VerticeImplListAdy<Integer> vert2 = new VerticeImplListAdy<Integer>(2);
		grafo.agregarVertice(vert1);
		grafo.agregarVertice(vert2);
		grafo.conectar(vert1, vert2);
		assertTrue(grafo.esAdyacente(vert1,vert2));
		assertFalse(grafo.esAdyacente(vert2,vert1));
	}

	public void testEsVacio() {
		assertTrue(grafo.esVacio());
		VerticeImplListAdy<Integer> vert1 = new VerticeImplListAdy<Integer>(1);
		grafo.agregarVertice(vert1);
		assertFalse(grafo.esVacio());
	}


	public void testListaDeVertices() {
		assertTrue(grafo.listaDeVertices().tamanio()==0);
		VerticeImplListAdy<Integer> vert1 = new VerticeImplListAdy<Integer>(1);
		grafo.agregarVertice(vert1);
		assertTrue(grafo.listaDeVertices().tamanio()==1);
		VerticeImplListAdy<Integer> vert2 = new VerticeImplListAdy<Integer>(2);
		grafo.agregarVertice(vert2);
		assertTrue(grafo.listaDeVertices().tamanio()==2);
	}


	public void testPeso() {
		VerticeImplListAdy<Integer> vert1 = new VerticeImplListAdy<Integer>(1);
		VerticeImplListAdy<Integer> vert2 = new VerticeImplListAdy<Integer>(2);
		grafo.agregarVertice(vert1);
		grafo.agregarVertice(vert2);
		grafo.conectar(vert1, vert2,5);
		assertTrue(grafo.peso(vert1, vert2) == 5);
	}


	public void testListaDeAdyacentes() {
		VerticeImplListAdy<Integer> vert1 = new VerticeImplListAdy<Integer>(1);
		grafo.agregarVertice(vert1);
		assertTrue(grafo.listaDeAdyacentes(vert1).tamanio() == 0);
		VerticeImplListAdy<Integer> vert2 = new VerticeImplListAdy<Integer>(2);
		grafo.agregarVertice(vert2);
		assertTrue(grafo.listaDeAdyacentes(vert2).tamanio() == 0);
		grafo.conectar(vert1, vert2);
		assertTrue(grafo.listaDeAdyacentes(vert1).tamanio() == 1);
		assertTrue(grafo.listaDeAdyacentes(vert2).tamanio() == 0);
		grafo.conectar(vert2, vert1);
		assertTrue(grafo.listaDeAdyacentes(vert1).tamanio() == 1);
		assertTrue(grafo.listaDeAdyacentes(vert2).tamanio() == 1);
	}


	public void testVetice() {
		VerticeImplListAdy<Integer> vert1 = new VerticeImplListAdy<Integer>(1);
		grafo.agregarVertice(vert1);
		assertEquals(grafo.vertice(vert1.posicion()),vert1);
		
		VerticeImplListAdy<Integer> vert2 = new VerticeImplListAdy<Integer>(1);
		grafo.agregarVertice(vert2);
		assertEquals(grafo.vertice(vert2.posicion()),vert2);
	}

}

