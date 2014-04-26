/**
 * Created by Luciano on 26/04/14.
 */
public class Lampara implements Comparable {
    String code;
    int watts;
    String type;
    int quantity;
    public Lampara(String code, int watts, String type){
        if (code.length()!=5){
            System.out.println("The code must be of 5 chars");
            return;
        }
        if (type.length()>10){
            System.out.println("The type must be of less than 10 chars");
            return;
        }
        this.code = code;
        this.type = type;
        this.watts = watts;
    }
    public Lampara(String code){
        if (code.length()!=5){
            System.out.println("The code must be of 5 chars");
            return;
        }else{
            this.code = code;
        }
    }

    @Override
    public int compareTo(Object o) {
        Lampara l = (Lampara) o;
        String s = l.code;
        if (s.compareTo(code)<0){
            return -1;
        }else if (s.compareTo(code)>0){
            return 1;
        }else{
            return 0;
        }
    }
}
