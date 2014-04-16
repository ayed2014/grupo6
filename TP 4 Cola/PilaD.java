/**
 * Created by Luciano on 28/03/14.
 */
public class PilaD implements Pila {
       Nodo n1;
       public void push(Object e){
           if (n1==null){
               n1 = new Nodo(e);
               n1.next = null;
           }else{
               Nodo n2 = new Nodo(e);
               n2.next = n1;
               n1 = n2;
           }
       }
       public void pop(){
           n1 = n1.next;
       }
        public void clearOut(){
            n1 = null;
        }
    public Object viewLast(){
        return n1.dato;
    }
    public boolean isEmpty(){
        if (n1 == null){
            return true;
        }else{
            return false;
        }
    }
}
