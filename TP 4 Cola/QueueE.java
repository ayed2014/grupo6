/**
 * Created by Luciano on 28/03/14.
 */
public class QueueE implements Queue {
    Object[]array;
    private int front;
    private int back;
    private int length;
    QueueE(){
        array = new Object[5];
        front = 0;
        back = 0;
    }
    public void enqueue(Object x){
        array[back] = x;
        length++;
        back = incrementar(back);
    }
    public Object dequeue(){
        Object result;
        if(array[front]!=null){
            result = array[front];
        }else{
            return null;
        }
        array[front]=null;
        length--;
        front = incrementar(front);
        return result;
    }
    public boolean isEmpty(){
        if (length==0){
            return true;
        }else{
            return false;
        }
    }
    private int incrementar(int i){
        if (length == array.length){
            resize();

        }
        if (i == (array.length-1)){
            i = 0;
        }else{
            i++;
        }
        return i;
    }

    private void resize() {
        Object[]temp = new Object[array.length*2];
        int a = 0;
        if(back==front){
            if (back!=0){
                back--;
            }else{
                back=(array.length)-1;
            }
        }
        if (front>back){
            for(int i = front;i<array.length;i++){
                temp[a] = array[front];
                a++;
            }
        }
        front =0;
        while(front<=back){
            temp[a]= array[front];
            a++;
            front ++;
        }
        front = 0;
        back = a;
        array = temp;
    }

    public int length(){
        return length;
    }

}
