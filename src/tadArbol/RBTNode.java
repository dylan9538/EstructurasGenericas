package tadArbol;

import java.io.Serializable;



public class RBTNode<K extends Comparable<K>,T> extends ABBNodo<K,T> implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7670480991046918021L;
	private final static int UNDEFINED = 0;
    private final static int BLACK     = 1;
    private final static int RED       = 2;
    
    private int color;
    
    public RBTNode(K k, T contenido){
        super(k,contenido);
        color = UNDEFINED;
    }
    
    public void setColor(int c){
        color = c;
    }

	public boolean isRed() {
		return color==RED;
	}

	public boolean isBlack() {
		return color==BLACK;
	}

	public void setBlackColor() {
		color = BLACK;
	}

	public void setRedColor() {
		color = RED;
	}
}
