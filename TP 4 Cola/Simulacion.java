/**
 * Created by Luciano on 06/04/14.
 */
public class Simulacion {
    Cajero []cajeros;
    Queue cola;
    QueueD[]colas;
    int atendidos;
    public Simulacion(){
        cajeros = new Cajero[3];
        int max = 3;
        for (int i = 0; i < cajeros.length; i++) {
            cajeros[i] = new Cajero(max);
            max++;
        }
    }
    public void runA(){
        setCola();
        bancoA();
    }
    public void runB(){
        setColas();
        bancoB();
    }
    public void setCola(){
        cola = new QueueD();
        int clientes = 0;
        while(clientes<15){
            cola.enqueue(clientes);
            clientes++;
        }
    }
    public void bancoA(){
        int trabajo = 0;
        int largoCola = 0;
        int caja1 = 0;
        int caja2 = 0;
        int caja3 = 0;
        float tiempolibre = 0;
        while(trabajo<600){
            if (largoCola<cola.length()){
                largoCola = cola.length();
            }
            cola.enqueue(trabajo);
            if (trabajo!=0){
                for (int i = 0; i < cajeros.length; i++) {
                    cajeros[i].attended(trabajo);
                }
            }

            int cajero = setCajero();
            while (cajero !=0){
                if (cola.isEmpty()==false){
                    cajeros[cajero-1].attend(trabajo);
                    if (cajero==1){
                        caja1++;
                    }
                    if (cajero==2){
                        caja2++;
                    }
                    if (cajero==3){
                        caja3++;
                    }
                    atendidos++;
                    cola.dequeue();
                    cajero = setCajero();
                }else{
                    tiempolibre++;
                    cajero=0;
                }
            }
            if (trabajo == 599){
                while (cola.isEmpty()==false){
                   cajero = setCajero();
                    while (cajero !=0){
                        if (cola.isEmpty()==false){
                            cajeros[cajero-1].attend(trabajo);
                            if (cajero==1){
                                caja1++;
                            }
                            if (cajero==2){
                                caja2++;
                            }
                            if (cajero==3){
                                caja3++;
                            }
                            atendidos++;
                            cola.dequeue();
                        }
                        cajero = setCajero();
                    }

                    if (cajero == 0){
                        for (int i = 0; i < cajeros.length; i++) {
                            cajeros[i].attended(trabajo);
                        }
                    }
                    trabajo++;
                }
            }
            trabajo++;
        }
        System.out.println("En este dia se atendieron a "+atendidos+" personas.");
        System.out.println("El largo maximo de la cola fue de "+largoCola+" personas.");
        System.out.println("El cajero 1 atendio a "+caja1+" personas; el 2 a "+caja2+" personas y el 3 a "+caja3);
        System.out.println("La cola estuvo vacia durante "+(tiempolibre/2)+" minutos");
    }
    private void setColas(){
        colas = new QueueD[3];
        for (int i = 0; i < colas.length; i++) {
            colas[i] = new QueueD();
        }
        int clientes = 0;
        while(clientes<15){
             int free = selectCola();
            colas[free-1].enqueue(clientes);
             clientes++;
        }
    }
    private int selectCola(){
        int rnd;
        int max;
        int min = 1;
        int []largo = new int[3];
        for (int i = 0; i < colas.length; i++) {
             largo[i] = colas[i].length();
        }
        if (largo[0]==largo[1]){
            if (largo[0]==largo[2]){
                max = 3;
            }else{
                if (largo[2]<largo[0]){
                return 3;
                }else{
                max = 2;
                }
            }
                rnd = (int)(Math.random()*max)+min;
            return rnd;
        }else{
            if (largo[0]==largo[2]){
                if (largo[1]<largo[0]){
                    return 2;
                }else{
                    rnd = (int)(Math.random()*3)+1;
                while(rnd==2){
                    rnd = (int)(Math.random()*3)+1;
                }
                    return rnd;
                }
            }else{
                if (largo[1]==largo[2]){
                    if (largo[0]<largo[1]){
                        return 1;
                    }else{
                    rnd = (int)(Math.random()*2)+2;
                    return rnd;
                    }
                }else{
                    if(largo[0]<largo[1]){
                        if (largo[0]<largo[2]){
                            return 1;
                        }else{
                            return 3;
                        }
                    }else{
                        if (largo[1]<largo[2]){
                            return 2;
                        }else{
                            return 3;
                        }
                    }
                }
            }
        }
    }
    private void bancoB(){
        int cliente = 0;
        int []largoColas = new int[3];
        int []cajas = new int[3];
        while (cliente<600){
            for (int i = 0; i < largoColas.length; i++) {
                if (largoColas[i]<colas[i].length()){
                    largoColas[i] = colas[i].length();
                }
            }
            int q = selectCola();
            colas[q-1].enqueue(cliente);
            if (cliente!=0){
                for (int i = 0; i < cajeros.length; i++) {
                    cajeros[i].attended(cliente);
                }
            }
            int cajero = setCajero();
            while (cajero !=0){
                if (colas[cajero-1].isEmpty()==false){
                    cajeros[cajero-1].attend(cliente);
                    if (cajero==1){
                        cajas[0]++;
                    }
                    if (cajero==2){
                        cajas[1]++;
                    }
                    if (cajero==3){
                        cajas[2]++;
                    }
                    colas[cajero-1].dequeue();
                    cajero = setCajero();
                }else{
                    cajero=0;
                }
            }
            if (cliente == 599){
                for (int i = 0; i < colas.length; i++) {
                     while(colas[i].isEmpty()==false){
                         if (cajeros[i].isWorking()){
                             cajeros[i].attended(cliente);
                         }else{
                             cajeros[i].attend(cliente);
                             colas[i].dequeue();
                             cajas[i]++;
                         }
                         cliente++;
                     }
                     cliente = 599;
                }
        }
            cliente++;
    }
        for (int i = 0; i < largoColas.length; i++) {
            System.out.println("El largo maximo de la cola "+(i+1)+" fue de "+largoColas[i]+" personas.");
        }
        System.out.println("El cajero 1 atendio a "+cajas[0]+" personas; el 2 a "+cajas[1]+" personas y el 3 a "+cajas[2]);
        }
    private int setCajero(){
        int free = 0;
        for (int i = 0; i < cajeros.length; i++) {
            if (cajeros[i].isWorking()==false){
                 free++;
            }
        }
        if (free==1){
            if (cajeros[0].isWorking()==false){
                return 1;
            }
            if (cajeros[1].isWorking()==false){
                return 2;
            }
            if (cajeros[2].isWorking()==false){
                return 3;
            }
        }
        if (free==2){
            int rnd = (int)(Math.random()*3)+1;
            while(cajeros[rnd-1].isWorking()){
                rnd = (int)(Math.random()*3)+1;
            }
            return rnd;
        }
        if (free==3){
            int rnd = (int)(Math.random()*3)+1;
            return rnd;
        }
        return free;
    }
}
