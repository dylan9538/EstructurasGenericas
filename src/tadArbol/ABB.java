package tadArbol;

import java.io.Serializable;

import TADLista.ILista;

public class ABB<K extends Comparable<K>, T> implements IArbolBinario<K, T>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6155810179940133470L;
	public ABBNodo<K, T> root;

	public ABB() {
	}

	public boolean add(K key, T contenido) {
		boolean agrego = false;
		if (isNil(root)) {
			root = new ABBNodo<K, T>(key, contenido);
			agrego = true;
		} else {
			ABBNodo<K, T> node = new ABBNodo<K, T>(key, contenido);
			agrego = root.add(this, node);
		}

		return agrego;
	}

	public boolean agregar(ABBNodo<K, T> node) {
		boolean agrego = false;
		if (isNil(root)) {
			root = node;
			agrego = true;
		} else
			agrego = root.add(this, node);
		
		return agrego;
	}

	public boolean remove(K k) {
		root = borrar(root, k);
		return true;
	}

	private ABBNodo<K, T> borrar(ABBNodo<K, T> r, K k) {
		if (r.key.equals(k)) {
			if (r.right == null && r.left == null) {
				r = null;
				return r;
			} else if (r.right == null) {
				r = r.left;
				return r;
			}

			else if (r.left == null) {
				r = r.right;
				return r;
			} else {
				r.key = antecesor(r.left);
				r = transplantar(r, r.left, r);
				return r;
			}
		}

		else {
			if (k.compareTo(r.key) > 0) {
				r.right = borrar(r.right, k);
				return r;
			}

			else {
				r.left = borrar(r.left, k);
				return r;
			}
		}
	}

	private K antecesor(ABBNodo<K, T> r) {
		if (r.right == null)
			return r.key;
		else
			return antecesor(r.right);
	}

	private ABBNodo<K, T> transplantar(ABBNodo<K, T> padre, ABBNodo<K, T> hijo,
			ABBNodo<K, T> ances) {
		if (hijo.right == null) {
			if (padre.equals(ances)) {
				padre.left = hijo.left;
				return padre;
			}
			padre.right = hijo.left;
			return padre;
		} else {
			hijo = transplantar(hijo, hijo.right, ances);
			if (padre.equals(ances))
				padre.left = hijo;
			else
				padre.right = hijo;
			return padre;
		}
	}

	public final void setRoot(ABBNodo<K, T> node) {
		root = node;
	}

	public ABBNodo<K, T> getRoot() {
		return root;
	}

	public boolean isNil(ABBNodo<K, T> node) {
		if(node!=null)
			if(node.key==null)
				return true;
			else return false;
		
		else return true;
	}
	
	
	
	@Override
	public T buscar(K key) {
		if(root!=null){
			
			 return root.buscar(key);
		}
		
		else return null;
	}

	@Override
	public ILista<T> darLista(K key) {
		// TODO Auto-generated method stub
		return null;
	}

}
