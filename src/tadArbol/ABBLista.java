package tadArbol;

import java.io.Serializable;

import TADLista.ILista;

public class ABBLista<K extends Comparable<K>,T> extends ABB<K,T>  implements IArbolBinario<K, T>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6155810179940133470L;

	public ABBLista() {
	}

	public boolean add(K key, T contenido) {
		NodoLista<K,T> node = new NodoLista<K,T>(key,contenido);
		boolean agrego = false;
		if (isNil(root)) {
			root = node;
			agrego = true;
		} else {
			NodoLista<K,T> x = (NodoLista<K,T>) root;
			agrego = x.add(this, node);
		}

		return agrego;
	}

	public boolean isNil(ABBNodo<K, T> node) {
		if(node!=null)
			if(node.key==null)
				return true;
			else return false;
		
		else return true;
	}
	
	
	
	@Override
	public ILista<T> darLista(K key) {
		if(root!=null){
			NodoLista<K,T> x = (NodoLista<K,T>) root;
			return x.darElementos(key);
		}
		
		else return null;
	}

}
