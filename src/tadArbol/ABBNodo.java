package tadArbol;

import java.io.Serializable;

public class ABBNodo<K extends Comparable<K>, T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected K key;
	protected T contenido;
	protected ABBNodo<K, T> p;
	protected ABBNodo<K, T> left;
	protected ABBNodo<K, T> right;

	public ABBNodo(K key, T contenido) {
		this.key = key;
		this.contenido = contenido;
	}

	public boolean add(ABB<K, T> tree, ABBNodo<K, T> n) {
		if (n.getKey().compareTo(key) < 0) {
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

	public ABBNodo<K, T> sucesor(ABBNodo<K, T> x) {
		if (x.right != null) {
			return minimo(x.right);
		}
		ABBNodo<K, T> y = x;
		while (y != null && x == y.right) {
			x = y;
			y = y.right;
		}
		return y;
	}

	public ABBNodo<K, T> predecesor(ABBNodo<K, T> x) {
		if (x.left != null) {
			return maximo(x.left);
		}
		ABBNodo<K, T> y = x;
		while (y != null && x == y.left) {
			x = y;
			y = y.left;
		}
		return y;
	}

	public ABBNodo<K, T> maximo(ABBNodo<K, T> x) {
		while (x.getRight() != null) {
			x = x.right;
		}
		return x;
	}

	public ABBNodo<K, T> minimo(ABBNodo<K, T> x) {
		while (x.left != null) {
			x = x.left;
		}
		return x;
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

	public T getContenido(){
		return contenido;
	}
	
	public K getKey() {
		return key;
	}

	public T buscar(K key) {

		if (this.key.compareTo(key) == 0)
			return this.contenido;

		else if (key.compareTo(this.key) < 0) {
			if (left != null)
				return left.buscar(key);

			else
				return null;
		}

		else {
			if (right != null)
				return right.buscar(key);
			else
				return null;
		}
	}

	public ABBNodo<K, T> getP() {
		return p;
	}

	public ABBNodo<K, T> getLeft() {
		return left;
	}

	public ABBNodo<K, T> getRight() {
		return right;
	}

	public void setP(ABBNodo<K, T> np) {
		p = np;
	}

	public void setLeft(ABBNodo<K, T> nl) {
		left = nl;
	}

	public void setRight(ABBNodo<K, T> nd) {
		right = nd;
	}

	@Override
	public String toString() {
		return key + "";
	}
}
