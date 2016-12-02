package arbolGeneral;

import listasGenericas.ListaEnlazadaGenerica;
import listasGenericas.ListaGenerica;

public class NodoGeneral<T> {

    private T dato;
    private ListaGenerica<NodoGeneral<T>> listaHijos;
    
    public NodoGeneral(T dato){

        this.dato = dato;
        listaHijos = new ListaEnlazadaGenerica<NodoGeneral<T>>();
    }
    
    public T getDato(){

        return this.dato;
    }    
    
    public ListaGenerica<NodoGeneral<T>> getHijos(){

        return this.listaHijos;
    }     
    
    public void setDato(T dato){

        this.dato = dato;
    }
    
    public void setListaHijos(ListaGenerica<NodoGeneral<T>> lista){

        this.listaHijos = lista;
    }    
    
}
