/**
 * Created by federuiz on 3/28/14.
 */
public interface Queue {
    public void enqueue(Object x);
    public Object dequeue();
    public boolean isEmpty();
    public int length();

}
