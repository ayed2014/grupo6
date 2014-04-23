/**
 * Created by Luciano on 16/04/14.
 */
public class TestArBinApi {
    public static void main(String[] args) {
        ArBinApi a = new ArBinApi();
        ArBin arbol = new ArBin(3,new ArBin(6),new ArBin(8));
        System.out.println(a.sum3(arbol));
    }
}
