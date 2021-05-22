package POJOs;

import java.io.Serializable;

public class livre implements Serializable {
    private String nom;
    private double prix;

    public livre() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "livre{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}
