package org.JavaCar;

public class Furgoneta extends Vehicle {
    private float capacitatCarga;

    // Constructor
    public Furgoneta(String matricula, String marca, String model, double preuBase, float capacitatCarga, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes); // Llamamos al constructor de la clase base
        this.capacitatCarga = capacitatCarga;
    }

    public float getCapacitatCarga() {
        return capacitatCarga;
    }

    public void setCapacitatCarga(float capacitatCarga) {
        this.capacitatCarga = capacitatCarga;
    }

    // Método para calcular la etiqueta ambiental
    public void calcularEtiquetaAmbiental() {
        Motor motor = this.getMotor(); // Obtenemos el motor del vehículo
        String tipoMotor = motor.getTipus(); // Obtenemos el tipo de motor

        // Comprobamos el tipo de motor y asignamos la etiqueta ambiental
        String etiqueta = "";

        if (tipoMotor.contains("Gasolina Euro3") || tipoMotor.contains("Diesel Euro4") || tipoMotor.contains("Diesel Euro5")) {
            etiqueta = "B";
        } else if (tipoMotor.contains("Gasolina Euro4") || tipoMotor.contains("Gasolina Euro5") || tipoMotor.contains("Gasolina Euro6") ||
                tipoMotor.contains("Diesel Euro6")) {
            etiqueta = "C";
        } else if (tipoMotor.contains("Híbrid endollable") || tipoMotor.contains("Elèctric híbrid endollable (PHEV)") ||
                tipoMotor.contains("Híbrid no endollable (HEV)") || tipoMotor.contains("Gas natural") ||
                tipoMotor.contains("Gas natural comprimit (GNC)") || tipoMotor.contains("Gas liquat del petroli (GLP)")) {
            etiqueta = "ECO";
        } else if (tipoMotor.contains("Elèctrics de bateria (BEV)") || tipoMotor.contains("Elèctrics d'autonomia estesa (REEV)") ||
                (tipoMotor.contains("Elèctric híbrid endollable (PHEV)") && motor.getPotencia() >= 40)) {
            etiqueta = "Zero emissions";
        } else {
            etiqueta = "Sense distintiu"; // Si el vehículo no cumple ningún requisito mínimo
        }

        // Asignamos o imprimimos la etiqueta ambiental
        System.out.println("La etiqueta ambiental de la furgoneta es: " + etiqueta);
    }


    @Override
    public double calcularPreu(int dies) {
        double preuBase = getPreuBase() * dies;  // Preu base sense modificacions
        double taxaAddicional = 0;

        // Aplica una taxa addicional si la capacitat de càrrega és superior a 1000kg
        if (capacitatCarga > 1000) {
            taxaAddicional = 10 * dies;  // Afegeix 10 per dia per a furgonetes grans
        }

        // Retorna el preu total amb la taxa addicional
        return preuBase + taxaAddicional;
    }

}
