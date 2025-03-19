package org.JavaCar;

public class Cotxe extends Vehicle {
    private int nombrePlaces;

    // Constructor
    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, Motor motor, Roda rodes) {
        super(matricula, marca, model, preuBase, motor, rodes); // Cridem el constructor de la classe base
        this.nombrePlaces = nombrePlaces;
    }

    // Getter i Setter per a nombrePlaces
    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    // Mètode per calcular l'etiqueta ambiental
    public void calcularEtiquetaAmbiental() {
        
    }
}
