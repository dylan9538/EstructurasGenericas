package tadHeap;

import java.lang.reflect.Array;

public class Heap<E extends Comparable<E>, T> implements IHeap<E, T> {

	public final static int MAX = 1;
	public final static int MIN = -1;
	private final static int DELTA = 20;
	private final static int CAPACIDAD = 40;

	private int tipo;
	private NodoHeap<E, T>[] elementos;
	private int peso;
	private NodoHeap<E, T> root;

	@SuppressWarnings("unchecked")
	public Heap(int tipo) {
		this.tipo = tipo;
		elementos = (NodoHeap<E, T>[]) Array.newInstance(NodoHeap.class,
				CAPACIDAD);
		peso = 0;
	}

	@SuppressWarnings("unchecked")
	public Heap(int tipo, int capacidad) {
		this.tipo = tipo;
		elementos = (NodoHeap<E, T>[]) Array.newInstance(NodoHeap.class,
				capacidad);
		peso = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void agregar(T contenido, E key) {
		if (peso == elementos.length) {
			NodoHeap<E, T>[] ant = elementos;
			elementos = (NodoHeap<E, T>[]) Array.newInstance(NodoHeap.class,
					elementos.length + DELTA);
			System.arraycopy(ant, 0, elementos, 0, ant.length);
		}

		NodoHeap<E, T> x = new NodoHeap<E, T>(contenido, key);
		peso++;
		int pos = peso - 1;
		int padre = ((int) Math.floor((pos - 1) / 2));

		if (peso == 1)
			padre = 0;

		if (tipo == MIN) {

			while (padre >= 0 && pos > 0
					&& x.getKey().compareTo(elementos[padre].getKey()) < 0) {
				elementos[pos] = elementos[padre];
				pos = padre;
				padre = ((int) Math.floor((pos - 1) / 2));
			}

		}

		else {
			while (padre >= 0 && pos > 0
					&& x.getKey().compareTo(elementos[padre].getKey()) > 0) {
				elementos[pos] = elementos[padre];
				pos = padre;
				padre = ((int) Math.floor((pos - 1) / 2));
			}
		}

		elementos[pos] = x;

	}

	@Override
	public boolean eliminar(E key) {

		boolean elimino = false;
		if (peso > 0) {
			int posEliminado = -1;
			int i = 0;

			while (posEliminado == -1 && i < peso) {
				if (elementos[i].getKey().compareTo(key) == 0)
					posEliminado = i;
				i++;
			}

			if (posEliminado != -1) {
				if (posEliminado < peso - 1) {
					elementos[posEliminado] = elementos[peso - 1];
				}
				elementos[peso - 1] = null;
				peso--;
				elimino = true;
				
				HeapSort(posEliminado);
			}
		}
		return elimino;
	}

	private void HeapSort(int indice) {
		if (tipo == MIN)
			heapMin(indice);

		else
			heapMax(indice);
	}

	private void heapMax(int indice) {
		boolean terminado = false;

		NodoHeap<E, T> elemento = elementos[indice];
		int mayorIzq = ((2 *indice) + 1);

		while (!terminado && mayorIzq < peso) {
			int mayorDerecho = mayorIzq + 1;

			// Se determina cual de los dos hijos tiene el valor mayor
			if (mayorDerecho < peso
					&& elementos[mayorDerecho].getKey().compareTo(
							elementos[mayorIzq].getKey()) > 0) {
				mayorIzq = mayorDerecho;
			}

			if (elemento.getKey().compareTo(elementos[mayorIzq].getKey()) < 0) {
				elementos[indice] = elementos[mayorIzq];
				indice = mayorIzq;
				mayorIzq = ((2 *indice) + 1);
			} else {
				terminado = true;
			}
		}
		elementos[indice] = elemento;
	}

	private void heapMin(int indice) {
		boolean terminado = false;
		NodoHeap<E, T> elemento = elementos[indice];
		int menorIzq = ((2 *indice) + 1);

		while (!terminado && menorIzq < peso) {
			int menorDerecho = menorIzq + 1;

			// Se determina cual de los dos hijos tiene el valor mayor
			if (menorDerecho < peso
					&& elementos[menorDerecho].getKey().compareTo(
							elementos[menorIzq].getKey()) < 0) {
				menorIzq = menorDerecho;
			}

			if (elemento.getKey().compareTo(elementos[menorIzq].getKey()) > 0) {
				elementos[indice] = elementos[menorIzq];
				indice = menorIzq;
				menorIzq = ((2 *indice) + 1);
			} else {
				terminado = true;
			}
		}
		elementos[indice] = elemento;
	}

	@Override
	public T buscar(E key) {

		int cont = 0;
		T elemento = null;
		while (cont < peso && elemento == null) {
			if (elementos[cont].getKey().compareTo(key) == 0) {
				elemento = elementos[cont].getContenido();
			}
			cont++;
		}
		return elemento;
	}

	private void actualizarArbol() {
		if (peso > 0) {
			boolean nulo = false;
			for (int i = 0; i < peso && !nulo; i++) {
				int izq = ((2 * i) + 1);
				if (izq <= peso) {
					elementos[i].setIzq(elementos[izq]);
					if ((izq + 1) <= peso)
						elementos[i].setDer(elementos[izq + 1]);
				}
			}

			root = elementos[0];
		}
	}

	@Override
	public String inOrden() {
		actualizarArbol();
		String cadena = "";
		if (root != null) {
			cadena = root.inOrden();
		}
		return cadena;
	}

}
