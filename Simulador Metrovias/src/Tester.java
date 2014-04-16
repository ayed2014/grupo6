
/**
 * Created by federuiz on 4/9/14.
 */
public class Tester {
    public static void main(String[] args) {
        int a = Scanner.getInt("Ingrese la cantidad de ventanillas: ");
        Station station = new Station(a);
        station.simulate();
        station.info();
        funcion1(2);
    }
    public static int funcion1( int n ){
        int sum = 0;

        for (int i = 0; i <= n; i++){
            for (int j = i; j <= n; j++){
                sum++;
            }
    }

        System.out.println(sum);
        return sum;
    }
}
