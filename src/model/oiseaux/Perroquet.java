package model.oiseaux;

import model.Color;
import model.oiseaux.Oiseau;

public class Perroquet extends Oiseau {

    private static final int DAYS_BEFORE_EAT = 4;

    public Perroquet(String nom, Color couleur) {
        super(nom, couleur, DAYS_BEFORE_EAT);
    }
}
