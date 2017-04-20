package tadArbol;

import java.io.Serializable;



public class RBTTree<K extends Comparable<K>,T> extends ABB<K,T> implements IArbolBinario<K, T>, Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5753215057765280194L;
	private RBTNode<K,T> nil;
    
    public RBTTree(){
        initializeNil();
    }
    
    private void initializeNil(){
        nil = new RBTNode<K,T>(null, null);  //la clave (key) de este nodo realmente no importa
        nil.setBlackColor();           //el color SI que es importante
        if(root==null){
            root = nil;
        }
    }
    
    private void initializeNilRelations(ABBNodo<K,T> node){
        if(node!=nil){
            node.setLeft(nil);
            node.setRight(nil);
            node.setP(nil);
        }
    }
    
    
    public boolean add(K key, T contenido){
    	
    	RBTNode<K,T> x = new RBTNode<K,T>(key, contenido);
        initializeNilRelations(x);
        boolean agrego = super.agregar(x);
        x.setRedColor();
        
        while(x!=root && ((RBTNode<K,T>)x.getP()).isRed()){
            RBTNode<K,T> y; //el tío :)
            if(x.getP()==x.getP().getP().getLeft()){
                y = (RBTNode<K,T>)x.getP().getP().getRight();
                if(y.isRed()){ //Caso 1
                    ((RBTNode<K,T>)x.getP()).setBlackColor();
                    y.setBlackColor();
                    ((RBTNode<K,T>)x.getP().getP()).setRedColor();
                    x = (RBTNode<K,T>)x.getP().getP();
                }else{
                    if(x==x.getP().getRight()){ //Caso 2
                        x = (RBTNode<K,T>)x.getP();
                        leftRotate(x);
                    }
                    //Caso 3
                    ((RBTNode<K,T>)x.getP()).setBlackColor();
                    ((RBTNode<K,T>)x.getP().getP()).setRedColor();
                    rightRotate((RBTNode<K,T>)x.getP().getP());
                }
            }else{
                y = (RBTNode<K,T>)x.getP().getP().getLeft();
                if(y.isRed()){ //Caso 1
                    ((RBTNode<K,T>)x.getP()).setBlackColor();
                    y.setBlackColor();
                    ((RBTNode<K,T>)x.getP().getP()).setRedColor();
                    x = (RBTNode<K,T>)x.getP().getP();
                }else{
                    if(x==x.getP().getLeft()){ //Caso 2
                        x = (RBTNode<K,T>)x.getP();
                        rightRotate(x);
                    }
                    //Caso 3
                    ((RBTNode<K,T>)x.getP()).setBlackColor();
                    ((RBTNode<K,T>)x.getP().getP()).setRedColor();
                    leftRotate((RBTNode<K,T>)x.getP().getP());
                }
            }
        }
        
        ((RBTNode<K,T>)root).setBlackColor();
        
        return agrego;
    }
    
    
    public RBTNode<K,T> getNil() {
        return nil;
    }
    
    public boolean isNil(RBTNode<K,T> node) {
        return node==nil;
    }

    public void leftRotate(RBTNode<K,T> x){
        if(!isNil(x.getRight())){
            ABBNodo<K,T> y = x.getRight();
            x.setRight(y.getLeft());
            if(y.getLeft()!=nil){
                y.getLeft().setP(x);
            }
            y.setP(x.getP());

            if(x.getP()==nil){
                root = y;
            }else if(x==x.getP().getLeft()){
                x.getP().setLeft(y);
            }else{
                x.getP().setRight(y);            
            }

            y.setLeft(x);
            x.setP(y);
        }
    }

    public void rightRotate(RBTNode<K,T> x){
        if(!isNil(x.getLeft())){
            ABBNodo<K,T> y = x.getLeft();
            x.setLeft(y.getRight());
            if(!isNil(y.getRight())){
                y.getRight().setP(x);
            }
            y.setP(x.getP());

            if(x.getP()==nil){
                root = y;
            }else if(x==x.getP().getRight()){
                x.getP().setRight(y);
            }else{
                x.getP().setLeft(y);            
            }

            y.setRight(x);
            x.setP(y);
        }
    }
}
