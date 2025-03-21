package org.JavaCar;

import java.util.Arrays;
import java.util.List;

public class Motor {
    private String tipus;
    private int potencia;
    private static final List<String> TIPUS_MOTORS = Arrays.asList(
            "Gasolina Euro3",
            "Gasolina Euro4",
            "Gasolina Euro5",
            "Diesel Euro4",
            "Diesel Euro5",
            "Diesel Euro6",
            "Híbrid endollable",
            "Elèctric híbrid endollable (PHEV)",
            "Híbrid no endollable (HEV)",
            "Gas natural"
    );

    public Motor(String tipus, int potencia) {
        if (!TIPUS_MOTORS.contains(tipus)) {
            throw new IllegalArgumentException("Tipus de motor no vàlid: " + tipus);
        }
        this.tipus = tipus;
        this.potencia = potencia;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        if (!TIPUS_MOTORS.contains(tipus)) {
            throw new IllegalArgumentException("Tipus de motor no vàlid: " + tipus);
        }
        this.tipus = tipus;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public static List<String> getTipusMotors() {
        return TIPUS_MOTORS;
    }

    public static void printTipusMotors() {
        for (String motor : TIPUS_MOTORS) {
            System.out.println(motor);
        }
    }

}
