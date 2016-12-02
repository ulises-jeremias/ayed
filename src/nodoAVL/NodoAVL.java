package nodoAVL;

public class NodoAVL<T extends Comparable<T>> {

	private T dato;
	private int altura;

	private NodoAVL<T> hijoIzquierdo;
	private NodoAVL<T> hijoDerecho;
	
	public NodoAVL(T dato){		
		this.dato = dato;
		this.hijoIzquierdo = null;
		this.hijoDerecho = null;
	}
	
	public T getDato(){		
		return this.dato; 
	}
	
	public NodoAVL<T> getHijoIzquierdo(){		
		return this.hijoIzquierdo;
	}
	
	public NodoAVL<T> getHijoDerecho(){		
		return this.hijoDerecho;
	}	
	
	public void setDato(T dato){		
		this.dato = dato;
	}
	
	public void setHijoIzquierdo(NodoAVL<T> hijoIzq){		
		this.hijoIzquierdo = hijoIzq;
	}
	
	public void setHijoDerecho(NodoAVL<T> hijoDer){		
		this.hijoDerecho = hijoDer;
	}
	
	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

}
