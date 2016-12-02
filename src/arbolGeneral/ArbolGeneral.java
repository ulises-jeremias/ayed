package arbolGeneral;

import listasGenericas.ListaEnlazadaGenerica;
import listasGenericas.ListaGenerica;
import colaGenerica.ColaGenerica;

public class ArbolGeneral<T> {

	private NodoGeneral<T> raiz;

	public ArbolGeneral() {

		this.raiz = null;
	}

	public ArbolGeneral(T dato) {

		this.raiz = new NodoGeneral<T>(dato);
		
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> lista) {

		this(dato);
		ListaGenerica<NodoGeneral<T>> hijos = new ListaEnlazadaGenerica<NodoGeneral<T>>();

		lista.comenzar();
		while (!lista.fin()) {
			ArbolGeneral<T> arbolTemp = lista.proximo();
			hijos.agregarFinal(arbolTemp.getRaiz());
			
		}

		raiz.setListaHijos(hijos);
	}

	private ArbolGeneral(NodoGeneral<T> nodo) {

		this.raiz = nodo;
	}


	private NodoGeneral<T> getRaiz() {

		return this.raiz;
	}

	public T getDatoRaiz() {

		return this.raiz.getDato();
	}

	
	public ListaGenerica<ArbolGeneral<T>> getHijos() {

		ListaGenerica<ArbolGeneral<T>> lista = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		ListaGenerica<NodoGeneral<T>> hijos = (ListaGenerica<NodoGeneral<T>>) this
				.getRaiz().getHijos();
		lista.comenzar();
		hijos.comenzar();

		while (!hijos.fin()) {
			lista.agregarFinal(new ArbolGeneral<T>(hijos.proximo()));
			
		}

		return lista;
	}

	
	public void agregarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		this.raiz.getHijos().agregarFinal(hijo);
	}

	
	public void eliminarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		boolean ok = false;

		ListaGenerica<NodoGeneral<T>> listaHijos = (ListaGenerica<NodoGeneral<T>>) this
				.getRaiz().getHijos();
		listaHijos.comenzar();

		while (!listaHijos.fin() && !ok) {

			NodoGeneral<T> hijoTemp = listaHijos.proximo();
			if (hijoTemp.getDato().equals(hijo.getDato())) {
				ok = listaHijos.eliminar(hijoTemp);
				
			}
		}	

		
	}
    

	public Integer altura() {	 
		if(this.esHoja()){
			return 0;
		}else{
			int altura;
			int max = -1;
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			while(!hijos.fin()){
				altura = 1;
				altura+= hijos.proximo().altura();
				if(altura>max){
					max=altura;
				}
			}
			return max;
		}
	}

	
	public Integer nivel( T dato){
		if(raiz.getDato()==dato){
			return 0;
		}else{
			ArbolGeneral<T> arbol = new ArbolGeneral<T>();
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
			boolean query = false;
			int nivel = 0;
			cola.encolar(this);
			cola.encolar(null);
			while(!cola.esVacia() && !query){
				arbol = cola.desencolar();
				if(arbol!=null){
					if(arbol.getDatoRaiz()==dato){
						query=true;
					}else{
						ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
						hijos.comenzar();
						while(!hijos.fin()){
							cola.encolar(hijos.proximo());
						}
					}
				}else{
					if(!cola.esVacia() && !query){
						nivel++;
						cola.encolar(null);
					}
				}
			}
			if(!query){
				nivel = -1;
			}
			return nivel;
		}
	}


	public Integer ancho(){
	   ArbolGeneral<T> arbol = new ArbolGeneral<T>();
	   ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
	   int cant_nodos = 0;
	   int max = -1;
	   cola.encolar(this);
	   cola.encolar(null);
	   while(!cola.esVacia()){
		   arbol = cola.desencolar();
		   if(arbol!=null){
			   ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
			   hijos.comenzar();
			   while(!hijos.fin()){
				   cola.encolar(hijos.proximo());
				   cant_nodos++;
			   }
		   }else{
			   if(max<cant_nodos){
				   max=cant_nodos;
			   }
			   cant_nodos = 0;
			   cola.encolar(null);
		   }
	   }
	   return max;
	}

	public Boolean esHoja(){
		return this.getDatoRaiz() != null && this.raiz.getHijos().esVacia();
	}
	
	public Boolean esVacio(){
		return this.getDatoRaiz() == null;
	}

	private void recorrido (ListaGenerica<T> lista, boolean query){
		if(!this.esHoja()){
			ListaGenerica<ArbolGeneral<T>> listaHijos = this.getHijos();
			ArbolGeneral<T> aux;
			for(int i = listaHijos.tamanio(); i != 0; i--){
				aux = listaHijos.elemento(i);
				if ((i==listaHijos.tamanio()) && (!aux.esHoja())){
					if(query){
						lista.agregarFinal(aux.getDatoRaiz());
					}
					this.recorrido(lista, query);
					query = false;
				} else {
					aux.recorrido(lista, query);
					if ((i==1) && (!aux.esHoja())){
						lista.agregarFinal(aux.getDatoRaiz());
					}
				}
			}
		} else {
			lista.agregarFinal(this.getDatoRaiz());
		}
	}
	
	public ListaGenerica<T> contorno(){
		ArbolGeneral<T> arbol = this;
		ListaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		lista.agregarFinal(this.getDatoRaiz());
		boolean query = true;
		arbol.recorrido(lista, query);
		return lista;	
	}
	
	public boolean esDescendiente(T elem){
		boolean query = false;
		ListaGenerica<ArbolGeneral<T>> lista;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia() && !query){
			aux = cola.desencolar();
			if(!aux.esVacio()){
				lista = aux.getHijos();
				while(!lista.fin() && !query){
					aux=lista.proximo();
					cola.encolar(aux);
					if(aux.getDatoRaiz() == elem){
						query=true;
					}
				}	
			} else {
				if(!cola.esVacia()){
					cola.encolar(null);
				}
			}
		}
		return query;
	}
	
	public boolean esAncestro(T a, T b){
		boolean query = false;
		ListaGenerica<ArbolGeneral<T>> lista;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux = new ArbolGeneral<T>();
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia() && !query){
			aux = cola.desencolar();
			if(!aux.esVacio()){
				lista = aux.getHijos();
				while(!lista.fin() && !query){
					aux=lista.proximo();
					cola.encolar(aux);
					if(aux.getDatoRaiz() == a){
						query=true;
					}
				}	
			} else {
				if(!cola.esVacia()){
					cola.encolar(null);
				}
			}
		}
		if(aux.getDatoRaiz()==a){
			return aux.esDescendiente(b);
		}
		return false;
	}
}
