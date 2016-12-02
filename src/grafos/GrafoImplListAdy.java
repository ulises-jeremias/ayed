package grafos;

import tp03.ejercicio8.ListaEnlazadaGenerica;
import tp03.ejercicio8.ListaGenerica;

public class GrafoImplListAdy<T> implements Grafo<T> {
    private ListaGenerica<Vertice<T>>vertices = new ListaEnlazadaGenerica<Vertice<T>>();
	
	
	

	public void agregarVertice(Vertice<T> v) {
		VerticeImplListAdy<T> v2 = ((VerticeImplListAdy<T>) v);
		v2.setPosicion(vertices.tamanio()+1);
		vertices.agregarFinal(v2);
	}

	@Override
	public void eliminarVertice(Vertice<T> v) {
		ListaGenerica<Vertice<T>> vertices = this.listaDeVertices();
		vertices.comenzar();
		boolean encontre = false;
		int lugar = 1,aux = 1;
		while (!vertices.fin()){
			VerticeImplListAdy<T> vertice = (VerticeImplListAdy<T>) vertices.proximo();
			
			if (encontre)
				vertice.setPosicion(vertice.posicion()-1);
			
			if (vertice.dato().equals(v.dato())){
				lugar = aux;
				encontre = true;
			}
			if (((VerticeImplListAdy<T>) v).esAdyacente(vertice))				
				this.desConectar(vertice, v);
			
			aux++;
		}
		if (encontre){
			this.listaDeVertices().eliminarEn(lugar);
		}
	}

	@Override
	public void conectar(Vertice<T> origen, Vertice<T> destino) {
		((VerticeImplListAdy<T>) origen).conectar(destino);

		
	}

	@Override
	public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
		((VerticeImplListAdy<T>) origen).conectar(destino,peso);
		
	}

	@Override
	public void desConectar(Vertice<T> origen, Vertice<T> destino) {
		((VerticeImplListAdy<T>) origen).desconectar(destino);
		
	}

	@Override
	public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
		if (vertices.incluye(origen) && vertices.incluye(destino)){		
		return ((VerticeImplListAdy<T>) origen).esAdyacente(destino);
	
		}
	return false;
	}
		

	@Override
	public boolean esVacio() {
		
		return vertices.esVacia();
	}

	@Override
	public ListaGenerica<Vertice<T>> listaDeVertices() {
		
		return vertices;
	}

	@Override
	public int peso(Vertice<T> origen, Vertice<T> destino) {
	    return	((VerticeImplListAdy<T>) origen).peso(destino);
	}

	@Override
	public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {
		return ((VerticeImplListAdy<T>)v).obtenerAdyacentes();
	}

	@Override
	public Vertice<T> vertice(int posicion) {
		return this.listaDeVertices().elemento(posicion);
	}
	

}
