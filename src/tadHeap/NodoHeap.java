package tadHeap;

public class NodoHeap<E extends Comparable<E>, T> {

	NodoHeap<E, T> der, izq, padre;

	public NodoHeap<E, T> getPadre() {
		return padre;
	}

	public void setPadre(NodoHeap<E, T> padre) {
		this.padre = padre;
	}

	private T contenido;
	private E key;

	public NodoHeap(T contenido, E key) {
		this.contenido = contenido;
		this.key = key;
	}

	public String inOrden() {
		String cadena = "";
		if (izq != null)
			cadena += izq.inOrden();
		cadena += key + " ";
		if (der != null)
			cadena += der.inOrden();

		return cadena;
	}

	public NodoHeap<E, T> getDer() {
		return der;
	}

	public void setDer(NodoHeap<E, T> der) {
		this.der = der;
	}

	public NodoHeap<E, T> getIzq() {
		return izq;
	}

	public void setIzq(NodoHeap<E, T> izq) {
		this.izq = izq;
	}

	public T getContenido() {
		return contenido;
	}

	public void setContenido(T contenido) {
		this.contenido = contenido;
	}

	public E getKey() {
		return key;
	}

	public void setKey(E key) {
		this.key = key;
	}

	public boolean esHoja() {
		return (izq == null && der == null);
	}

	public boolean sePuedeAgregar() {
		return (izq == null || der == null);
	}

}
