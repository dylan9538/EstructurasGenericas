package tadHashTable;

public interface ITablaHashing <L,T> {
	
	public void agregar(L llave, T elemento);
	
	public T dar(L llave);

	public T eliminar(L llave);
	
	public int darElementos();
	
	
}
