package tp05.ejercicio3;

import arbolGeneral.*;
import colaGenerica.*;
import listasGenericas.ListaGenerica;

public class EmpresaComunicacion {
	
	public static Integer devolverMaximoPromedio(ArbolGeneral<Integer> arbol){
		ArbolGeneral<Integer> aux;
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		ListaGenerica<ArbolGeneral<Integer>> listaHijos;
		Integer max = -1;
		Integer promedio = 0;
		Integer cant_nodos = 0;
		cola.encolar(arbol);
		cola.encolar(null);
		while(!cola.esVacia()){
			aux = cola.desencolar();
			if(!aux.esVacio()){
				promedio += aux.getDatoRaiz();
				cant_nodos++;
				listaHijos = aux.getHijos();
				while(!listaHijos.fin()){
					cola.encolar(listaHijos.proximo());
				}
			} else {
				promedio = promedio/cant_nodos;
				if(max<promedio){
					max=promedio;
				}
				if(!cola.esVacia()){
					promedio=0;
					cant_nodos=0;
					cola.encolar(null);
				}
			}
		}
		return max;
	}
}