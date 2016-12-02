package listasGenericas;

public abstract class ListaGenerica<T> {
	
	protected int tamanio;
	
	abstract public void comenzar();
	abstract public T proximo();
	abstract public boolean fin();
	abstract public T elemento(int pos);
	abstract public boolean agregarEn(T elem, int pos);
	abstract public boolean agregarInicio(T elem);
	abstract public boolean agregarFinal(T elem);
	abstract public boolean eliminar(T elem);
	abstract public boolean eliminar(int pos);
	abstract public boolean esVacia();
	abstract public boolean incluye(T elem);
	abstract public int tamanio();
}
