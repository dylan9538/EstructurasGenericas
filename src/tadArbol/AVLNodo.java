package tadArbol;

import java.io.Serializable;

public class AVLNodo<K extends Comparable<K>, T> extends ABBNodo<K, T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4380151575479709179L;

	int balance;

	private final int DER = -1;
	private final int BAL = 0;
	private final int IZQ = 1;

	public AVLNodo(K k, T contenido) {
		super(k, contenido);
		balance = BAL;
	}

	public boolean add(AVL<K, T> tree, ABBNodo<K, T> nodo, boolean masAlto) {

		if (key.compareTo(nodo.key) > 0) {
			if (left == null) {
				left = nodo;
				left.p = this;

				if (right == null)
					masAlto = true;

				else
					balance = BAL;

			} else {
				AVLNodo<K, T> x = (AVLNodo<K, T>) left;
				masAlto = x.add(tree, nodo, masAlto);
			}

			if (masAlto) {
				switch (balance) {
				case IZQ:
					masAlto = false;
					if (p == null) {
						tree.root = balanceaIzq();
						tree.root.setP(null);
					} else if (p.right.equals(this)) {
						p.setRight(balanceaIzq());
					}

					else {
						p.setLeft(balanceaIzq());
					}
					break;

				case BAL:
					balance = IZQ;
					break;

				case DER:
					masAlto = false;
					balance = BAL;
					break;
				}

			}

		}

		else {
			if (right == null) {
				right = nodo;
				right.p = this;
				if (left == null) {
					masAlto = true;
				} else
					balance = BAL;
			} else {
				AVLNodo<K, T> x = (AVLNodo<K, T>) right;
				masAlto = x.add(tree, nodo, masAlto);
			}

			if (masAlto) {

				switch (balance) {
				case IZQ:
					balance = BAL;
					break;

				case BAL:
					balance = DER;
					break;

				case DER:
					masAlto = false;

					if (p == null) {
						tree.root = balanceaDer();
						tree.root.setP(null);
					} else if (p.right.equals(this)) {
						p.setRight(balanceaDer());
					} else {
						p.setLeft(balanceaDer());
					}
					break;
				}
			}
		}

		return masAlto;
	}

	public void rebalancear(AVL<K, T> tree) {

		ABBNodo<K, T> x = darNodoABalancear(tree);
		System.out.println(x.key);
		AVLNodo<K, T> y = (AVLNodo<K, T>) x;
		int balance = y.verificarBalance();

		if (x.p == null) {
			if (balance > 1) {
				tree.root = balanEliIzq(x, false);
				tree.root.setP(null);
			}

			else {
				tree.root = balanEliDer(x, false);
				tree.root.setP(null);
			}
		}

		else {
			if (x.p.getRight().equals(x)) {
				if (balance > 1) {
					x.p.setRight(balanEliIzq(x, false));
				}

				else {
					x.p.setRight(balanEliDer(x, false));
				}
			}

			else {
				if (balance > 1) {
					x.p.setLeft(balanEliIzq(x, false));
				}

				else {
					x.p.setLeft(balanEliDer(x, false));
				}
			}
		}
	}

	private ABBNodo<K, T> darNodoABalancear(AVL<K, T> tree) {
		if (verificarBalance() > 1) {
			AVLNodo<K, T> x = (AVLNodo<K, T>) left;
			return x.darNodoABalancear(tree);
		}

		else if (verificarBalance() < -1) {
			AVLNodo<K, T> x = (AVLNodo<K, T>) right;
			return x.darNodoABalancear(tree);
		}

		else {
			if (p == null)
				return tree.root;

			else
				return p;
		}
	}

	public void actualizarBalance() {
		int num = verificarBalance();
		if (num != balance)
			balance = num;

		if (right != null) {
			AVLNodo<K, T> x = (AVLNodo<K, T>) right;
			x.actualizarBalance();
		}

		if (left != null) {
			AVLNodo<K, T> x = (AVLNodo<K, T>) left;
			x.actualizarBalance();
		}
	}

	public int verificarBalance() {
		int uno = 0;
		int dos = 0;
		if (left != null)
			uno = left.darAltura();
		if (right != null)
			dos = right.darAltura();

		return uno - dos;
	}

	private ABBNodo<K, T> balanceaDer() {
		AVLNodo<K, T> x = (AVLNodo<K, T>) right;
		if (x.balance == DER) {
			balance = BAL;
			x.balance = BAL;
			return roteIzq();
		}

		else {
			AVLNodo<K, T> y = (AVLNodo<K, T>) x.getLeft();

			switch (y.balance) {
			case IZQ:
				balance = BAL;
				x.balance = DER;
				break;

			case BAL:
				balance = x.balance = BAL;
				break;

			case DER:
				balance = IZQ;
				x.balance = BAL;
				break;
			}

			y.balance = BAL;
			return roteDerIzq();
		}
	}

	private ABBNodo<K, T> balanceaIzq() {
		AVLNodo<K, T> x = (AVLNodo<K, T>) left;
		if (x.balance == IZQ) {
			balance = BAL;
			x.balance = BAL;
			return roteDer();
		}

		else {
			AVLNodo<K, T> y = (AVLNodo<K, T>) x.getRight();
			switch (y.balance) {
			case IZQ:
				balance = DER;
				x.balance = BAL;
				break;

			case BAL:
				balance = BAL;
				x.balance = BAL;
				break;

			case DER:
				balance = BAL;
				x.balance = IZQ;
				break;
			}

			y.balance = BAL;
			return roteIzqDer();
		}
	}

	public ABBNodo<K, T> balanEliDer(ABBNodo<K, T> node, boolean menosAlto) {
		AVLNodo<K, T> y = (AVLNodo<K, T>) node;
		AVLNodo<K, T> x = (AVLNodo<K, T>) node.getLeft();
		AVLNodo<K, T> z = (AVLNodo<K, T>) node.getRight();

		switch (y.balance) {
		case IZQ:
			y.balance = BAL;
			break;

		case BAL:
			y.balance = DER;
			menosAlto = false;
			break;

		case DER:
			if (z.balance != IZQ) {
				node = y.roteIzq();

				if (y.balance == BAL) {
					y.balance = IZQ;
					x.balance = DER;
					menosAlto = false;
				}

				else
					y.balance = x.balance = BAL;
			}

			else {
				node = y.roteDerIzq();
				x.balance = (y.balance == DER) ? IZQ : BAL;
				z.balance = (y.balance == IZQ) ? DER : BAL;
				y.balance = BAL;
			}
		}

		return node;
	}

	public ABBNodo<K, T> balanEliIzq(ABBNodo<K, T> node, boolean menosAlto) {
		AVLNodo<K, T> y = (AVLNodo<K, T>) node;
		AVLNodo<K, T> x = (AVLNodo<K, T>) node.getLeft();
		AVLNodo<K, T> z = (AVLNodo<K, T>) node.getRight();
		switch (y.balance) {
		case IZQ:
			if (x.balance != DER) {
				node = y.roteDer();

				if (y.balance == BAL) {
					y.balance = DER;
					z.balance = IZQ;
					menosAlto = false;
				}

				else
					y.balance = z.balance = BAL;
			}

			else {
				node = y.roteIzqDer();
				z.balance = (y.balance == IZQ) ? DER : BAL;
				x.balance = (y.balance == DER) ? IZQ : BAL;
				y.balance = BAL;
			}
			break;

		case BAL:
			y.balance = IZQ;
			menosAlto = false;
			break;

		case DER:
			y.balance = BAL;
			break;

		}

		return node;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	private ABBNodo<K, T> roteIzq() {
		ABBNodo<K, T> temp = right;
		right = temp.getLeft();
		if (right != null)
			right.setP(this);

		temp.setLeft(this);
		p = temp;
		return temp;
	}

	private ABBNodo<K, T> roteDer() {
		ABBNodo<K, T> temp = left;
		left = temp.getRight();
		if (left != null)
			left.setP(this);
		temp.setRight(this);
		p = temp;
		return temp;
	}

	private ABBNodo<K, T> roteDerIzq() {
		AVLNodo<K, T> x = (AVLNodo<K, T>) right;
		right = x.roteDer();
		right.setP(this);
		return roteIzq();
	}

	private ABBNodo<K, T> roteIzqDer() {
		AVLNodo<K, T> x = (AVLNodo<K, T>) left;
		left = x.roteIzq();
		left.setP(this);
		return roteDer();
	}
}
