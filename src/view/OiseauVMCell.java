package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import viewmodel.OiseauVM;

import java.time.LocalDate;

public class OiseauVMCell extends ListCell<OiseauVM> {

    @Override
    protected void updateItem(OiseauVM item, boolean empty) {
        super.updateItem(item, empty);
        Label label = new Label();
        HBox hBox = createInnerCell(item, label);
        if(!empty){
            setGraphic(hBox);
            label.textProperty().bind(item.nomProperty());
            item.affameProperty().addListener((obs, oldVal, newVal) -> {
                if(newVal){
                    setStyle("-fx-background-color: red");
                }else{
                    setStyle("");
                }
            });
        }else{
            label.textProperty().unbind();
            styleProperty().unbind();
            setGraphic(null);
            setText("");
            setStyle("");
        }
    }

    private HBox createInnerCell(OiseauVM item, Label label) {
        HBox hBox = new HBox();
        Pane pane = new Pane();
        Button button = new Button("nourrir");
        button.setOnAction(__ -> item.manger(LocalDate.now()));

        hBox.getChildren().addAll(label, pane, button);
        HBox.setHgrow(pane, Priority.ALWAYS);

        return hBox;
    }
}
