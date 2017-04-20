package TADCola;

public interface InterfazCola<T> {

	public void enqueue(T element);

	public void dequeue();

	public T getFront();
	
	public T getBack();
	
	public boolean isEmpty();
	
	public void clear();

}