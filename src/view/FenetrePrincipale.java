package view;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.oiseaux.Oiseau;
import viewmodel.ManagerVM;
import viewmodel.OiseauVM;

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
    private ListView<OiseauVM> listViewOiseauVM;
    @FXML
    private Label error;
    @FXML
    private VBox detail;
    @FXML
    private TextField nomDetail;
    @FXML
    private Label couleurDetail;
    @FXML
    private Label typeDetail;
    @FXML
    private HBox myHBox;
    @FXML
    private Button fermerDetail;
    private OiseauVM oiseauSelectionne;
    private Stage stage;
    private ManagerVM managerVM;

    public FenetrePrincipale(Stage stage) {
        this.stage = stage;
        managerVM = new ManagerVM();
    }

    public void initialize(){
        root.prefWidthProperty().bind(stage.widthProperty());
        root.prefHeightProperty().bind(stage.heightProperty());
        myHBox.prefWidthProperty().bind(stage.widthProperty());
        HBox.setHgrow(listViewOiseauVM,Priority.ALWAYS);
        stage.widthProperty().addListener((obs, oldV, newV) -> {
            detail.setPrefWidth(newV.doubleValue() * 0.35);
        });
        detail.setStyle("-fx-background-color: white");
        detail.setPadding(new Insets(10,10,10,10));
        initializeListView();
        error.setStyle("-fx-text-fill: red");
    }

    private void initializeListView() {
        listViewOiseauVM.itemsProperty().bind(managerVM.oiseauxProperty());
        listViewOiseauVM.setCellFactory(__ -> new OiseauVMCell());
        listViewOiseauVM.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if(newVal != null) {
                oiseauSelectionne = newVal;
            }
            else{
                oiseauSelectionne = oldVal;
            }

            if(oldVal != null){
                nomDetail.textProperty().unbindBidirectional(oldVal.nomProperty());
            }

            nomDetail.textProperty().bindBidirectional(oiseauSelectionne.nomProperty());
            couleurDetail.textProperty().bind(oiseauSelectionne.couleurProperty().asString());
            typeDetail.textProperty().bind(oiseauSelectionne.typeProperty());
        });
    }

    @FXML
    private void creer(){
        boolean res = managerVM.creerOiseau(nomOiseau.getText(), couleurOiseau.getText(), typeOiseau.getText());
        if(!res){
            setError("ERREUR OISEAU DEJA EXISTANT");
        }
        else{
            setError("");
        }
    }

    @FXML
    private void avancer(){
        managerVM.avancerDate();
        setError("");
    }

    private void setError(String message){
        error.setText(message);
    }

}
