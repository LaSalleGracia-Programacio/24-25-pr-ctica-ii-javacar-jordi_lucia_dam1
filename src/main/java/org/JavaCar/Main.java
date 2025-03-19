package org.JavaCar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        tiposMotor();
    }

    // Mètode per retornar els tipus de motors
    public static List<String> tiposMotor() {
        List<String> tipus = new ArrayList<String>();
        tipus.add("Gasolina Euro3");
        tipus.add("Gasolina Euro4");
        tipus.add("Gasolina Euro5");
        tipus.add("Gasolina Euro6");
        tipus.add("Diesel Euro4");
        tipus.add("Diesel Euro5");
        tipus.add("Diesel Euro6");
        tipus.add("Híbrid endollable");
        tipus.add("Elèctric híbrid endollable (PHEV)");
        tipus.add("Híbrid no endollable (HEV)");
        tipus.add("Elèctrics de bateria (BEV)");
        tipus.add("Elèctrics d'autonomia estesa (REEV)");
        tipus.add("Gas natural");
        tipus.add("Gas natural comprimit (GNC)");
        tipus.add("Gas liquat del petroli (GLP)");
        tipus.add("Sense distinció");
        return tipus;
    }

    public static int[] autonomia(){
        return null;
    }
}