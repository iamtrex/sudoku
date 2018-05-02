package com.rweqx.view;

import com.rweqx.controller.InputController;
import com.rweqx.logic.Board;
import com.rweqx.logic.Box;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UI {


    private BoxUI[] boxes = new BoxUI[81];
    private HBox[] hboxes  = new HBox[9];
    private VBox vbox;

    private Button solve;

    private final int SPACING = 9;

    public UI(Stage window, InputController IC){
        window.setTitle("Sudoku Solver !!");

        for(int i=0; i<hboxes.length; i++){
            hboxes[i] = new HBox(SPACING);
        }

        for(int i=0; i<boxes.length; i++){
            boxes[i] = new BoxUI(IC, i);
            hboxes[i/9].getChildren().add(boxes[i]);
        }

        vbox = new VBox(SPACING);
        vbox.getChildren().addAll(hboxes);

        solve = new Button("Solve");
        solve.setOnAction(e->{
           IC.attemptSolveBox();
        });

        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(solve);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        Group root = new Group();
        root.getChildren().add(vbox);

        window.setScene(new Scene(root));
        window.sizeToScene();
        window.show();

    }


    public void setBoxValue(int boxID, String text) {
        boxes[boxID].setValue(text);
    }

}

