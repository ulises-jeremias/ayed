package arbolBinarioDeBusqueda;

import nodoAVL.NodoAVL;
import nodoBinario.NodoBinario;

public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {

	private NodoBinario<T> raiz;

	public ArbolBinarioDeBusqueda() {
		this.raiz = null;
	}

	public ArbolBinarioDeBusqueda(T dato) {
		this.raiz = new NodoBinario<T>(dato);
	}

	private ArbolBinarioDeBusqueda(NodoBinario<T> nodo) {
		this.raiz = nodo;
	}

	private NodoBinario<T> getRaiz() {
		return raiz;
	}

	public T getDatoRaiz() {
		if (this.getRaiz() != null) {
			return this.getRaiz().getDato();
		} else {
			return null;
		}
	}

	public ArbolBinarioDeBusqueda<T> getHijoIzquierdo() {
		return new ArbolBinarioDeBusqueda<T>(this.raiz.getHijoIzquierdo());
	}

	public ArbolBinarioDeBusqueda<T> getHijoDerecho() {
		return new ArbolBinarioDeBusqueda<T>(this.raiz.getHijoDerecho());
	}
	
	private NodoBinario<T> buscar(Comparable<T> x,
			NodoBinario<T> t) {
		if (t != null) {
			if (x.compareTo(t.getDato()) < 0) {
				t = this.buscar(x, t.getHijoIzquierdo());
			} else if (x.compareTo(t.getDato()) > 0) {
				t = this.buscar(x, t.getHijoDerecho());
			} else
				; // Se encontro el nodo, asi que es t
			return t;
		} else {
			return null;
		}
	}
	
	public boolean incluye(Comparable<T> dato) {
		return buscar(dato, this.raiz) != null;
	}

	public T buscar(T dato){
    	NodoBinario<T> result = this.buscar(dato, this.getRaiz());
    	if (result != null){
    		return result.getDato();
    	}
    	return null;
    }

	private void agregar(NodoBinario<T> raiz, T dato) {
		if ( dato.compareTo(raiz.getDato()) < 0 ) {
			if (raiz.getHijoIzquierdo()==null) 
				raiz.setHijoIzquierdo(new NodoBinario<T> (dato));
			else 
				agregar(raiz.getHijoIzquierdo(), dato);
		} else {
			if(dato.compareTo(raiz.getDato()) > 0){
				if(raiz.getHijoDerecho()==null)
					raiz.setHijoDerecho(new NodoBinario<T> (dato));
				else 
					agregar(raiz.getHijoDerecho(), dato);
			}
		}
	}
	
	public void agregar(T dato) {
		if (this.raiz == null) {
			this.raiz = new NodoBinario<T>(dato);
		} else {
			this.agregar(this.raiz, dato);
		}

	}

	public T buscarMin(){
		ArbolBinarioDeBusqueda<T> arbolActual = this;
        while(!arbolActual.esVacio() ) {
            arbolActual = arbolActual.getHijoIzquierdo();
        }
        T devuelvo= arbolActual.getDatoRaiz();
        arbolActual.raiz = null;
        return devuelvo;
	}
	
	public void eliminar(T dato) {
		if(this.incluye(dato)){
			NodoBinario<T> paraEliminar = this.buscar(dato, raiz);
			if(paraEliminar != null){
				if((paraEliminar.getHijoDerecho()==null)&&(paraEliminar.getHijoIzquierdo()==null))
					paraEliminar.setDato(null);
				else
					if((paraEliminar.getHijoIzquierdo()!=null)&&(paraEliminar.getHijoDerecho()!=null))
						paraEliminar.setDato(this.buscarMin());
					else{
						if (paraEliminar.getHijoIzquierdo()==null) {
	                        paraEliminar.setDato(paraEliminar.getHijoDerecho().getDato());
	                    }else{
	                    	paraEliminar.setDato(paraEliminar.getHijoIzquierdo().getDato());
	                    }
					}
			}
		}
	}

	public boolean esVacio() {
		return (this.getRaiz() == null);
	}
	
	public void printTree( )
    {
        if( this.esVacio())
            System.out.println( "Arbol Vacio" );
        else
            printTree(this.raiz);
    }
	
	 private void printTree( NodoBinario<T> t )
     {
         if( t != null )
         {
             printTree( t.getHijoIzquierdo() );
             System.out.println( t.getDato());
             printTree( t.getHijoDerecho());
         }
     }

}