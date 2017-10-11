package com.rweqx.view;

import com.rweqx.controller.InputController;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class BoxUI extends HBox{

    final int SIZE = 50;

    int ID;

    ValueBox input;

    InputController IC;

    public BoxUI(InputController IC, int ID){
        this.ID = ID;
        this.IC = IC;
        input = new ValueBox();


        this.getChildren().add(input);
    }

    private class ValueBox extends TextField{
        public ValueBox(){
            super();
            this.setOnKeyPressed(e ->{
                IC.acceptInput(ID, e);
            });

            this.setAlignment(Pos.CENTER);
            this.setMaxSize(SIZE, SIZE);
            this.setPrefSize(SIZE, SIZE);
            this.setMinSize(SIZE, SIZE);

            this.setFont(new Font("Calibri", 24));
        }


    }

}
