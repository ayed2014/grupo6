/**
 * Created by federuiz on 4/4/14.
 */
public class StaticList1 implements List {
    Object array[];
    int indexWindow;
    int quantity = 0;
    public StaticList1(){
        array = new Object[10];
        indexWindow = 0;
    }

    @Override
    public Object seeActual() {
        return array[indexWindow];
    }

    @Override
    public void empty() {
        for(int i = 0; i<quantity+1; i++){
            array[i] = null;
            quantity = 0;
            indexWindow = 0;
        }

    }

    @Override
    public boolean isEmpty() {
        if(quantity == 0){
            return true;
        }
        else return false;
    }

    @Override
    public void insertBefore(Object a) {

        if(quantity == array.length){
            Object array2[] = new Object[array.length + 10];
            for(int i = 0; i<array.length; i++){
                array2[i] = array[i];
            }
            array = array2;
        }
        for(int i = quantity; i>=indexWindow; i--){
            array[i+1] = array[i];

        }
            array[indexWindow] = a;
            quantity++;


    }

    @Override
    public void insertAfter(Object a) {

        if(quantity == array.length){
            Object array2[] = new Object[array.length + 10];
            for(int i = 0; i<array.length; i++){
                array2[i] = array[i];
            }
            array = array2;
        }
        for(int i = quantity; i>indexWindow; i--){
            array[i+1] = array[i];

        }

        array[indexWindow] = a;
        indexWindow++;
        quantity++;


    }

    @Override
    public void next() {
        if(array[indexWindow+1] != null){
            indexWindow++;
        }
    }

    @Override
    public void before() {
        if(array[indexWindow-1] != null){
            indexWindow--;
        }

    }

    @Override
    public void goTo(int x) {
        indexWindow = x;

    }

    @Override
    public void delete() {
        for(int i = indexWindow; i<quantity; i++){
            array[i] = array[i+1];

        }
        quantity--;
        if(array[indexWindow] == null){
            indexWindow--;
        }

    }
    public void print(){
        for(int i =0; i<quantity; i++){
            System.out.println(array[i]);
        }
        System.out.println("Window is in index: "+indexWindow);
        System.out.println("Quantity: "+quantity);
    }
}
