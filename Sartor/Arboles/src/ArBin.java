import java.io.Serializable;

/**
 * Created by Luciano on 26/03/14.
 */
public class ArBin implements Serializable{
    private NodoDoble root;
    public ArBin(){
        root = null;
    }
    public ArBin(Object x){
        root = new NodoDoble();
        root.elem = x;
        root.left = null;
        root.right = null;
    }
    public ArBin(Object x, ArBin t1, ArBin t2){
        root = new NodoDoble();
        root.elem = x;
        root.left = t1.root;
        root.right = t2.root;
    }
     public boolean isEmpty(){
         return root==null;
     }
    public Object isRoot(){
        return root.elem;
    }
    public ArBin getLeft(){
        ArBin t = new ArBin();
        t.root = root.left;
        return t;
    }
    public ArBin getRight(){
        ArBin t = new ArBin();
        t.root = root.right;
        return t;
    }


}
