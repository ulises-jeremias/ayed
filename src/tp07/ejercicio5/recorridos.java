package tp07.ejercicio3;

import grafos.*;

public class Recorridos<T> {

  public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo) {
    ListaGenerica<Vertice<T>> listaDeVertices = grafo.listaDeVertices();
    boolean [] marcas = new boolean[listaDeVertices.tamanio()];
    ListaGenerica<Vertice<T>> lista = new ListaGenericaEnlazada<Vertice<T>>();
    lista.comenzar();
    for (i=0; i < listaDeVertices.tamanio(); i++) {
      if (!marcas[i]) {
        dfs(grafo, marcas, i, lista);
      }
    }
    return lista;
  }

  private void dfs(Grafo<T> grafo, boolean[] marcas, int pos) {
    marcas[pos] = true;
    ListaGenerica<Vertice<T>> listaDeVertices = grafo.listaDeVertices();
    lista.agregarFinal(listaDeVertices.elemento(pos));
    ListaGenerica<Arista<T>> listaDeAdyacentes = grafo.listaDeAdyacentes(listaDeVertices.elemento(pos));
    listaDeAdyacentes.comenzar();
    while (!listaDeAdyacentes.fin()) {
      int j = listaDeAdyacentes.proximo().verticeDestino().posicion();
      if (!marcas[j]) {
          dfs(grafo, marcas, j);
      }
    }
  }

  public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo) {
    ListaGenerica<Vertice<T>> listaDeVertices = grafo.listaDeVertices();
    ListaGenerica<Arista<T>> listaDeAdyacentes;
    ListaGenerica<Vertice<T>> lista = new ListaGenericaEnlazada<Vertice<T>>();
    ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();
    Vertice<T> vertice;
    listaDeVertices.comenzar();
    cola.encolar(listaDeVertices.proximo());
    cola.encolar(null);
    while (!cola.esVacia()) {
      vertice = cola.desencolar();
      if (vertice != null) {
        if (!lista.incluye(vertice)) {
          lista.agregarFinal(vertice);
          listaDeAdyacentes = vertice.obtenerAdyacentes();
          while (!listaDeAdyacentes.fin()) {
            cola.encolar(listaDeAdyacentes.proximo().verticeDestino());
          }
        }
      } else {
        if (!cola.esVacia()) {
          cola.encolar(null);
        }
      }
    }
    return lista;
  }
}
