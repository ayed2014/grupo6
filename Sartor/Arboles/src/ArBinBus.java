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
    public Object getMax(){
        return getMax(root).elem;
    }
    public Object search(Comparable x) throws NotFoundException{
        Lampara l = (Lampara) x;
        if (l.code==null){
            throw new NotFoundException("Element is not in the tree");
        }else{
            NodoDoble n = search(root,x);
            if (n==null){
                throw new NotFoundException("Element is not in the tree");
            }else{
                return n.elem;
            }
        }
    }
    public boolean exists(Comparable x) throws NotFoundException{
        boolean b = exists(root,x);
        if (b){
           return exists(root,x);
        }else{
            throw new NotFoundException("The element does not exists");
        }
    }
    public boolean isEmpty(){
        return (root == null);
    }
    public Object getRoot(){
        if (root==null){
            System.out.println("Tree does not exists");
            return null;
        }else {
            return root.elem;
        }
    }
    public ArBinBus getLeft(){
        if (root == null){
            System.out.println("The tree does not exists");
            return null;
        }else{
            ArBinBus t = new ArBinBus();
            t.root = root.left;
            return t;
        }
    }
    public ArBinBus getRight(){
        if (root == null){
            System.out.println("The tree does not exists");
            return null;
        }else{
            ArBinBus t = new ArBinBus();
            t.root = root.right;
            return t;
        }
    }
    private NodoDoble getMax(NodoDoble t){
        if (t.right == null ){
            return t;
        }else{
            return getMax(t.right );
        }
    }
    private NodoDoble getMin(NodoDoble t){
        if (t.left == null){
            return t;
        }else{
            return getMin(t.left);
        }
    }
    private NodoDoble search(NodoDoble t,Comparable x){
        if (x.compareTo(t.elem)==0){
            return t;
        }else if(x.compareTo(t.elem)<0){
            if (t.left!=null){
            return search(t.left,x);
            }else{
                return null;
            }
        }else{
            if (t.right!=null){
            return search(t.right,x);
            }else{
                return null;
            }
        }
    }
    private boolean exists(NodoDoble t, Comparable x) {
        if (t == null ){
            return false ;
        }if (x.compareTo(t.elem ) == 0){
            return true ;
        }else if (x.compareTo( t.elem )< 0){
            return exists(t.left, x);
        }else{             return exists(t.right, x);
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
                t.right = deleteMin(t.right);
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
    private NodoDoble deleteMin(NodoDoble t){
        if (t.left != null){
            t.left = deleteMin(t.left);
        }else{
                t=t.right;
        }
        return t;
        }
    }
