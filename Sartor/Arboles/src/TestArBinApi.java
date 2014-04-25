/**
 * Created by Luciano on 16/04/14.
 */
public class TestArBinApi {
    public static void main(String[] args) {
        ArBinApi a = new ArBinApi();
        ArBin arbol = new ArBin(3,new ArBin(6),new ArBin(5));
        ArBin arbol2 = new ArBin(1,arbol,new ArBin(7,new ArBin(8),new ArBin(9)));
        arbol2 = a.loadTree();
    //    System.out.println(a.sum3(arbol));
       if (arbol2==null){
           System.out.println("0");
       }else{
           a.levelOrder(arbol2);
       }
    }
}
