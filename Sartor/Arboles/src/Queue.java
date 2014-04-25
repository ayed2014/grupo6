/**
 * Created by Luciano on 28/03/14.
 */
public interface Queue {
    void enqueue(Object x);
    Object dequeue();
    boolean isEmpty();
    int length();

}
