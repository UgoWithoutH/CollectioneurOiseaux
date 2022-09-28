package model.oiseaux;

import model.Color;

import java.time.LocalDate;

public abstract class Oiseau {
    private String nom;
    private Color couleur;
    private LocalDate dateDernierRepas;
    private int daysBeforeEat;

    private boolean affame = false;

    public Oiseau(String nom, Color couleur, int daysBeforeEat) {
        this.nom = nom;
        this.couleur = couleur;
        this.dateDernierRepas = null;
    }

    public String getNom() {
        return nom;
    }

    public Color getCouleur() {
        return couleur;
    }

    public LocalDate getDateDernierRepas() {
        return dateDernierRepas;
    }

    public void setDateDernierRepas(LocalDate dateDernierRepas) {
        this.dateDernierRepas = dateDernierRepas;
    }

    public int getDaysBeforeEat() {
        return daysBeforeEat;
    }

    public boolean isAffame() {
        return affame;
    }

    public void setAffame(boolean affame) {
        this.affame = affame;
    }

    public void manger(LocalDate date){
        dateDernierRepas = date;
        affame = false;
    }
}
