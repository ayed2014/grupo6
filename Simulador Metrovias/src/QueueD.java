/**
 * Created by federuiz on 28/03/14.
 */

public class QueueD implements Queue {
    Nodo first;
    Nodo last;
    private int length;
    public QueueD(){
        first = null;
        last = null;
    }
    public void enqueue(Object x){
        if (first == null){
        first = new Nodo(x);
        last = first;
        }else{
            Nodo n2 = new Nodo(x);
            n2.next = null;
            last.next = n2;
            last = last.next;
        }
        length++;
    }
    public Object dequeue(){
        Nodo result = first;
        first = first.next;
        length--;
        return result.dato;
    }
    public boolean isEmpty(){
        if (first ==null){
            return true;
        }else{
            return false;
        }
    }
    public int length(){
        return length;
    }


}
