package org.JavaCar;

public abstract class Vehicle implements Llogable {
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda rodes;
    protected String etiquetaAmbiental;

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPreuBase() {
        return preuBase;
    }

    public void setPreuBase(double preuBase) {
        this.preuBase = preuBase;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Roda getRoda() {
        return rodes;
    }

    public void setRoda(Roda roda) {
        this.rodes = roda;
    }

    public String getEtiquetaAmbiental() {
        return etiquetaAmbiental;
    }

    public void setEtiquetaAmbiental(String etiquetaAmbiental) {
        this.etiquetaAmbiental = etiquetaAmbiental;
    }

    @Override
    public double calcularPreu(int dies) {
        return preuBase * dies;
    }
}
