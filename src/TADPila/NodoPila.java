package TADPila;

public class NodoPila <T> {

	
	 private T contenido;
	
	protected NodoPila<T> siguiente, anterior;
	
	public NodoPila(T e){
		contenido = e;
	}
	
	public T getContenido(){
		return contenido;
	}
	
	public NodoPila<T> darSiguiente(){
		return siguiente;
	}
	
	public NodoPila<T> darAnterior(){
		return anterior;
	}
}
