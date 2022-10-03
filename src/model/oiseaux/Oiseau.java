package model.oiseaux;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Color;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Oiseau {
    public static final String PROP_NOM = "PROP_NOM";
    public static final String PROP_AFFAME = "PROP_AFFAME";
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private String nom;
    private Color couleur;
    private String type;
    private LocalDate dateDernierRepas;
    private int daysBeforeEat;
    private boolean affame = false;

    public Oiseau(String nom, Color couleur, int daysBeforeEat) {
        this.nom = nom;
        this.couleur = couleur;
        this.type = getClass().getSimpleName();
        this.dateDernierRepas = LocalDate.now();
        this.daysBeforeEat = daysBeforeEat;
    }

    public void ajouterListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String old = this.nom;
        this.nom = nom;
        support.firePropertyChange(PROP_NOM, old, nom);
    }

    public Color getCouleur() {
        return couleur;
    }

    public String getType() {
        return type;
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
        boolean old = this.affame;
        this.affame = affame;
        support.firePropertyChange(PROP_AFFAME, old, affame);
    }

    public void manger(LocalDate date){
        dateDernierRepas = date;
        setAffame(false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oiseau oiseau = (Oiseau) o;
        return Objects.equals(nom, oiseau.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
