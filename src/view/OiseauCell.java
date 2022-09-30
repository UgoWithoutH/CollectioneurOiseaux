package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import model.oiseaux.Oiseau;

import java.time.LocalDate;

public class OiseauCell extends ListCell<Oiseau> {

    @Override
    protected void updateItem(Oiseau item, boolean empty) {
        super.updateItem(item, empty);
        Label label = new Label();
        HBox hBox = createInnerCell(item, label);
        if(!empty){
            setGraphic(hBox);
            label.textProperty().bind(item.nomProperty());
            styleProperty().bind(item.styleCellProperty());
        }else{
            label.textProperty().unbind();
            styleProperty().unbind();
            setGraphic(null);
            setText("");
            setStyle("");
        }
    }

    private HBox createInnerCell(Oiseau item, Label label) {
        HBox hBox = new HBox();
        Pane pane = new Pane();
        Button button = new Button("nourrir");
        button.setOnAction(__ -> item.manger(LocalDate.now()));

        hBox.getChildren().addAll(label, pane, button);
        HBox.setHgrow(pane, Priority.ALWAYS);

        return hBox;
    }
}
