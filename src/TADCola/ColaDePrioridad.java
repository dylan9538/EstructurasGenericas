package TADCola;

public class ColaDePrioridad<T> implements InterfazCola<T> {

	int longitud;
	NodoPrioridad<T> inicio;
	NodoPrioridad<T> fin;

	public ColaDePrioridad() {
		longitud = 0;
	}

	@Override
	public void enqueue(T element) {
		NodoPrioridad<T> nodo = new NodoPrioridad<T>(element);

		if (inicio == null) {
			inicio = nodo;
			fin = nodo;
		}

		else if (inicio.darPrioridad() < nodo.darPrioridad()) {
			nodo.setSig(inicio);
			inicio.setAnt(nodo);
			inicio = nodo;
		}

		else {
			boolean inserto = false;
			NodoPrioridad<T> nodoActual = (NodoPrioridad<T>) inicio.getSig();

			while (nodoActual != null && !inserto) {
				if (nodoActual.darPrioridad() < nodo.darPrioridad()) {
					NodoPrioridad<T> anterior = (NodoPrioridad<T>) nodoActual
							.getAnt();

					anterior.setSig(nodo);
					nodo.setAnt(anterior);

					nodo.setSig(nodoActual);
					nodoActual.setAnt(nodo);
					inserto = true;
				}

				nodoActual = (NodoPrioridad<T>) nodoActual.getSig();
			}

			if (!inserto) {
				fin.setSig(nodo);
				nodo.setAnt(fin);
				fin = nodo;
			}
		}

		longitud++;
	}

	@Override
	public void dequeue() {
		if (!isEmpty()) {
			if (longitud == 1) {
				inicio = null;
			}

			else {
				NodoPrioridad<T> siguiente = (NodoPrioridad<T>) inicio.getSig();
				siguiente.setAnt(null);
				inicio = siguiente;
			}

			longitud--;
		}

	}

	@Override
	public T getFront() {
		return inicio.getElement();
	}

	@Override
	public T getBack() {
		return fin.getElement();
	}

	@Override
	public boolean isEmpty() {
		return (longitud == 0) ? true : false;
	}

	@Override
	public void clear() {
		
		if (!isEmpty()) {
			while (longitud > 0) {
				dequeue();
			}
		}
	}
}
