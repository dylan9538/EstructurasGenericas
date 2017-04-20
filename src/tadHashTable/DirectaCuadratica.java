package tadHashTable;

import java.lang.reflect.Array;

import TADLista.*;

public class DirectaCuadratica<L, T> implements ITablaHashing<L, T> {

	public final static double FACTOR_CARGA_ACEPTABLE = 0.75;
	public final static int CAPACIDAD = 35;

	private ILista<Bucket<L, T>>[] listaTabla;

	private int capacidad, numElementos;

	@SuppressWarnings("unchecked")
	public DirectaCuadratica() {
		listaTabla = (ListaDoble<Bucket<L, T>>[]) Array.newInstance(
				ListaDoble.class, CAPACIDAD);
		capacidad = CAPACIDAD;
		numElementos = 0;

		inicializarPosiciones();
	}

	@Override
	public void agregar(L llave, T elemento) {
		int indice = funcionHash(llave);
		Bucket<L, T> entrada = buscarLugarInsercion(indice, llave);

		if (entrada == null) {

			entrada = new Bucket<L, T>(llave, elemento);
			listaTabla[indice].add(entrada);
			numElementos++;
//			 falta verificar factor de Carga
		}

		else {
			entrada.setElemento(elemento);
		}

	}

	@Override
	public T dar(L llave) {
		int indice = funcionHash(llave);
		Bucket<L, T> entrada = buscarLugarInsercion(indice, llave);
		
		return (entrada!=null) ? entrada.getElemento(): null;
	}

	@Override
	public T eliminar(L llave) {
		
		int indice = funcionHash(llave);
		Bucket<L, T> entrada = buscarLugarInsercion(indice, llave);
		
		if(entrada != null){
			listaTabla[indice].remove(entrada);
			numElementos--;
			
			return entrada.getElemento();
		}
		
		else return null;
	}

	@Override
	public int darElementos() {
		return numElementos;
	}

	private Bucket<L, T> buscarLugarInsercion(int indice, L llave) {
		Bucket<L, T> lugarInsercion = new Bucket<L, T>(llave);

		ILista<Bucket<L, T>> lista = listaTabla[indice];
		lugarInsercion = lista.buscar(lugarInsercion);

		return lugarInsercion;
	}

	private int funcionHash(L llave) {

		return (int) Math.abs(Math.floor(CAPACIDAD*((0.61803*llave.hashCode())%1)));
	}
	
	
	
	private void inicializarPosiciones() {

		for (int i = 0; i < listaTabla.length; i++) {
			listaTabla[i] = new ListaDoble<Bucket<L, T>>();
		}
	}

}
