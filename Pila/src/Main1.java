public class Main {

    public static void main(String[] args) {
        String numero = Scanner.getString("Ingrese el numero a calcular:");
        int length = numero.length();
        char [] arraynum = new char[length];
        for(int i =0; i<length; i++){
           arraynum[i] = numero.charAt(i);

        }
        Calculadora casio = new Calculadora(arraynum, length);
        casio.Calculate();
    }
}
