package ArbolAVL;

import nodoAVL.NodoAVL;

public class ArbolAVL<T extends Comparable<T>> {

	private NodoAVL<T> raiz;

	public ArbolAVL() {
		this.raiz = null;
	}

	public ArbolAVL(T dato) {
		this.raiz = new NodoAVL<T>(dato);
	}

	private ArbolAVL(NodoAVL<T> nodo) {
		this.raiz = nodo;
	}

	private NodoAVL<T> getRaiz() {
		return raiz;
	}

	public T getDatoRaiz() {
		if (this.getRaiz() != null) {
			return this.getRaiz().getDato();
		} else {
			return null;
		}
	}

	public ArbolAVL<T> getHijoIzquierdo() {
		return new ArbolAVL<T>(this.raiz.getHijoIzquierdo());
	}

	public ArbolAVL<T> getHijoDerecho() {
		return new ArbolAVL<T>(this.raiz.getHijoDerecho());
	}

	private NodoAVL<T> buscar(T x, NodoAVL<T> t) {
		if (t != null) {
			if (x.compareTo(t.getDato()) < 0) {
				t = this.buscar(x, t.getHijoIzquierdo());
			} else if (x.compareTo(t.getDato()) > 0) {
				t = this.buscar(x, t.getHijoDerecho());
			}
			// Se encontro el nodo, asi que es t
			return t;
		} else {
			return null;
		}
	}

	public boolean incluye(T x) {
		return buscar(x, this.raiz) != null;
	}

	public T buscar(T dato) {
		NodoAVL<T> nodo = buscar(dato, this.raiz);
		if (nodo != null) {
			return nodo.getDato();
		} else {
			return null;
		}
	}

	public void agregar(T dato) {
		this.raiz = this.agregarDato(dato, this.getRaiz());

	}
	private int altura(NodoAVL<T>   t )
    {
        return t == null ? -1 : t.getAltura();
    }

	private NodoAVL<T> agregarDato(T x, NodoAVL<T> t) {
		if (t == null)
			t = new NodoAVL<T>(x);
		else if (x.compareTo(t.getDato()) < 0) {
			t.setHijoIzquierdo(agregarDato(x, t.getHijoIzquierdo()));
			if (altura(t.getHijoIzquierdo()) - altura(t.getHijoDerecho()) == 2)
				if (x.compareTo(t.getHijoIzquierdo().getDato()) < 0)
					t = rotacionSimpleIzq(t);
				else
					t = rotacionDobleIzq(t);
		} else if (x.compareTo(t.getDato()) > 0) {
			t.setHijoDerecho(agregarDato(x, t.getHijoDerecho()));
			if (altura(t.getHijoDerecho()) - altura(t.getHijoIzquierdo()) == 2)
				if (x.compareTo(t.getHijoDerecho().getDato()) > 0)
					t = rotacionSimpleDer(t);
				else
					t = rotacionDobleDer(t);
		} else
			; // Duplicate; do nothing
		t.setAltura(Math.max(altura(t.getHijoIzquierdo()), altura(t.getHijoDerecho())) + 1);
		return t;

	}

	public void eliminar(T dato) {
		// Falta implementar. Ejercicio 6a.
	}

	public boolean esVacio() {
		return (this.raiz == null);
	}
	
		

	
	private NodoAVL<T> rotacionSimpleIzq(NodoAVL<T> nodo){
		NodoAVL<T> k1 = nodo.getHijoIzquierdo();
        nodo.setHijoIzquierdo(k1.getHijoDerecho());
        k1.setHijoDerecho(nodo);
        nodo.setAltura(Math.max( altura( nodo.getHijoIzquierdo()), altura( nodo.getHijoDerecho()) ) + 1);
        k1.setAltura(Math.max( altura( k1.getHijoIzquierdo()), nodo.getAltura()) + 1);
        return k1;
	}
	
	private NodoAVL<T> rotacionSimpleDer(NodoAVL<T> nodo){
		NodoAVL<T> k1 = nodo.getHijoDerecho();
        nodo.setHijoDerecho(k1.getHijoIzquierdo());
        k1.setHijoIzquierdo(nodo);
        nodo.setAltura(Math.max( altura( nodo.getHijoDerecho()), altura( nodo.getHijoIzquierdo()) ) + 1);
        k1.setAltura(Math.max( altura( k1.getHijoDerecho()), nodo.getAltura()) + 1);
        return k1;
	}
	
	private NodoAVL<T>  rotacionDobleIzq(NodoAVL<T> nodo){
		nodo.setHijoDerecho(rotacionSimpleDer( nodo.getHijoIzquierdo() ));
	    return rotacionSimpleIzq( nodo );
	}
	
	private NodoAVL<T>  rotacionDobleDer(NodoAVL<T> nodo){
		nodo.setHijoDerecho(rotacionSimpleIzq( nodo.getHijoDerecho() ));
        return rotacionSimpleDer( nodo );
	}
	
	public void printTree( )
    {
        if( this.esVacio())
            System.out.println( "Arbol Vacio" );
        else
            printTree(this.raiz);
    }
	
	 private void printTree( NodoAVL<T> t )
     {
         if( t != null )
         {
             printTree( t.getHijoIzquierdo() );
             System.out.println( t.getDato());
             printTree( t.getHijoDerecho());
         }
     }

}