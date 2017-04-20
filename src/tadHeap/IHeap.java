package tadHeap;

public interface IHeap <E extends Comparable<E>,T> {

	
	public void agregar (T contenido,E key);
	
	public boolean eliminar(E key);
	
	public T buscar(E key);
	
	public String inOrden();
	
}
