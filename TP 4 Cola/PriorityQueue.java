/**
 * Created by Luciano on 08/04/14.
 */
public class PriorityQueue{
    QueueD[] colas;
    int length;
    public PriorityQueue(int priorities){
        colas = new QueueD[priorities];
        for (int i = 0; i < colas.length; i++) {
            colas[i] = new QueueD();
        }
    }
    public void enqueue(Object o, int prio){
        colas[prio-1].enqueue(o);
        length++;
    }
    public Object dequeue(){
        for (int i = 0; i < colas.length; i++) {
            if (!colas[i].isEmpty()){
                length--;
                return colas[i].dequeue();
            }
        }
        return null;
    }
    public boolean isEmpty(){
        boolean result = true;
        for (int i = 0; i < colas.length; i++) {
            if (!colas[i].isEmpty()){
                result = false;
            }
        }
        return result;
    }
    public int length(){
        return length;
    }
}
