package TADLista;

public class ListaSimple<T> extends Lista<T> {

	NodoSimple<T> primero;
	NodoSimple<T> ultimo;
	int length;

	@Override
	public boolean add(T e) {
		boolean agrego = false;

		if (primero == null) {
			primero = new NodoSimple<T>(e);
			agrego = true;
			length++;
		}

		else {
			NodoSimple<T> actual = primero;
			NodoSimple<T> siguiente = primero.darSiguiente();

			while (siguiente != null) {

				actual = actual.darSiguiente();
				siguiente = siguiente.darSiguiente();
			}

			siguiente = new NodoSimple<T>(e);
			actual.siguiente = siguiente;
			agrego = true;
			length++;
		}

		return agrego;
	}

	@Override
	public T get(int laPos) {
		T elElemento = null;
		if (laPos < length && primero != null) {
			NodoSimple<T> actual = primero;
			int contador = 0;
			while (actual.darSiguiente() != null && contador != laPos) {
				contador++;
				actual = actual.darSiguiente();
			}
			elElemento = actual.getElemento();
		}
		return elElemento;
	}

	@Override
	public boolean remove(T e) {
		boolean elimino = false;
		if (length == 1) {
			if (primero.getElemento().equals(e)) {
				primero = null;
				ultimo = null;
				elimino = true;
			}
		} else {

			if (primero.getElemento().equals(e)) {
				NodoSimple<T> siguiente = primero.darSiguiente();
				primero = siguiente;
				elimino = true;
			}

			else {
				NodoSimple<T> anterior = primero;
				NodoSimple<T> actual = primero.darSiguiente();
				boolean encontro = false;
				while (actual != null && !encontro) {

					if (actual.getElemento().equals(e))
						encontro = true;
					else {
						actual = actual.darSiguiente();
						anterior = anterior.darSiguiente();
					}
				}

				if (encontro) {

					if (actual == ultimo)
						ultimo = anterior;

					else
						anterior.cambiarSiguiente(actual.darSiguiente());

					elimino = true;
				}

			}

		}
		if (elimino)
			length--;

		return elimino;
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public void eliminarAlPrincipio() {
		if (length >= 1) {
			if (length == 1)
				primero = null;

			else {
				NodoSimple<T> siguiente = primero.darSiguiente();
				primero = siguiente;
			}

			length--;
		}
	}

	@Override
	public void agregarAlPrincipio(T e) {
		NodoSimple<T> objeto = new NodoSimple<T>(e);
		if (primero == null)
			primero = objeto;

		else {
			objeto.cambiarSiguiente(primero);
			primero = objeto;
		}
		
		length++;

	}

	@Override
	public T buscar(T e) {

		T elemento = null;
		boolean encontro = false;
		for (NodoSimple<T> p = primero; p != null && !encontro; p = p
				.darSiguiente()) {
			if (p.getElemento().equals(e)) {
				elemento = p.getElemento();
				encontro = true;
			}
		}

		return elemento;
	}

}
