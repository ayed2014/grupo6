import javax.swing.text.html.ObjectView;

/**
 * Created by Luciano on 09/04/14.
 */
public class ArBinBus {
    private NodoDoble root;
    public ArBinBus(){
        root = null;
    }
    public void insert(Comparable x){
        root = insert(root, x);
    }
    public void delete(Comparable x){
        try{
            root = delete(root, x);
        }catch (NotFoundException e){
            e.printStackTrace();
        }
    }
    public Object getMin(){
        return getMin(root).elem;
    }
    private NodoDoble getMin(NodoDoble t){
        if (t.left == null){
            return t;
        }else{
            return getMin(t.left);
        }
    }
    private NodoDoble delete(NodoDoble t, Comparable x) throws NotFoundException{
        if (x.compareTo(t.elem) <0){
            t.left = delete(t.left, x);
        }else if(x.compareTo(t.elem) >0){
            t.right = delete(t.right, x);
        }else{
            if (t.left != null && t.right != null){
                t.elem = getMin(t.right).elem;
               // t.right = deleteMin(t.right);
            }else if(t.left != null){
                t = t.left;
            }else if (t.right!=null){
                t = t.right;
            }else{
                throw new NotFoundException("Elemento no encontrado");
            }
        }
        return t;
    }
    private NodoDoble insert(NodoDoble t, Comparable x){
        if (t==null){
            t = new NodoDoble();
            t.elem = x;
        }else if(x.compareTo(t.elem)<0){
            t.left = insert(t.left, x);
        }else{
            t.right = insert(t.right, x);
        }
        return t;
    }
}
