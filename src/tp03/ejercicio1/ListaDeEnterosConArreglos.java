package tp03.ejercicio1;

public class ListaDeEnterosConArreglos extends ListaDeEnteros {
	private int tamanio;
	private Integer[] datos = new Integer[10];
	private int actual = 0;

	@Override
	public void comenzar() {
		actual = 0;
	}

	@Override
	public Integer proximo() {
		return datos[actual++];
	}

	@Override
	public boolean fin() {
		return actual == tamanio;
	}

	@Override
	public Integer elemento(int pos) {
		return datos[pos - 1];
	}

	@Override
	// Se considera pos 1 al indice 0
	public boolean agregarEn(Integer elem, int pos) {
		if (pos < 1 || pos > tamanio + 1 || pos > datos.length
				|| tamanio == datos.length)
			return false;
		tamanio++;
		for (int i = tamanio - 1; i >= pos; i--)
			datos[i] = datos[i - 1];
		datos[pos - 1] = elem;
		return true;
	}

	@Override
	public boolean agregarInicio(Integer elem) {
		// TODO Auto-generated method stub
		return this.agregarEn(elem, 1); 
	}



	@Override
	public boolean eliminar(Integer elem) {
		// TODO Auto-generated method stub
		boolean encontre = false;
		int i = 0;
		while (i < tamanio && !encontre) {
			if (datos[i].equals(elem)) {
				eliminarEn(i+1);
				encontre = true;
			}
			i++;
		}
		return encontre;
	}

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 1 || pos > tamanio)
			return false;
		tamanio--;
		for (int i = pos - 1; i < tamanio; i++)
			datos[i] = datos[i + 1];
		return true;
	}

	
	@Override
	public boolean esVacia() {
		// TODO Auto-generated method stub
		return (tamanio==0);
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < this.tamanio; i++) {
			str = str + datos[i] + " -> ";
		}
		if (str.length() > 1)
			str = str.substring(0, str.length() - 4);

		return str;
	}

	@Override
	public boolean agregarFinal(Integer elem) {
		return this.agregarEn(elem, tamanio + 1);
	}

	@Override
	public boolean incluye(Integer elem) {
		boolean query = false;
		int i = 1;
		while(i <= tamanio && !query){
			if(this.elemento(i) == elem){
				query = true;
			}
		}
		return query;
	}

	@Override
	public int tamanio() {
		return this.tamanio;
	}

}
