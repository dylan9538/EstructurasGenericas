package TADPila;
import TADLista.*;

public class ImplementacionDos<T> implements TadPila<T> {

	
	ILista<T> lista;

	public ImplementacionDos(){
		lista = new ListaDoble<T>();
	}
	
	@Override
	public void push(T e) {
		
		lista.agregarAlPrincipio(e);
	}

	@Override
	public void pop() {
		lista.eliminarAlPrincipio();
	}

	@Override
	public T peek() {
		
		return lista.get(0);
	}

	@Override
	public boolean isEmpty() {
		return (lista.size()==0) ? true: false;
	}

	@Override
	public void clear() {	
		
		while(lista.size()>0){
			lista.remove(lista.get(0));
		}
	}
	
}