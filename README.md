# 🚗 JavaCar - Sistema de Gestió de Lloger de Vehicles

## 🌟 Descripció
Aquesta pràctica anomenada JavaCar és una potent aplicació desenvolupada a **Java** que permet gestionar el lloguer de vehicles de manera eficient i flexible. A través d'una arquitectura orientada a objectes facilita el càlcul de preus, la gestió de vehicles i la filtració de resultats segons el preu.

---

## 🛠️ Estructura del Projecte
### Interfaç `Llogable`
- Mètode: `calcularPreu(int dies): double`

### Classe Abstracta `Vehicle` (implementa `Llogable`)
- **Atributs**: matrícula, marca, model, preuBase, motor, rodes, etiquetaAmbiental.
- **Mètodes**: Getters per a accedir als atributs.

### Classes Concretes
- `Cotxe` (nombre de places)
- `Moto` (cilindrada)
- `Furgoneta` (capacitat de càrrega)

### Classes `Motor` i `Roda`
- `Motor`: tipus, potència.
- `Roda`: marca, diàmetre.

### Clase Estàtica `GestorLloguers`
- `calcularIngressosTotals(List<Vehicle>, int dies): double`
- `filtrarPerPreu(List<Vehicle>, double preuMax): List<Vehicle>`

---

## ✅ Requisits Previs
- Java JDK 11 o superior
- Git
- IDE com IntelliJ IDEA o Eclipse

---

## 🚀 Clonar el Repositori
```bash
git clone https://github.com/LaSalleGracia-Programacio/24-25-pr-ctica-ii-javacar-jordi_lucia_dam1.git
```

---

## 📝 Autors
- Lucía Martínez Gutiérrez
- Jordi Fernández

---

## 📜 Llicència
🛡️ MIT License

---

## 🎯 Objetivos
- Implementar una arquitectura orientada a objetos en Java.
- Desarrollar un sistema de alquiler flexible y escalable.
- Aplicar buenas prácticas en la gestión de proyectos con Git.
