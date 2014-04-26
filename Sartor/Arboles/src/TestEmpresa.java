import java.util.ArrayList;

/**
 * Created by Luciano on 26/04/14.
 */
public class TestEmpresa {
    public static void main(String[] args) {
        ArrayList<Lampara> lamp = new ArrayList<Lampara>();
        lamp.add(new Lampara("aa001"));
        lamp.add(new Lampara("aa002",75,"Consumo B"));
        lamp.add(new Lampara("aa003",100,"Consumo A"));
        Empresa e = new Empresa(lamp);
        e.add(new Lampara("aa125"));
        System.out.println(e.getLamp("aa002").code);
        System.out.println(e.getLamp("aa001").code);
        System.out.println(e.getLamp("aa002").code);
        e.modify(new Lampara("aa342"),"aa003");
        e.inform();
    }
}
