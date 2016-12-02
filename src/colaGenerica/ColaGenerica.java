package colaGenerica;

import listasGenericas.ListaEnlazadaGenerica;



	public class ColaGenerica <T> {
		private ListaEnlazadaGenerica <T> datos = new ListaEnlazadaGenerica <T>();
		
		public void encolar(T elemento){
			this.datos.agregarFinal(elemento);
		}
		public T desencolar(){
			T elemento =  this.datos.elemento(1);
			this.datos.eliminar(1);
			return elemento;
		}
		public T tope(){
			return this.datos.elemento(1);
		}
		
		public boolean esVacia(){
			return this.datos.esVacia();
			
			
			
		}

	}


