package tadArbol;

import TADLista.ILista;

public interface IArbolBinario <K extends Comparable<K>, T> {

	
	public boolean add (K key,T contenido);
	
	public boolean agregar(ABBNodo<K,T> node);
	
	public boolean remove(K key);
	
	public T buscar(K key);
	
	public ILista<T> darLista(K key);
	
	public ABBNodo<K,T> getRoot();
	
	public boolean isNil(ABBNodo<K,T> node);
}
