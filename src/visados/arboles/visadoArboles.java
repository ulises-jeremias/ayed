//Alumnos: Ulises J. Cornejo Fandos
//            Federico Gasquez

//parte A -
//El recorrido indicado queda:
//      A->B->C->D->E->F


//Parte B -

public class Recorrido {

  public char recorrido(ArbolGeneral<char> arbol) {
    char[] alta = new char[1];
    alta[0] = "";
    if (!arbol.esVacio()) {
      recorrido(arbol, alta);
    }
    return alta[0];
  }

  private void recorrido(ArbolGeneral<char> arbol, char[] alta) {
    ArbolGeneral<char> aux;
		ColaGenerica<ArbolGeneral<char>> cola = new ColaGenerica<ArbolGeneral<char>>();
		ListaGenerica<ArbolGeneral<char>> listaHijos;
    cola.encolar(arbol);
		cola.encolar(null);
    while(!cola.esVacia()){
			aux = cola.desencolar();
			if(!aux.esVacio()){
        if (aux.getDatoRaiz() > alta[0]) {
          alta[0] = aux.getDatoRaiz();
        }
				while(!listaHijos.fin()){
					cola.encolar(listaHijos.proximo());
				}
			} else {
				if(!cola.esVacia()){
					cola.encolar(null);
				}
			}
		}
  }
}
