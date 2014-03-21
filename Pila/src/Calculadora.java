import javax.net.ssl.SSLContext;
import java.util.ArrayList;

/**
 * Created by federuiz on 3/17/14.
 */
public class Calculadora {
    private char[] numarray;
    private int length;
    private int [] arrayInt;
    private Pila pila;

    public Calculadora(char[] numarray, int length){
        this.length = length;
        this.numarray = numarray;
        arrayInt = new int[length+1];
        pila = new Pila();
    }

    public void Calculate(){

        for(int i = 0; i<length; i++){
            arrayInt[i] = numarray[i]-'0';

        }
        for(int i= 0; i<arrayInt.length; i++){
            if(arrayInt[i] == -6){
                arrayInt[i-1] = arrayInt[i-1]*arrayInt[i+1];
                for(int a = i; a<arrayInt.length-2; a++){
                    arrayInt[a]=arrayInt[a+2];
                }
                i--;
                length = length -2;
            }
            if(arrayInt[i] == -1){
                arrayInt[i-1] = arrayInt[i-1]/arrayInt[i+1];
                for(int a = i; a<length; a++){
                    arrayInt[a]=arrayInt[a+2];
                }
                length = length - 2;
            }
        }
        for(int i = 0; i<length; i++){
            if(arrayInt[i] == -3){

                arrayInt[i-1] = arrayInt[i-1]-arrayInt[i+1];
                    length = length -2;
                for(int a = i; a<length; a++){
                    arrayInt[a]=arrayInt[a+2];
                }
                i--;

            }
            if(arrayInt[i] == -5){
                arrayInt[i-1] = arrayInt[i-1]+arrayInt[i+1];
                length = length -2;
                for(int a = i; a<length; a++){
                    arrayInt[a]=arrayInt[a+2];

                }
                i--;
            }

        }
        for(int i = 0; i<length; i++){
            System.out.println(arrayInt[i]);

        }


    }
}
