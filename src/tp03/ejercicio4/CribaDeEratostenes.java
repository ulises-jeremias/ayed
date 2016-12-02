package tp03.ejercicio4;

import tp03.ejercicio1.ListaDeEnteros;
import tp03.ejercicio1.ListaDeEnterosEnlazada;

public class CribaDeEratostenes {
	
	public ListaDeEnteros obtenerPrimo(ListaDeEnteros lista){
		ListaDeEnteros primos = new ListaDeEnterosEnlazada();
		this.duplicar(primos, lista);
		int raiz = (int) Math.sqrt(lista.tamanio())+1;
		primos.eliminarEn(1);
		int i = 1;
		while (raiz >= primos.elemento(i)){
			int primo= primos.elemento(i);
			for (int j=1; j< primos.tamanio()+1; j++){
				if ((primos.elemento(j) != primo)&&((primos.elemento(j)%primo) == 0)){
					primos.eliminarEn(j);
				}
			}
		i++;
		}
		return primos;
	}
	
	private void duplicar(ListaDeEnteros primos, ListaDeEnteros lista){
		while(!lista.fin()){
			primos.agregarFinal(lista.proximo());
		}
	}
}
