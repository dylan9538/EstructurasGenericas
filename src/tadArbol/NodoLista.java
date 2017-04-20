package tadArbol;

import java.io.Serializable;


import TADLista.ILista;
import TADLista.ListaDoble;

public class NodoLista<K extends Comparable<K>,T> extends ABBNodo<K,T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ILista<T> listaDoble;

	public NodoLista(K key, T contenido) {
		super(key, contenido);
		listaDoble = new ListaDoble<T>();
	}

	public boolean add(ABBLista<K, T> tree, NodoLista<K, T> n) {
		
		if(key.compareTo(n.getKey())== 0){
			System.out.println(listaDoble.size());
			listaDoble.add(n.getContenido());
			return true;
		}
		else if (n.getKey().compareTo(key) < 0) {
			if (tree.isNil(left)) {
				left = n;
				n.setP(this);
				return true;
			} else {
				return left.add(tree, n);
			}
		} else {
			if (tree.isNil(right)) {
				right = n;
				n.setP(this);
				return true;
			} else {
				return right.add(tree, n);
			}
		}
	}

	public ILista<T> darElementos(K key){
		
		if(this.key.compareTo(key) == 0){
			return this.listaDoble;
		}
		
		else if(this.key.compareTo(key)>0){
			if(left!=null){
				NodoLista<K,T> x= (NodoLista<K,T>) left;
				return x.darElementos(key);
			}
			
			else return null;
		}
		
		
		else {
			if(right!=null){
				NodoLista<K,T> x= (NodoLista<K,T>) right;
				return x.darElementos(key);
			}
			
			else return null;
		}
	}


	public int darAltura() {
		int izq = 0;
		int der = 0;
		if (left != null)
			izq = left.darAltura();
		if (right != null)
			der = right.darAltura();

		return Math.max(izq, der) + 1;
	}

	public K getKey() {
		return key;
	}


	@Override
	public String toString() {
		return key + "";
	}
	
}
