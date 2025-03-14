package org.JavaCar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        tiposMotor();
    }
    public static List<String> tiposMotor(){
        List<String> tipos = new ArrayList<String>();
        tipos.add("Gasolina Euro3");
        tipos.add("Gasolina Euro4");
        tipos.add("Gasolina Euro5");
        tipos.add("Gasolina Euro6");
        tipos.add("Diesel Euro6");
        tipos.add("Híbrid endollable");
        tipos.add("Híbrid no endollable (HEV)");
        tipos.add("PHEV");
        tipos.add("Gas natural");
        tipos.add("Gas natural comprimit (GNC)");
        tipos.add("Gas liquat del petroli (GLP)");
        tipos.add("Sense distinció");

        //BEV, REEV
        return tipos;
    }

    public static int[] autonomia(){
        return null;
    }
}