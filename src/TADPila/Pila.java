package TADPila;

public class Pila<T> implements TadPila<T> {

	NodoPila<T> tope;


	@Override
	public void push(T e) {
		NodoPila<T> p = new NodoPila<T>(e);
		if(tope== null){
			tope = p;
		}else{
			p.siguiente = tope;
			tope.anterior = p;
			tope = p;
		}
	}

	@Override
	public void pop() {
		
		if(tope!=null){
		NodoPila<T> siguiente = tope.siguiente;
		
		if(siguiente!=null){
		siguiente.anterior = null;
		tope = siguiente;
		}
		
		else tope = null;
		
		}
		
	}

	@Override
	public T peek() {
		T contenido = null;
		
		if(tope!= null)
			contenido = tope.getContenido();
		return contenido;
	}

	@Override
	public boolean isEmpty() {
		return (tope== null)?  true: false;
	}

	@Override
	public void clear() {
		tope = null;
		
	}
	
	
	
}
