package model;

import model.oiseaux.CreateurOiseaux;
import model.oiseaux.Oiseau;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    private static final int NUMBER_MONTH_TO_INC = 1;
    private LocalDate currentDate = LocalDate.now();
    private List<Oiseau> oiseaux = new ArrayList<>();
    private CreateurOiseaux createurOiseaux = new CreateurOiseaux();
    private VerifieurDernierRepas verifieurDernierRepas = new VerifieurDernierRepas();

    public void avancerDate(){
        currentDate = LocalDate.of(currentDate.getYear(), currentDate.getMonth().plus(NUMBER_MONTH_TO_INC), currentDate.getDayOfMonth());
        verifieurDernierRepas.vérifier(currentDate, oiseaux);
    }

    public boolean creerOiseau(String nom, String color, String type){
        try {
            oiseaux.add(createurOiseaux.creer(nom, color, type));
            return true;
        } catch (TypeException e) {
            return false;
        }
    }

}
