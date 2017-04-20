package TADCola;

public class Cola<T> implements InterfazCola<T> {

	protected Nodo<T> inicio;
	protected Nodo<T> fin;
	protected int longitud;

	public Cola() {
		this.longitud = 0;
	}

	public void enqueue(T element) {
		if (inicio == null) {
			inicio = new Nodo<T>(element);
			fin = inicio;
		} else {

			Nodo<T> actual = new Nodo<T>(element);
			fin.setSig(actual);
			actual.setAnt(fin);
			fin = actual;
		}
		longitud++;
	}

	public void dequeue() {
		if (!isEmpty()) {
			if (longitud == 1) {
				inicio = null;
			} else {
				Nodo<T> siguiente = inicio.getSig();
				siguiente.setAnt(null);
				inicio = siguiente;
				
			}
			
			longitud--;
		}

	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if (longitud == 0)
			empty = true;

		return empty;
	}

	@Override
	public void clear() {
		if (!isEmpty()) {
			while (longitud > 0) {
				dequeue();
			}
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
}
