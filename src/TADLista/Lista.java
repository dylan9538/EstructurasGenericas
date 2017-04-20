package TADLista;


public abstract class Lista<T> implements ILista<T>{

	@Override
	public abstract boolean add(T e);

	@Override
	public abstract T get(int arg0);
	
	@Override
	public abstract boolean remove(T e);

	@Override
	public abstract int size();
}
