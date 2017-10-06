package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Platform.setImplicitExit(true);
        UI ui = new UI(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
