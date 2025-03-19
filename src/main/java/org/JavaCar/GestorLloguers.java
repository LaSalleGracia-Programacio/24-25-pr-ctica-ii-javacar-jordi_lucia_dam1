package org.JavaCar;

import java.util.ArrayList;
import java.util.List;

public class GestorLloguers {

    // Mètode per calcular els ingressos totals de lloguers
    public static double calcularIngressosTotals(List<Vehicle> vehicles, int dies) {
        double ingressosTotals = 0.0;

        // Iterar sobre la llista de vehicles i sumar el preu de cada vehicle
        for (Vehicle vehicle : vehicles) {
            ingressosTotals += vehicle.calcularPreu(dies);
        }

        return ingressosTotals;
    }

    // Mètode per filtrar vehicles segons el preu màxim
    public static List<Vehicle> filtrarPerPreu(List<Vehicle> vehicles, double preuMax) {
        List<Vehicle> vehiclesFiltrats = new ArrayList<>();

        // Iterar sobre la llista de vehicles i afegir els que compleixen el criteri
        for (Vehicle vehicle : vehicles) {
            if (vehicle.calcularPreu(1) <= preuMax) {  // El càlcul es fa per un dia per comparar el preu base
                vehiclesFiltrats.add(vehicle);
            }
        }

        return vehiclesFiltrats;
    }
}
