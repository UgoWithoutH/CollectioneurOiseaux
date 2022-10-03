package viewmodel;

import javafx.beans.property.*;
import model.Color;
import model.oiseaux.Oiseau;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;

public class OiseauVM implements PropertyChangeListener {
    private StringProperty nom = new SimpleStringProperty();
        public String getNom() {return nom.get();}
        public StringProperty nomProperty() {return nom;}
        public void setNom(String nom) {this.nom.set(nom);}
    private ObjectProperty<Color> couleur = new SimpleObjectProperty();
        public Color getCouleur() {return couleur.get();}
        public ObjectProperty<Color> couleurProperty() {return couleur;}
        public void setCouleur(Color couleur) {this.couleur.set(couleur);}
    private StringProperty type = new SimpleStringProperty();
        public String getType() {return type.get();}
        public StringProperty typeProperty() {return type;}
        public void setType(String type) {this.type.set(type);}
    private BooleanProperty affame = new SimpleBooleanProperty();
        public boolean isAffame() {return affame.get();}
        public BooleanProperty affameProperty() {return affame;}
        public void setAffame(boolean affame) {this.affame.set(affame);}
    private Oiseau model;

    public OiseauVM(Oiseau model) {
        this.model = model;
        model.ajouterListener(this);
        setNom(model.getNom());
        setCouleur(model.getCouleur());
        setType(model.getType());
        setAffame(model.isAffame());
    }

    public void manger(LocalDate date){
        model.manger(date);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(Oiseau.PROP_NOM)){
            nom.set((String) evt.getNewValue());
        }
        else if(evt.getPropertyName().equals(Oiseau.PROP_AFFAME)){
            affame.set((boolean) evt.getNewValue());
        }
    }
}
