/**
 * Created by federuiz on 4/7/14.
 */
public class Person {
    private int timeOfEntrance;

    public int getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public int getTimeOfEntrance() {
        return timeOfEntrance;
    }

    private int timeOfDeparture;

    public Person(int time1){
        this.timeOfEntrance = time1;
    }

    public int timeofWait(int waitingTime){
        timeOfDeparture = timeOfEntrance+waitingTime;
        return timeOfDeparture;
    }
}
