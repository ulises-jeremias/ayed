package grafos;

import tp03.ejercicio8.ListaEnlazadaGenerica;
import tp03.ejercicio8.ListaGenerica;

public class GrafoImplMatrizAdy<T> implements Grafo<T> {
	@SuppressWarnings("unused")
	private int maxVertices;
	private ListaGenerica<Vertice<T>> vertices;
	private int [][] matrizAdy;
	
	public GrafoImplMatrizAdy(int maxVert){
		this.maxVertices = maxVert+1; // la lista arranca en 1 la posicion 0 no la usamos
		this.matrizAdy = new int [maxVert][maxVert];
		this.vertices = new ListaEnlazadaGenerica<Vertice<T>>();
		
	}
	public void agregarVertice(Vertice<T> v) {
		VerticeImplMatrizAdy<T> v2 = ((VerticeImplMatrizAdy<T>) v);
		v2.setPosicion(vertices.tamanio()+1);
		vertices.agregarFinal(v2);
	}
	
	
	public void eliminarVertice(Vertice<T> v) {
		ListaGenerica<Vertice<T>> vertices = this.listaDeVertices();
		vertices.comenzar();
		boolean encontre = false;
		int lugar = 1,aux = 1;
		while (!vertices.fin()){
			VerticeImplMatrizAdy<T> vertice = (VerticeImplMatrizAdy<T>) vertices.proximo();
			
			if (encontre)
				vertice.setPosicion(vertice.posicion()-1);
			
			if (vertice.dato().equals(v.dato())){
				lugar = aux;
				encontre = true;
			}
			if (this.esAdyacente(v, vertice))				
				this.desConectar(vertice, v);
			
			aux++;
		}
		if (encontre){
			this.listaDeVertices().eliminarEn(lugar);
			// se realiza el corrimiento
			for (int f = lugar;lugar <= vertices.tamanio()+1;lugar++){
				for (int c=0; c<= vertices.tamanio()+1;c++){
					matrizAdy[f][c] = matrizAdy[f+1][c];
				}
			}
		}
		
	}
	
	public void conectar(Vertice<T> origen, Vertice<T> destino) {
		conectar(origen,destino,1);
	}
	
	public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
		 matrizAdy[origen.posicion()][destino.posicion()] = peso;
	}
	
	public void desConectar(Vertice<T> origen, Vertice<T> destino) {
		if (vertices.incluye(origen) && vertices.incluye(destino)){
		    matrizAdy[origen.posicion()][destino.posicion()] = 0;
		    }
		}
	public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
		if (vertices.incluye(origen) && vertices.incluye(destino)){
			return (!(matrizAdy[origen.posicion()][destino.posicion()]==0));
		}
		return false;
	}
	public boolean esVacio() {
		return vertices.esVacia();
	}
	public ListaGenerica<Vertice<T>> listaDeVertices() {
		return vertices;
	}
	
	public int peso(Vertice<T> origen, Vertice<T> destino) {
		if (vertices.incluye(origen) && vertices.incluye(destino)){
			return matrizAdy[origen.posicion()][destino.posicion()];
		}
		return 0;
	}
	
	public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {
		ListaGenerica<Arista<T>> aristas = new ListaEnlazadaGenerica<Arista<T>>();
		for (int i=1; i<=this.listaDeVertices().tamanio(); i++){
			if (matrizAdy[v.posicion()][i]== 1){
				AristaImpl<T> arista = new AristaImpl<T>(this.vertices.elemento(i), matrizAdy[v.posicion()][i]);
				aristas.agregarFinal(arista);
			}
		}
				
		return aristas;
	}
	
	public Vertice<T> vertice(int posicion) {
		return vertices.elemento(posicion);
	} 


}
