package org.JavaCar;

public class Cotxe extends Vehicle {
    private int nombrePlaces;

    // Constructor
    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, Motor motor, Roda[] rodes) {
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
        Motor motor = this.getMotor(); // Obtenim el motor del vehicle
        String tipusMotor = motor.getTipus(); // Obtenim el tipus de motor

        // Comprovem el tipus de motor i assignem l'etiqueta ambiental
        String etiqueta = "";

        if (tipusMotor.contains("Gasolina Euro3") || tipusMotor.contains("Diesel Euro4") || tipusMotor.contains("Diesel Euro5")) {
            etiqueta = "B";
        } else if (tipusMotor.contains("Gasolina Euro4") || tipusMotor.contains("Gasolina Euro5") || tipusMotor.contains("Gasolina Euro6") ||
                tipusMotor.contains("Diesel Euro6")) {
            etiqueta = "C";
        } else if (tipusMotor.contains("Híbrid endollable") || tipusMotor.contains("Elèctric híbrid endollable (PHEV)") ||
                tipusMotor.contains("Híbrid no endollable (HEV)") || tipusMotor.contains("Gas natural") ||
                tipusMotor.contains("Gas natural comprimit (GNC)") || tipusMotor.contains("Gas liquat del petroli (GLP)")) {
            etiqueta = "ECO";
        } else if (tipusMotor.contains("Elèctrics de bateria (BEV)") || tipusMotor.contains("Elèctrics d'autonomia estesa (REEV)") ||
                tipusMotor.contains("Elèctrics híbrid endollable (PHEV)") && motor.getPotencia() >= 40) {
            etiqueta = "Zero emissions";
        } else {
            etiqueta = "Sense distintiu";
        }

        // Assignem l'etiqueta ambiental a un atribut de la classe o simplement imprimim-la
        System.out.println("L'etiqueta ambiental del vehicle és: " + etiqueta);
    }
}
