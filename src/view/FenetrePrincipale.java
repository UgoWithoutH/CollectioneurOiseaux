package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Manager;
import model.oiseaux.Oiseau;

public class FenetrePrincipale {

    @FXML
    private VBox root;
    @FXML
    private TextField nomOiseau;
    @FXML
    private TextField couleurOiseau;
    @FXML
    private TextField typeOiseau;
    @FXML
    private ListView<Oiseau> listView;
    @FXML
    private Label error;
    @FXML
    private VBox detail;
    @FXML
    private Label nomDetail;
    @FXML
    private Label couleurDetail;
    @FXML
    private Label typeDetail;
    @FXML
    private Button fermerDetail;
    private Stage stage;
    private Manager manager;

    public FenetrePrincipale(Stage stage) {
        this.stage = stage;
        manager = new Manager();
    }

    public void initialize(){
        root.prefWidthProperty().bind(stage.widthProperty());
        root.prefHeightProperty().bind(stage.heightProperty());
        listView.itemsProperty().bind(manager.oiseauxProperty());
        listView.setCellFactory(__ -> new OiseauCell());
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {

        });
        error.setStyle("-fx-text-fill: red");
    }

    @FXML
    private void creer(){
        boolean res = manager.creerOiseau(nomOiseau.getText(), couleurOiseau.getText(), typeOiseau.getText());
        if(!res){
            setError("ERREUR OISEAU DEJA EXISTANT");
        }
        else{
            setError("");
        }
    }

    @FXML
    private void avancer(){
        manager.avancerDate();
        setError("");
    }

    private void setError(String message){
        error.setText(message);
    }

}
