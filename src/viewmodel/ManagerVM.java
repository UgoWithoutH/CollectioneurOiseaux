package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Manager;
import model.oiseaux.Oiseau;

public class ManagerVM {
    private ObservableList<OiseauVM> oiseauxObservable = FXCollections.observableArrayList();
    private ListProperty oiseaux = new SimpleListProperty(oiseauxObservable);
        public Object getOiseaux() {return oiseaux.get();}
        public ListProperty oiseauxProperty() {return oiseaux;}
        public void setOiseaux(Object oiseaux) {this.oiseaux.set(oiseaux);}

    private Manager model = new Manager();

    public boolean creerOiseau(String nom, String color, String type){
        boolean res = model.creerOiseau(nom, color, type);

        if(res){
            oiseauxObservable.clear();
            for(Oiseau oiseau : model.getOiseaux()){
                oiseauxObservable.add(new OiseauVM(oiseau));
            }
        }

        return res;
    }

    public void avancerDate(){
        model.avancerDate();
    }
}
