/**
 * Created by federuiz on 3/28/14.
 */
public class QueueE implements Queue{
    Object array[];
    int quantity;
    int front;
    int end;
    int i = 0;
    int length = 10;
    public QueueE(){
        array = new Object[10];
        quantity = 0;
        front = 0;
        end = 0;
    }

    @Override
    public void enqueue(Object x) {
        if(quantity==length){
            Object array2[] = new Object[length+10];
            if(front<end){
            for(int a = front; a<end; a++){

                array2[i] = array[a];
                i++;
            }
            }
                if(front>end){
            for(int j = front; j<array.length; j++){
                int b = 0;
                array2[b] = array[j];
                b++;
            }
                    for(int n = 0; n<end; n++){
                        int s = 0;
                        array2[s] = array[n];
                        s++;
                    }
                }
            array = array2;
            front = 0;
            end = quantity;
            length = length+10;
        }
        array[end] = x;
        quantity++;
        if(end == array.length){
            end = 0;
        }
        else end++;
    }

    @Override
    public Object dequeue() {
        Object b = array[front];
        array[front] = null;
        quantity--;
        if(front == array.length){
            front = 0;
        }
        else front ++;
        return b;
    }

    @Override
    public boolean isEmpty() {
        if(quantity == 0){
            return true;
        }
        else return false;
    }

    @Override
    public int length() {
        return quantity;
    }


    public void print(){
        for(int a=0; a<quantity; a++){
            System.out.println(array[a]);
        }
    }

}
