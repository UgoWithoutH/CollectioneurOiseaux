package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.oiseaux.CreateurOiseaux;
import model.oiseaux.Oiseau;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    private static final int NUMBER_DAYS_TO_INC = 7;
    private LocalDate currentDate = LocalDate.now();
    private ObservableList<Oiseau> oiseauxObservable = FXCollections.observableArrayList();
    private ListProperty oiseaux = new SimpleListProperty(oiseauxObservable);
        public Object getOiseaux() {return oiseaux.get();}
        public ListProperty oiseauxProperty() {return oiseaux;}
        public void setOiseaux(Object oiseaux) {this.oiseaux.set(oiseaux);}

    private CreateurOiseaux createurOiseaux = new CreateurOiseaux();
    private VerifieurDernierRepas verifieurDernierRepas = new VerifieurDernierRepas();

    public void avancerDate(){
        currentDate = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), currentDate.getDayOfMonth()).plusDays(NUMBER_DAYS_TO_INC);
        verifieurDernierRepas.vérifier(currentDate, oiseaux);
    }

    public boolean creerOiseau(String nom, String color, String type){
        try {
            Oiseau oiseau = createurOiseaux.creer(nom, color, type);
            if(!oiseaux.contains(oiseau)) {
                oiseauxObservable.add(oiseau);
                return true;
            }
            else{
                return false;
            }
        } catch (TypeException e) {
            return false;
        }
    }

}
