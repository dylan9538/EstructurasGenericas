package TADLista;

public class ListaDoble<T> extends Lista<T> {

	NodoDoble<T> primero;
	NodoDoble<T> ultimo;
	int longitud;

	@Override
	public boolean add(T e) {
		boolean agrego = false;
		if (primero == null) {
			primero = new NodoDoble<T>(e);
			ultimo = primero;
			longitud++;
			agrego = true;
		} else {
			NodoDoble<T> actual = primero;

			while (actual.darSiguiente() != null) {
				actual = actual.darSiguiente();
			}

			NodoDoble<T> inserto = new NodoDoble<T>(e);
			actual.siguiente = inserto;
			inserto.anterior = actual;
			ultimo = inserto;
			longitud++;
			agrego = true;
		}

		return agrego;
	}

	@Override
	public T get(int pos) {
		T elemento = null;

		if (pos < longitud && primero != null) {
			int i = 0;
			NodoDoble<T> actual = primero;
			while (i != pos && actual.darSiguiente() != null) {
				actual = actual.darSiguiente();
				i++;
			}

			elemento = actual.getElemento();
		}

		return elemento;
	}

	@Override
	public boolean remove(T e) {
		boolean removio = false;

		if (longitud == 1) {
			if (primero.getElemento().equals(e)) {
				primero = null;
				ultimo = null;
				removio = true;
			}
		} else {

			if (primero.getElemento().equals(e)) {
				NodoDoble<T> siguiente = primero.darSiguiente();
				siguiente.setAnterior(null);
				primero = siguiente;
				removio = true;
			}

			else if (ultimo.getElemento().equals(e)) {
				NodoDoble<T> anterior = ultimo.darAnterior();
				anterior.siguiente = null;
				ultimo = anterior;
				removio = true;
			}

			else {
				NodoDoble<T> actual = primero.darSiguiente();
				while (actual != ultimo && !removio) {
					if (actual.getElemento().equals(e)) {
						NodoDoble<T> anterior = actual.darAnterior();
						NodoDoble<T> siguiente = actual.darSiguiente();
						anterior.setSiguiente(siguiente);
						siguiente.setAnterior(anterior);
						removio = true;
					}

					actual = actual.darSiguiente();
				}
			}
		}

		if (removio)
			longitud--;

		return removio;
	}

	public void agregarAlPrincipio(T e) {
		NodoDoble<T> nuevo = new NodoDoble<T>(e);
		if (primero == null)
			primero = nuevo;
		else {
			nuevo.siguiente = primero;
			primero.anterior = nuevo;
			primero = nuevo;

		}

		longitud++;
	}

	public void eliminarAlPrincipio() {
		if (longitud >= 1) {
			if (longitud == 1) {
				primero = null;
			} else {
				NodoDoble<T> siguiente = primero.darSiguiente();
				siguiente.anterior = null;
				primero = siguiente;

			}

			longitud--;
		}
	}

	@Override
	public int size() {

		return longitud;
	}

	public NodoDoble<T> darPrimero() {
		return primero;
	}

	public NodoDoble<T> darUltimo() {
		return ultimo;
	}

	@Override
	public T buscar(T e) {

		T elemento = null;
		boolean encontro = false;
		for (NodoDoble<T> p = primero; p != null && !encontro; p = p
				.darSiguiente()) {
			if (p.getElemento().equals(e)) {
				elemento = p.getElemento();
				encontro = true;
			}
		}

		return elemento;
	}

}
