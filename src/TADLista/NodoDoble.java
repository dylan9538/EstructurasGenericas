package TADLista;

public class NodoDoble<T> {

	public NodoDoble<T> siguiente, anterior;
	public T data;
	
	
	public NodoDoble(T data){
		this.data = data;
	}
	
	public NodoDoble<T> darSiguiente(){
		return siguiente;
	}
	
	public NodoDoble<T> darAnterior(){
		return anterior;
	}
	
	public T getElemento(){
		return data;
	}
	
	public void setSiguiente(NodoDoble<T> siguiente){
		this.siguiente = siguiente;
	}
	
	public void setAnterior(NodoDoble<T> anterior){
		this.anterior = anterior;
	}
}
