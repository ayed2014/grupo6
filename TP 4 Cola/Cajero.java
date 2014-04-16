/**
 * Created by Luciano on 06/04/14.
 */
public class Cajero {
    boolean working = false;
    int time;
    int hora;
    int tiempoDeAtencion;
    public Cajero(int t){
        time = t;
    }
    public void attend(int tiempo){
        hora = tiempo;
        tiempoDeAtencion =(int) (Math.random()*time)+1;
        working = true;
    }
    public void attended(int t){
        int total = hora+tiempoDeAtencion;
        if (t>=total){
            working = false;
            hora = 0;
        }
    }
    public boolean isWorking(){
        return working;
    }

}
