/**
 * Created by federuiz on 4/4/14.
 */
public interface List {
    public Object seeActual();
    public void empty();
    public boolean isEmpty();
    public void insertBefore(Object a);
    public void insertAfter(Object a);
    public void next();
    public void before();
    public void goTo(int x);
    public void delete();
}
