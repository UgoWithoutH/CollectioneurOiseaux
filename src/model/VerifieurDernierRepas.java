package model;

import model.oiseaux.Oiseau;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class VerifieurDernierRepas {

    public void vérifier(LocalDate currentDate, List<Oiseau> oiseaux){
        for(Oiseau oiseau : oiseaux){
            if(Period.between(oiseau.getDateDernierRepas(), currentDate).getDays() >= oiseau.getDaysBeforeEat()){
                oiseau.setAffame(true);
            }
        }
    }

}
