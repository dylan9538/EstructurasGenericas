package TADLista;

public class NodoSimple<T> {

	T data;
	NodoSimple<T> siguiente;
	
	public NodoSimple(T data){
		this.data = data;
	}
	
	public T getElemento(){
		return data;
	}
	
	public NodoSimple<T> darSiguiente(){
		return siguiente;
	}
	
	public void cambiarSiguiente(NodoSimple<T> e){
		siguiente = e;
	}
}
