package com.rweqx.view;

import com.rweqx.controller.InputController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UI {

    Stage window;

    BoxUI[] boxes = new BoxUI[81];
    HBox[] hboxes  = new HBox[9];
    VBox vbox;
    InputController IC;


    final int SPACING = 9;

    public UI(Stage window, InputController IC){
        this.IC = IC;
        this.window = window;

        for(int i=0; i<hboxes.length; i++){
            hboxes[i] = new HBox(SPACING);
        }
        for(int i=0; i<boxes.length; i++){
            boxes[i] = new BoxUI(IC, i);
            hboxes[i/9].getChildren().add(boxes[i]);
        }

        vbox = new VBox(SPACING);
        vbox.getChildren().addAll(hboxes);

        Group root = new Group();
        root.getChildren().add(vbox);

        window.setScene(new Scene(root, 500, 500));
        window.setMaximized(true);
        window.show();

    }


}
