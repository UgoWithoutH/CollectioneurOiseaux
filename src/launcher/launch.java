package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.FenetrePrincipale;

public class launch extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FenetrePrincipale.fxml"));
        loader.setController(new FenetrePrincipale(primaryStage));

        Scene scene = new Scene(loader.load());

        primaryStage.setScene(scene);

        primaryStage.setWidth(800);
        primaryStage.setHeight(800);

        primaryStage.show();
    }
}
