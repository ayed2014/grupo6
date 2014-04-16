/**
 * Created by federuiz on 4/7/14.
 */
public class Station {
    int numCashiers;
    StaticList1 station;
    int time;
    public Station(int cashiers){
        time = 0;
        numCashiers = cashiers;
        station = new StaticList1();
        for(int i = 0; i<numCashiers; i++){
            station.insertAfter(new Cashier());
        }
    }
    public void simulate(){
        while(time<57570){
            for(int i = 0; i<5; i++){
                int random = (int )(Math.random() * (numCashiers));
                station.goTo(random);
                Cashier cashier1 = (Cashier)station.seeActual();
                if(cashier1!=null){
                cashier1.addPeople(time);
                }
            }
            for(int i =0; i<numCashiers; i++){
                station.goTo(i);
                int probability = (int)(Math.random()*100);
                Cashier cashier2 = (Cashier)station.seeActual();
                if(probability<=30){

                    cashier2.collect(time);
                }
                else{
                    cashier2.setIdletime(cashier2.getIdletime()+10);
                }
            }
            time = time+10;
        }

            for(int i = 0; i<numCashiers; i++){
                station.goTo(i);
                Cashier cashier2 = (Cashier)station.seeActual();
                for(int j = 0; j<cashier2.getQuantity(); j++){
                    cashier2.collect(time);
                }
            }


    }
    public void info(){
        for(int i =1; i<=numCashiers; i++){
            station.goTo(i-1);
            Cashier cashier2 = (Cashier)station.seeActual();
            int waitingTime = (cashier2.getWaitTime()/cashier2.getNumPeople())/60;
            int money = (int)cashier2.getMoney();
            int idle = (int)cashier2.getIdletime()/60;
            System.out.println("Datos de Ventanilla "+i+": ");
            System.out.println("Tiempo medio de espera: "+waitingTime+" minutos.");
            System.out.println("Dinero recolectado: " + money + " pesos.");
            System.out.println("Tiempo ocioso: "+idle+" minutos.");
            System.out.println("-------");
        }

    }

}
