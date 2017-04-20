package tadHashTable;

public class Bucket<L,T> {

	private T elemento;
	private L llave;
	
	public Bucket(L llave, T elemento){
		this.llave = llave;
		this.elemento = elemento;
	}
	
	public Bucket(L llave){
		this.llave = llave;
	}
	
	
	public L getLLave(){
		return llave;
	}
	
	public T getElemento(){
		return elemento;
	}
	
	public void setElemento( T elemento ){
		this.elemento = elemento;
	}
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object o){
		
		boolean igual = false;
		
		if(o instanceof Bucket){
			
			Bucket<L,T> nodo = (Bucket<L,T>) o;
			igual = llave.equals(nodo.getLLave());
			
		}
		
		return igual;
	}
	
}
