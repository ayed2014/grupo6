import com.sun.org.apache.regexp.internal.recompile;

import java.util.ArrayList;

/**
 * Created by Luciano on 26/04/14.
 */
public class Empresa {
    ArrayList<Lampara> lamparas = new ArrayList<Lampara>();;
    ArBinBus lamps;
    int ing = 0;
    int egre = 0;
    public Empresa(ArrayList<Lampara> lamparas){
        this.lamparas = lamparas;
        lamps = new ArBinBus();
        transfer();
    }
    public void transfer(){
        for (int i = 0; i < lamparas.size(); i++) {
            lamps.insert(lamparas.get(i));
        }
    }
    public void add(Lampara lamp){
        lamps.insert(lamp);
        lamparas.add(lamp);
        ing++;
    }
    public Lampara getLamp(String code){
        Lampara lamp = new Lampara(code);
        Lampara result = lamp;
        try{
            result = (Lampara) lamps.search(lamp);
            lamps.delete(lamp);
            lamparas.remove(lamp);
            egre++;

        } catch (NotFoundException n){
            System.out.println(n.getMessage());
        }
        return result;
    }
    public void modify(Lampara lamparaParaInsertar, String codeToModify){
        Lampara lamp = new Lampara(codeToModify);
        boolean res;
        try{
            res = lamps.exists(lamp);
            if (res){
                lamps.delete(lamp);
                lamps.insert(lamparaParaInsertar);
            }
        }catch (NotFoundException n){
            System.out.println(n.getMessage());
        }
    }
    public void inform(){
        int quantity = 0;
        for (Lampara l : lamparas){
            quantity++;
        }
        System.out.println("La cantidad de lamparas es "+quantity);
        System.out.println("Se han realizado "+ing+" ingresos de lamparas.");
        System.out.println("Se han realizado "+egre+" egresos de lamparas.");
    }
}
