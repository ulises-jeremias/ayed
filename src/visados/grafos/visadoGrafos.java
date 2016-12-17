//visado AyED
//Cornejo Fandos, Ulises J. - Gasquez, Federico R.

public class BuscadorDeCamino {

  private Grafo<String> bosque;

  public ListaGenerica<String> recorridoMasSeguro() {
    Grafo<String> grafo = this.bosque;
    ListaGenerica<Vertice<String>> listaDeVertices = grafo.listaDeVertices();
    ListaGenerica<String> lista = new ListaGenericaEnlazada<String>();
    ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
    Vertice<String> vertice;
    boolean [] marcas = new boolean[listaDeVertices.tamanio()];
    boolean[] query = new boolean[2];
    int[] pos = new int[2];
    listaDeVertices.comenzar();
    for (int i = 0; i < listaDeVertices.tamanio() && !(query[0] && query[1]); i++) {
      vertice = listaDeVertices.elemento(i);
      if (vertice.dato() == "Casa Caperucita") {
        query[0] = true;
        pos[0] = i;
      }
      if (vertice.dato() == "Casa Abuela") {
        query[1] = true;
        pos[1] = i;
      }
    }
    dfs(grafo, marcas, pos, lista, camino);
    return lista;
  }
 
  private void dfs(Grafo<String> grafo, boolean[] marcas, int[] pos, ListaGenerica<String> lista, ListaGenerica<String> camino) {
    marcas[pos[0]] = true;
    ListaGenerica<Vertice<String>> listaDeVertices = grafo.listaDeVertices();
    camino.agregarFinal(listaDeVertices.elemento(pos[0]).dato());
    if (pos[0] == pos[1]) {
      lista = camino.clonar();
    } else {
      ListaGenerica<Arista<String>> listaDeAdyacentes = grafo.listaDeAdyacentes(listaDeVertices.elemento(pos[0]));
      Arista<String> arista;
      listaDeAdyacentes.comenzar();
      while (!listaDeAdyacentes.fin()) {
        arista = listaDeAdyacentes.proximo();
        if (arista.peso() != 1) {
          int j = arista.verticeDestino().posicion();
          pos[0] = j;
          if (!marcas[j]) {
            dfs(grafo, marcas, pos, lista, camino);
            marcas[j] = false;
            camino.eliminar(j);
          }
        }
      }
    }
  }

}
