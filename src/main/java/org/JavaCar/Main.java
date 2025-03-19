package org.JavaCar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        tiposMotor();
    }

    // Mètode per retornar els tipus de motors
    public static List<String> tiposMotor() {
        List<String> tipos = new ArrayList<String>();
        tipos.add("Gasolina Euro3");
        tipos.add("Gasolina Euro4");
        tipos.add("Gasolina Euro5");
        tipos.add("Gasolina Euro6");
        tipos.add("Diesel Euro4");
        tipos.add("Diesel Euro5");
        tipos.add("Diesel Euro6");
        tipos.add("Híbrid endollable");
        tipos.add("Elèctric híbrid endollable (PHEV)");
        tipos.add("Híbrid no endollable (HEV)");
        tipos.add("Elèctrics de bateria (BEV)");
        tipos.add("Elèctrics d'autonomia estesa (REEV)");
        tipos.add("Gas natural");
        tipos.add("Gas natural comprimit (GNC)");
        tipos.add("Gas liquat del petroli (GLP)");
        tipos.add("Sense distinció");
        return tipos;
    }

    public static int[] autonomia(){
        return null;
    }
}