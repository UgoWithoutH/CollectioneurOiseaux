package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Manager;

public class FenetrePrincipale {

    @FXML
    private VBox root;
    @FXML
    private TextField nomOiseau;
    @FXML
    private TextField couleurOiseau;
    @FXML
    private TextField typeOiseau;
    private Stage stage;
    private Manager manager;

    public FenetrePrincipale(Stage stage) {
        this.stage = stage;
        manager = new Manager();
    }

    public void initialize(){
        root.prefWidthProperty().bind(stage.widthProperty());
        root.prefHeightProperty().bind(stage.heightProperty());
    }

    public void creer(){
        manager.creerOiseau(nomOiseau.getText(), couleurOiseau.getText(), typeOiseau.getText());
    }

}
