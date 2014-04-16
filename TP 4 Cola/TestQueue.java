/**
 * Created by Luciano on 28/03/14.
 */
public class TestQueue {
    public static void main(String[] args) {
        Queue q = new QueueD();
        for (int i = 0; i < 5; i++) {
            q.enqueue(i);
        }
        System.out.println(q.dequeue());
        System.out.println("Length: "+q.length());
        q.enqueue(2);
        System.out.println("Length: " + q.length());
        q.enqueue(22);
        while(q.isEmpty()==false){
        System.out.println(q.dequeue());
        }
    }
}
