import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by Luciano on 18/03/14.
 */
public class Estacionamiento {
    private Pila estacionamiento;
    private int dinero = 0;
    public Estacionamiento(){
         estacionamiento = new Pila();
    }
    public void start(){
        System.out.println("Bienvenido a Parking System!");
        mainMenu();
    }
    public void mainMenu(){
        System.out.println("Elegir una opcion: ");
        System.out.println("1.Guardar un auto - 2.Sacar un auto - 3.Exit");
        int choice = Scanner.getInt("Opcion: ");
        if (choice ==1){
            guardarAuto();
        }
        if (choice ==2){
            sacarAuto();
        }
        if (choice ==3){
            System.out.println("Las ganancias del dia fueron: $"+getGanancias());
            System.out.println("Gracias por operar con Parking System, hasta pronto!");
        }
        boolean mal = (choice!=1)&&(choice!=2)&&(choice!=3);
        if (mal){
            System.out.println("Por favor ingrese 1, 2 o 3. Gracias.\n");
            mainMenu();
        }
    }
    public void guardarAuto(){
        String paten = Scanner.getString("Ingrese la patente del auto(3 letras-espacio-3 numeros): ");
        paten = paten.toUpperCase();
        if(paten.length()!=7){
            System.out.println("Por favor ingrese 3 letras y 3 numeros");
            guardarAuto();
            return;
        }
        String [] splitted = paten.split(" ");
        paten = paten.trim();
        try{
           int a = Integer.parseInt(splitted[1]);
        }catch (NumberFormatException e){
            System.out.println("Por favor ingrese 3 letras y 3 numeros");
            guardarAuto();
            return;
        }
        int i =0;
        int c = 0;
        while(i<3){
            c = 0;
                String nuevo = splitted[0].substring(i,(i+1));
        try{
            int a = Integer.parseInt(nuevo);
        }catch (NumberFormatException e){
             c  = 1;
        }   finally{
            if (c!=1){
                System.out.println("Por favor ingrese 3 letras y 3 numeros");
                guardarAuto();
                return;
            }
        }
            i++;
        }
        Auto auto = new Auto(paten);
         estacionamiento.apilar(auto);
        ganacias();
        mainMenu();
    }
    public void sacarAuto(){
        String patente = Scanner.getString("Ingrese la patente del auto(3 letras-espacio-3 numeros): ");
        patente = patente.toUpperCase();
        if (patente.length()!=7){
            System.out.println("Por favor ingrese 3 letras y 3 numeros");
            sacarAuto();
            return;
        }
        String []splitted = patente.split(" ");
        patente = patente.trim();
        try {
            int a = Integer.parseInt(splitted[1]);
            }catch (NumberFormatException e){
            System.out.println("Por favor ingrese 3 letras y 3 numeros");
            sacarAuto();
            return;
        }
        int i =0;
        int c = 0;
        while(i<3){
            c = 0;
            String nuevo = splitted[0].substring(i,(i+1));
            try{
                int a = Integer.parseInt(nuevo);
            }catch (NumberFormatException e){
                c  = 1;
            }   finally{
                if (c!=1){
                    System.out.println("Por favor ingrese 3 letras y 3 numeros");
                    sacarAuto();
                    return;
                }
            }
            i++;
        }
        Auto a = null;
        Pila vereda = new Pila();
        while(estacionamiento.esVacio()==false){
            a = (Auto) estacionamiento.verTope();
            if (a.getPatente().equals(patente)){
                System.out.println("El auto fue retirado.");
                estacionamiento.desapilar();
                while(vereda.esVacio()==false){
                    estacionamiento.apilar(vereda.verTope());
                    vereda.desapilar();
                }
                break;
            }else{
                vereda.apilar(a);
                estacionamiento.desapilar();
                a = null;
            }
        }
        if (a==null){
        System.out.println("El auto con esa patente no esta registrado");
        }
        while(vereda.esVacio()==false){
            estacionamiento.apilar(vereda.verTope());
            vereda.desapilar();
        }


        mainMenu();
    }
    private void ganacias(){
        dinero = dinero+5;
    }
    public int getGanancias(){
        return dinero;
    }

}
