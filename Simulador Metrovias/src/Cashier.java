/**
 * Created by federuiz on 4/7/14.
 */
public class Cashier {
    private QueueD queue;
    private double money;
    private int waitTime;
    private int numPeople;
    private double idletime;

    public void setQueue(QueueD queue) {
        this.queue = queue;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setIdletime(double idletime) {
        this.idletime = idletime;
    }

    public double getIdletime() {

        return idletime;
    }

    public QueueD getQueue() {
        return queue;
    }

    public double getMoney() {
        return money;
    }

    public int getQuantity(){
        return queue.length();
    }


    public Cashier(){
        queue = new QueueD();
    }
    public void addPeople(int time){
            Person x = new Person(time);
            queue.enqueue(x);

    }

    public int getWaitTime() {
        return waitTime;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public void collect(int time){
        if(queue.isEmpty()){
            idletime = idletime+10;
        }
        else{
            Person x = (Person)queue.dequeue();
            int waitTime1 = time - x.getTimeOfEntrance();

            money = money + 0.70;
            waitTime = waitTime+waitTime1;
            numPeople++;

        }
    }
}
