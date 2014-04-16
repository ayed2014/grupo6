/**
 * Created by Luciano on 08/04/14.
 */
public class TestPriority {
    static PriorityQueue cola;
    public static void main(String[] args) {
        System.out.println("Priority Queue test: \n");
        init();
        start();
    }
    private static int init(){
        int prio = Scanner.getInt("Enter amount of priorities: ");
        while(prio<=0){
            System.out.println("enter more than 0");
            prio = init();
        }
        cola = new PriorityQueue(prio);
        return prio;
    }
    private static int start(){
        System.out.println("Choose action: \n1.Enqueue 2.Dequeue 3.IsEmpty 4.Length 5.Exit");
        int choice = Scanner.getInt("Action: ");
        while (choice!=5){
            if (choice == 1){
            String s = Scanner.getString("Enter a string to enqueue: ");
            int pr = Scanner.getInt("Enter the priority number: ");
            cola.enqueue(s,pr);
            System.out.println("The string was added");
            }
            if (choice==2){
                String result = (String)cola.dequeue();
                if (result!=null){
                    System.out.println("The string "+result+" was removed from the queue.");
                }else{
                    System.out.println("There is no element in the queue");
                }
            }
            if (choice == 3){
                System.out.println(cola.isEmpty());
            }
            if (choice == 4){
                System.out.println("length: "+cola.length());
            }
            if ((choice<=0)||(choice>5)){
                System.out.println("please enter 1,2,3,4 or 5.");
                choice = start();
            }
            choice = start();
        }
       return choice;
    }
}
