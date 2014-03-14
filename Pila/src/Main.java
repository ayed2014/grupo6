/**
 * Created by federuiz on 3/14/14.
 */
public class Main {
    public static void main(String[] args){
        Pila mipila1 = new Pila();
        mipila1.apilar(4);
        mipila1.apilar(7);
        mipila1.apilar(2);
        mipila1.apilar(7);
        mipila1.apilar(3);

        for(int i =0; i<5; i++){
            System.out.println(mipila1.verTope());
            mipila1.desapilar();
        }

    Pila mipila = new Pila();
    mipila.apilar(6);
    mipila.apilar(5);
    mipila.apilar(6);
    mipila.apilar(8);
    mipila.apilar(9);
    Pila mipila2 = new Pila();

        for(int i = 0; i<5; i++){
            Object elemen2 = (Integer) mipila.verTope()*2;
            mipila2.apilar(elemen2);
            mipila.desapilar();

        }
        for(int a = 0; a <5; a++){
            System.out.println(mipila2.verTope());
            mipila2.desapilar();

        }





        Pila pila1 = new Pila();
        int b = (int) (Math.random()*10);
        int c = (int) (Math.random()*10);
        int d = (int) (Math.random()*10);
        int e = (int) (Math.random()*10);
        int f = (int) (Math.random()*10);

        pila1.apilar(b);
        pila1.apilar(c);
        pila1.apilar(d);
        pila1.apilar(e);
        pila1.apilar(f);


        Pila pila2 = new Pila();
        int h = (int) (Math.random()*10);
        int r = (int) (Math.random()*10);
        int j = (int) (Math.random()*10);
        int k = (int) (Math.random()*10);
        int l = (int) (Math.random()*10);

        pila2.apilar(h);
        pila2.apilar(r);
        pila2.apilar(j);
        pila2.apilar(k);
        pila2.apilar(l);
        Pila pila3 = new Pila();
        Pila pila4 = new Pila();

        for(int i = 0; i<5; i++){
            pila3.apilar(pila1.verTope());
            pila1.desapilar();
            pila3.apilar(pila2.verTope());
            pila2.desapilar();
            pila4.apilar(pila3.verTope());
            pila3.desapilar();
            pila4.apilar(pila3.verTope());

        }
        for(int i = 0; i<10; i++){
            System.out.println(pila4.verTope());
            pila4.desapilar();
        }




        Pila mipila3 = new Pila();
        mipila3.apilar(6);
        mipila3.apilar(5);
        mipila3.apilar(6);
        mipila3.apilar(8);
        mipila3.apilar(9);
        mipila3.apilar(6);
        mipila3.apilar(5);
        mipila3.apilar(6);
        mipila3.apilar(8);
        mipila3.apilar(9);
        mipila3.apilar(6);
        mipila3.apilar(5);
        mipila3.apilar(6);
        mipila3.apilar(8);
        mipila3.apilar(9);
        System.out.println("1. Apilar \n 2. Desapilar \n 3. Modificar  \n 4. Mostrar");
        int opcion = Scanner.getInt("Ingrese la opcion: ");
        if(opcion == 1){
            int numero = Scanner.getInt("Ingrese numero a apilar: ");
            mipila3.apilar(numero);
        }
        if(opcion == 2){
            mipila3.desapilar();
        }
        if(opcion == 3){
            mipila3.desapilar();
            int numero = Scanner.getInt("Ingrese numero a modificar: ");
            mipila3.apilar(numero);
        }
        if(opcion == 4){
            mipila3.verTope();
        }
        else{
            System.exit(0);
        }
}
}