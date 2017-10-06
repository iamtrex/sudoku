package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class UI {
    Stage window;
    Scene scene;

    MyTextField[] boxes = new MyTextField[81];
    HBox[] hboxes = new HBox[9];
    VBox vbox;

    public UI(Stage window){
        this.window = window;

        Group root = new Group();

        vbox = new VBox(1);

        for(int i=0; i<hboxes.length; i++){
            hboxes[i] = new HBox(1);
        }

        for(int i=0; i<boxes.length; i++){
            boxes[i] = new MyTextField(" ");
            hboxes[i/9].getChildren().add(boxes[i]);
        }

        vbox.getChildren().addAll(hboxes);

        root.getChildren().add(vbox);

        scene = new Scene(root, 500, 500);
        window.setScene(scene);

        window.show();
    }

}
