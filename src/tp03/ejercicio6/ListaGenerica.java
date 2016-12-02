package tp03.ejercicio6;

public abstract class ListaGenerica<T> {
	
	private int tamanio;
	
	public abstract void comenzar();
	
	public abstract T proximo();
	
	public abstract boolean fin();
	
	public abstract T elemento(int pos);
	
	public abstract boolean agregarEn(T elem, int pos);
	
	public abstract boolean agregarInicio(T elem);
	
	public abstract boolean agregarFinal(T elem);
	
	public abstract boolean eliminar(T elem);
	
	public abstract boolean eliminarEn(int pos);
	
	public abstract boolean incluye(T elem);
	
	public abstract boolean esVacia();
	
	public abstract int tamanio();
	
	public abstract boolean reemplazarEn (int pos, T elem);
	
	public abstract boolean agregarTodos(ListaGenerica<T> elems);
	
	public abstract ListaGenerica<T> clonar();
	
	public abstract void limpiar();
}
