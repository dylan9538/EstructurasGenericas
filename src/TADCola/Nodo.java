package TADCola;

public class Nodo<T> {
	private Nodo<T> ant;
	private Nodo<T> sig;
	private T element;
	
	public Nodo(T element){
		this.ant=null;
		this.sig=null;
		this.element= element;
	}

	public Nodo<T> getAnt() {
		return ant;
	}

	public void setAnt(Nodo<T> ant) {
		this.ant = ant;
	}

	public Nodo<T> getSig() {
		return sig;
	}

	public void setSig(Nodo<T> sig) {
		this.sig = sig;
	}

	public T getElement() {
		return element;
	}
	public void setElement(T e){
		this.element=e;
	}
	
	
}
