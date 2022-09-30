package model.oiseaux;

import model.Color;
import model.TypeException;
import model.oiseaux.Oiseau;
import model.oiseaux.Perroquet;
import model.oiseaux.Pigeon;

public class CreateurOiseaux {

    public Oiseau creer(String nom, String color, String type) throws TypeException {

        String colorUpper = color.toUpperCase();
        switch (type.toUpperCase()){

            case "PERROQUET" -> {
                return new Perroquet(nom, Color.valueOf(colorUpper));
            }

            case "PIGEON" -> {
                return new Pigeon(nom, Color.valueOf(colorUpper));
            }

        }

        throw new TypeException();
    }
}
