package model.oiseaux;

import model.Color;
import model.oiseaux.Oiseau;

public class Pigeon extends Oiseau {

    private static final int DAYS_BEFORE_EAT = 15;

    public Pigeon(String nom, Color couleur) {
        super(nom, couleur, DAYS_BEFORE_EAT);
    }
}
