import org.omg.DynamicAny._DynArrayStub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by Luciano on 18/03/14.
 */
public class Lexicografico {
    private Pila parentesisabierto = new Pila();
    private Pila llaveabierta = new Pila();
    private Pila corcheteabierto = new Pila();
    private Pila parentesiscerrado = new Pila();
    private Pila llavecerrada = new Pila();
    private Pila corchetecerrado = new Pila();
    public Lexicografico(){

    }
    public void analizarTexto(){
        boolean a = chequearTexto();
        if (a){
            System.out.println("El texto esta correcto");
        }else{
            System.out.println("El texto tiene errores");
        }
    }
    private boolean chequearTexto(){
        boolean perfecto = false;
        try{
            File f = new File("Texto.txt");
            FileReader fReader = new FileReader(f);
            BufferedReader reader = new BufferedReader(fReader);
            String line = null;
            while((line = reader.readLine())!=null){
                for(char c : line.toCharArray()){
                    switch(c){
                        case '(': parentesisabierto.apilar(c);
                        break;
                        case '{': llaveabierta.apilar(c);
                        break;
                        case '[': corcheteabierto.apilar(c);
                        break;
                        case ')': parentesiscerrado.apilar(c);
                        break;
                        case '}': llavecerrada.apilar(c);
                        break;
                        case ']': corchetecerrado.apilar(c);
                        break;
                        default:
                    }
                }
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        int total =0;
        while (parentesisabierto.esVacio()==false){
             total++;
            parentesisabierto.desapilar();
        }
        while (parentesiscerrado.esVacio()==false){
            total--;
            parentesiscerrado.desapilar();
        }
        while (llaveabierta.esVacio()==false){
            total++;
            llaveabierta.desapilar();
        }
        while (llavecerrada.esVacio()==false){
            total--;
            llavecerrada.desapilar();
        }
        while (corcheteabierto.esVacio()== false){
            total++;
            corcheteabierto.desapilar();
        }
        while (corchetecerrado.esVacio()==false){
            total--;
            corchetecerrado.desapilar();
        }
        if (total ==0){
            perfecto = true;
        }
        return perfecto;
    }
}
