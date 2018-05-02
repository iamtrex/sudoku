package com.rweqx.view;

import com.rweqx.controller.InputController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class BoxUI extends HBox{

    private final int SIZE = 50;
    private int ID;
    private ValueBox input;
    private InputController IC;

    public BoxUI(InputController IC, int ID){
        this.ID = ID;
        this.IC = IC;
        input = new ValueBox();


        this.getChildren().add(input);
    }

    public void setValue(String value){
        input.setText(value);
    }

    private class ValueBox extends TextField{
        public ValueBox(){
            super();
            /*
            this.setOnKeyPressed(e ->{
                //IC.acceptInput(ID, e); //Let IC handle input.
                e.consume();
            });*/
            this.textProperty().addListener((observable, oldValue, newValue) -> {

                String rep = newValue.replaceAll("[^\\d]", "");
                if(!rep.equals("")) {
                    rep = rep.substring(rep.length() - 1);
                    ValueBox.this.setText(rep); //Keep only last character
                    IC.acceptInput(ID, Integer.parseInt(rep));
                }else{
                    ValueBox.this.setText(""); //blank
                    IC.acceptInput(ID, 0);
                }

            });

            this.setAlignment(Pos.CENTER);
            this.setMaxSize(SIZE, SIZE);
            this.setPrefSize(SIZE, SIZE);
            this.setMinSize(SIZE, SIZE);

            this.setFont(new Font("Calibri", 24));
        }


    }

}
