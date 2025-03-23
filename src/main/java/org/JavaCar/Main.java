package org.JavaCar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static List<Vehicle> vehiculosAlquilados = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarVehiculos();

        while (true) {
            try {
                System.out.println("\n--- Bienvenido al sistema de alquiler de vehículos ---");
                System.out.println("1. Cliente");
                System.out.println("2. Trabajador");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1 -> menuCliente();
                    case 2 -> menuTrabajador();
                    case 3 -> {
                        System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                        return;
                    }
                    default -> System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine();
            }
        }
    }

    private static void menuCliente() {
        while (true) {
            try {
                System.out.println("\n--- Menú Cliente ---");
                System.out.println("1. Ver vehículos disponibles");
                System.out.println("2. Ver características de un vehículo");
                System.out.println("3. Alquilar un vehículo");
                System.out.println("4. Ver vehículos alquilados");
                System.out.println("5. Volver al menú principal");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1 -> mostrarVehiculos();
                    case 2 -> mostrarDetallesVehiculo();
                    case 3 -> alquilarVehiculo();
                    case 4 -> mostrarVehiculosAlquilados();
                    case 5 -> { return; }
                    default -> System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine();
            }
        }
    }

    private static void menuTrabajador() {
        while (true) {
            try {
                System.out.println("\n--- Menú Trabajador ---");
                System.out.println("1. Ver vehículos disponibles");
                System.out.println("2. Ver características de un vehículo");
                System.out.println("3. Agregar un nuevo vehículo");
                System.out.println("4. Eliminar un vehículo");
                System.out.println("5. Ver vehículos alquilados");
                System.out.println("6. Volver al menú principal");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1 -> mostrarVehiculos();
                    case 2 -> mostrarDetallesVehiculo();
                    case 3 -> agregarVehiculo();
                    case 4 -> eliminarVehiculo();
                    case 5 -> mostrarVehiculosAlquilados();
                    case 6 -> { return; }
                    default -> System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine();
            }
        }
    }

    private static void inicializarVehiculos() {
        Motor motor1 = new Motor("Gasolina Euro5", 120);
        Motor motor2 = new Motor("Diesel Euro6", 150);
        Roda[] rodes = { new Roda("Michelin", 16), new Roda("Michelin", 16), new Roda("Michelin", 16), new Roda("Michelin", 16) };

        vehicles.add(new Cotxe("1234ABC", "Toyota", "Corolla", 50.0, 5, motor1, rodes));
        vehicles.add(new Furgoneta("5678DEF", "Ford", "Transit", 80.0, 1200, motor2, rodes));
        vehicles.add(new Moto("9101GHI", "Yamaha", "R6", 40.0, 600, motor1, new Roda[]{ new Roda("Bridgestone", 17), new Roda("Bridgestone", 17) }));
    }

    private static void mostrarVehiculos() {
        if (vehicles.isEmpty()) {
            System.out.println("No hay vehículos disponibles.");
            return;
        }
        System.out.println("\n--- Vehículos Disponibles ---");
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle v = vehicles.get(i);
            System.out.println((i + 1) + ". " + v.marca + " " + v.model + " - Matrícula: " + v.matricula);
        }
    }

    private static void mostrarDetallesVehiculo() {
        mostrarVehiculos();
        System.out.print("Seleccione el número del vehículo para ver sus detalles: ");

        int indice = validarSeleccion();
        if (indice == -1) return;

        mostrarDetalles(vehicles.get(indice));
    }

    private static void mostrarDetalles(Vehicle v) {
        System.out.println("\n--- Características del vehículo ---");
        System.out.println("Marca: " + v.marca);
        System.out.println("Modelo: " + v.model);
        System.out.println("Matrícula: " + v.matricula);
        System.out.println("Motor: " + v.getMotor().getTipus() + " (" + v.getMotor().getPotencia() + " CV)");
        System.out.println("Precio base: " + v.getPreuBase() + "€ por día");
    }

    private static void alquilarVehiculo() {
        if (vehicles.isEmpty()) {
            System.out.println("No hay vehículos disponibles para alquilar.");
            return;
        }

        mostrarVehiculos();
        System.out.print("Seleccione el número del vehículo a alquilar: ");

        int indice = validarSeleccion();
        if (indice == -1) return;

        Vehicle seleccionado = vehicles.get(indice);
        mostrarDetalles(seleccionado);

        System.out.print("Ingrese la cantidad de días de alquiler: ");
        int dias = validarEntradaNumerica();
        if (dias == -1) return;

        double precio = seleccionado.calcularPreu(dias);
        System.out.println("Precio total: " + precio + "€");

        // Confirmación de alquiler
        System.out.print("¿Desea confirmar el alquiler? (S/N): ");
        String confirmacion = scanner.next().trim().toUpperCase();

        if (confirmacion.equals("S")) {
            vehicles.remove(indice); // Eliminamos de la lista de disponibles
            vehiculosAlquilados.add(seleccionado); // Agregamos a la lista de alquilados
            System.out.println("¡Alquiler confirmado! Vehículo agregado a la lista de alquilados.");
        } else {
            System.out.println("Alquiler cancelado.");
        }
    }


    private static void mostrarVehiculosAlquilados() {
        if (vehiculosAlquilados.isEmpty()) {
            System.out.println("No hay vehículos alquilados.");
            return;
        }
        System.out.println("\n--- Vehículos Alquilados ---");
        for (Vehicle v : vehiculosAlquilados) {
            System.out.println(v.marca + " " + v.model + " - Matrícula: " + v.matricula);
        }
    }

    private static void agregarVehiculo() {
        System.out.println("\n--- Agregar un Nuevo Vehículo ---");

        int opcion;
        do {
            System.out.println("Ingrese qué tipo de vehículo desea agregar ");
            System.out.print("Coche (1) | Furgoneta (2) | Moto (3): ");
            opcion = validarEntradaNumerica();
        } while (opcion != 1 && opcion != 2 && opcion != 3);

        int numRodes;
        do {
            System.out.print("Ingrese el número de ruedas del vehículo: ");
            numRodes = validarEntradaNumerica();
        } while (numRodes <= 0);

        System.out.print("Ingrese la matrícula: ");
        String matricula = scanner.next();

        System.out.print("Ingrese la marca: ");
        String marca = scanner.next();

        System.out.print("Ingrese el modelo: ");
        String modelo = scanner.next();

        double precio;
        do {
            System.out.print("Ingrese el precio base por día: ");
            precio = validarEntradaNumerica();
        } while (precio <= 0);

        String tipus;
        do {
            System.out.println("Ingrese el tipo de motor de la siguiente lista: ");
            Motor.printTipusMotors();
            scanner.nextLine();
            tipus = scanner.nextLine();
        } while (!Motor.tipusValid(tipus));

        int potencia;
        do {
            System.out.print("Ingrese la potencia del motor (en CV): ");
            potencia = validarEntradaNumerica();
        } while (potencia <= 0);

        System.out.print("Ingrese la marca de las ruedas: ");
        String marcaRuedas = scanner.next();

        int diametro;
        do {
            System.out.print("Ingrese el diámetro de las ruedas (en pulgadas): ");
            diametro = validarEntradaNumerica();
        } while (diametro <= 0);

        // Crear el array de ruedas con el tamaño adecuado según el tipo de vehículo
        Roda[] rodes = new Roda[numRodes];
        for (int i = 0; i < numRodes; i++) {
            rodes[i] = new Roda(marcaRuedas, diametro);
        }

        // Crear el motor
        Motor motor = new Motor(tipus, potencia);

        // Crear el vehículo según la opción seleccionada
        Vehicle nuevoVehiculo;
        switch (opcion) {
            case 1:
                nuevoVehiculo = new Cotxe(matricula, marca, modelo, precio, numRodes, motor, rodes);
                break;
            case 2:
                nuevoVehiculo = new Furgoneta(matricula, marca, modelo, precio, numRodes, motor, rodes);
                break;
            case 3:
                nuevoVehiculo = new Moto(matricula, marca, modelo, precio, numRodes, motor, rodes);
                break;
            default:
                System.out.println("Error inesperado.");
                return;
        }

        // Agregar el vehículo a la lista
        vehicles.add(nuevoVehiculo);

        System.out.println("Vehículo agregado con éxito.");
    }




    private static void eliminarVehiculo() {
        if (vehicles.isEmpty()) {
            System.out.println("No hay vehículos disponibles para eliminar.");
            return;
        }

        mostrarVehiculos();
        System.out.print("Seleccione el número del vehículo a eliminar: ");

        int indice = validarSeleccion();
        if (indice == -1) return;

        Vehicle eliminado = vehicles.remove(indice);
        System.out.println("Vehículo eliminado: " + eliminado.marca + " " + eliminado.model + " (" + eliminado.matricula + ")");
    }

    private static int validarSeleccion() {
        int seleccion = validarEntradaNumerica();
        return (seleccion > 0 && seleccion <= vehicles.size()) ? seleccion - 1 : -1;
    }

    private static int validarEntradaNumerica() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un número válido.");
            scanner.nextLine();
            return -1;
        }
    }
}
