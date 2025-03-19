package org.JavaCar;

public class Motor {
    private String tipus;
    private float potencia;

    public Motor(String tipus, float potencia) {
        this.tipus = tipus;
        this.potencia = potencia;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipo) {
        this.tipus = tipo;
    }

    @Override
    public String toString() {
        return "Motor: " + tipus;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }
}
