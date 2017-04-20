package TADCola;

public class NodoPrioridad<T> extends Nodo<T> implements IPrioridad {

	public NodoPrioridad(T element) {
		super(element);
	}

	@Override
	public int darPrioridad() {
		return getElement().hashCode();
	}

}
