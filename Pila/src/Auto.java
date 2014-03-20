/**
 * Created by Luciano on 18/03/14.
 */
public class Auto {
    private String patente;
    private String marca;
    private String modelo;
    private String color;
    public Auto(String pat, String mar,String model,String col){
        patente = pat;
        marca = mar;
        modelo = model;
        color = col;
    }
    public Auto(String pat){
        patente = pat;
    }
    public String getPatente(){
        return patente;
    }
    public String getMarca(){
        return marca;

    }
    public String getModelo(){
        return modelo;
    }
    public String getColor(){
        return color;
    }
}
