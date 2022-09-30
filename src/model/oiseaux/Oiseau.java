package model.oiseaux;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Color;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Oiseau {
    private StringProperty nom = new SimpleStringProperty();
        public String getNom() {return nom.get();}
        public StringProperty nomProperty() {return nom;}
        public void setNom(String nom) {this.nom.set(nom);}
    private StringProperty styleCell = new SimpleStringProperty();
        public String getStyleCell() {return styleCell.get();}
        public StringProperty styleCellProperty() {return styleCell;}
        public void setStyleCell(String styleCell) {this.styleCell.set(styleCell);}
    private Color couleur;
    private LocalDate dateDernierRepas;
    private int daysBeforeEat;
    private boolean affame = false;

    public Oiseau(String nom, Color couleur, int daysBeforeEat) {
        setNom(nom);
        this.couleur = couleur;
        this.dateDernierRepas = LocalDate.now();
        this.daysBeforeEat = daysBeforeEat;
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
        if(affame){
            setStyleCell("-fx-background-color: red");
        }
        else{
            setStyleCell("");
        }
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
        return Objects.equals(nom.get(), oiseau.nom.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
