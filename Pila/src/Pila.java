/**
 * Created by federuiz on 3/14/14.
 */
public class Pila {
    Object array[];
    int index = 0;
    Pila(){
    array = new Object[20];
    }
    public Object[] apilar(Object e){
        if(index == array.length){
            Object array2[] = new Object[array.length + 10];
            for(int i = 0; i<array.length; i++){
                array2[i] = array[i];
            }
            array2[index] = e;
            index ++;
            return array2;
        }
        else{
        array[index] = e;
        index++;
        return array;
        }
    }

    public void desapilar(){
        index--;

    }
    public void vaciar(){
        index = 0;
    }
    public Object verTope(){
        return array[index-1];
    }
    public boolean esVacio(){
        if (index==0){
            return true;
        }
        return false;
    }


}
