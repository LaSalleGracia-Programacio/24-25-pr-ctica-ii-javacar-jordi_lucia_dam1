package org.JavaCar;

public class Moto extends Vehicle {
    private int cilindrada;

    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes); // Llamamos al constructor de la clase base
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    // Método para calcular la etiqueta ambiental
    public void calcularEtiquetaAmbiental() {
        Motor motor = this.getMotor(); // Obtenemos el motor del vehículo
        String tipoMotor = motor.getTipus(); // Obtenemos el tipo de motor

        // Comprobamos el tipo de motor y asignamos la etiqueta ambiental
        String etiqueta = "";

        if (tipoMotor.contains("Euro 1")) {
            etiqueta = "Sin distintivo"; // Motos Euro 1 no tienen distintivo
        } else if (tipoMotor.contains("Euro 2")) {
            etiqueta = "B"; // Motos Euro 2 obtienen etiqueta B
        } else if (tipoMotor.contains("Euro 3") || tipoMotor.contains("Euro 4")) {
            etiqueta = "C"; // Motos Euro 3 y Euro 4 obtienen etiqueta C
        } else if (tipoMotor.contains("Híbrid") || tipoMotor.contains("Elèctric híbrid endollable (PHEV)") || tipoMotor.contains("Híbrid no endollable (HEV)")) {
            etiqueta = "ECO"; // Motos híbridas con autonomía < 40 km
        } else if (tipoMotor.contains("Elèctrics de bateria (BEV)") || tipoMotor.contains("Elèctrics d'autonomia estesa (REEV)") ||
                (tipoMotor.contains("Elèctric híbrid endollable (PHEV)") && motor.getPotencia() >= 40)) {
            etiqueta = "Zero emissions"; // Motos eléctricas con autonomía >= 40 km
        } else {
            etiqueta = "Sin distintivo"; // En caso de que no cumpla ninguna condición válida
        }

        // Asignamos o imprimimos la etiqueta ambiental
        System.out.println("La etiqueta ambiental de la moto es: " + etiqueta);
    }
    @Override
    public double calcularPreu(int dies) {
        double preuBase = getPreuBase() * dies;
        double taxaAddicional = 0;

        // Aplica una taxa addicional si la cilindrada és superior a 500cc
        if (cilindrada > 500) {
            taxaAddicional = 5 * dies;  // Afegeix 5 per dia per a motos grans
        }

        // Retorna el preu total amb la taxa addicional
        return preuBase + taxaAddicional;
    }
}
