package org.JavaCar;

public class Roda {
    private String marca;
    private float diametre;


    public Roda(String marca, float diametre) {
        this.marca = marca;
        this.diametre = diametre;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public float getDiametre() {
        return diametre;
    }

    public void setDiametre(float diametre) {
        this.diametre = diametre;
    }
}
