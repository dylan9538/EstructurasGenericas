package TADLista;


public interface ILista <T> {

	
	public boolean add(T e);
	
	public T get(int arg0);

	public boolean remove(T e);

	public int size();
	
	public void eliminarAlPrincipio();
	
	public void agregarAlPrincipio(T e);
	
	public T buscar( T e);
	
}
