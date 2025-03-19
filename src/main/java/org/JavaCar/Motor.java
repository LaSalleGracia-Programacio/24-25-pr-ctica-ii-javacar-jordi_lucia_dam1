package org.JavaCar;

public class Motor {
    private String tipus;
    private float potencia;

    // Constructor de la clase Motor
    public Motor(String tipus, float potencia) {
        this.tipus = tipus;
        this.potencia = potencia;
    }

    // Getter para obtener el tipo de motor
    public String getTipus() {
        return tipus;
    }

    // Setter para establecer el tipo de motor
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
