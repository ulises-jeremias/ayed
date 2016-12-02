package tp03.ejercicio9;

import tp03.ejercicio6.ListaEnlazadaGenerica;

public class ListaInvertidaDeGramas {
	
	private ListaEnlazadaGenerica<ListaEnlazadaGenerica<String>> lista;
	private int longGrama;
	private int tamanio;
	
	public ListaInvertidaDeGramas (int longGrama){
		lista = new ListaEnlazadaGenerica<ListaEnlazadaGenerica<String>>();
		this.longGrama= longGrama;
		tamanio= 0;
	}
	
	public int tamanio(){
		return tamanio;
	}
	
	
	public void agregar (String palabra){
		boolean ok;
		for (int i=0; i < palabra.length()-longGrama; i++){
			String grama = palabra.substring(i, i + longGrama);
			ListaEnlazadaGenerica<String> nuevo = new ListaEnlazadaGenerica<String>();
			ok= false;
			if (tamanio == 0){
				lista.agregarInicio(nuevo);
				tamanio++;
			}
			else {
				  for (int j=1; j <= lista.tamanio(); j++){
					if (lista.elemento(j).incluye (grama)){
						ok= true;
						lista.elemento(j).agregarFinal(palabra);	
					}
					if (!ok){
						nuevo.agregarInicio(grama);
						nuevo.agregarFinal(palabra);
						lista.agregarFinal(nuevo);
						tamanio++;
				    }
				  } 
		   }
	    }		
   }
	
	public ListaEnlazadaGenerica<String> recuperarListaDePalabras(String palabra) {
		ListaEnlazadaGenerica<String> nuevo = new ListaEnlazadaGenerica<String>();
		for (int i=0; i < palabra.length() - longGrama; i++){
			String grama = palabra.substring(i, i + longGrama);
			int j=0;
			while ((j < tamanio) && (lista.elemento(j).elemento(1) != grama)){
				j++;
			}
			if (j < tamanio){
				for (int k=2; k < lista.elemento(j).tamanio(); k++){
					String aux= lista.elemento(j).elemento(k); 
					if (! nuevo.incluye(aux)){
						nuevo.agregarFinal(aux);
					}
				}
			}
				
			}
		return nuevo;
	}
	
	public void ImprimirListaInvertida (){
		for (int i=1; i < tamanio; i++){
			lista.elemento(i);
		}
		
		
	}
	
}
