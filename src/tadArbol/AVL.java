package tadArbol;

import java.io.Serializable;

public class AVL<K extends Comparable<K>, T> extends ABB<K, T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4796492186992088265L;
	boolean masAlto;

	public AVL() {

		masAlto = false;
	}

	public boolean add(K key, T contenido) {
		ABBNodo<K, T> node = new AVLNodo<K, T>(key, contenido);
		if (root == null) {
			root = node;
			return true;
		} else {
			AVLNodo<K, T> y = (AVLNodo<K, T>) root;
			masAlto = y.add(this, node, masAlto);
			if (masAlto == false) {
				if (y.verificarBalance() != 0)
					masAlto = true;
			}

			return true;
		}
	}

	public boolean remove(K key) {
		super.remove(key);
		verificaBalanceo();
		return true;
	}

	
	private void verificaBalanceo() {
		if (root != null) {
			AVLNodo<K, T> x = (AVLNodo<K, T>) root;
			if (x.verificarBalance() > 1 || x.verificarBalance() < -1)
				x.rebalancear(this);

			
			if (x.verificarBalance() != 0)
				masAlto = true;
			else
				masAlto = false;
			
			x.actualizarBalance();
		}
		
	

	}
}
