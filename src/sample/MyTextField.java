package sample;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;

import java.util.List;

public class MyTextField extends TextField {

    CodeChecker cc = new CodeChecker();

    public MyTextField(String s){
        super(s);
        setupSize();

    }

    public void setupSize(){
        this.setMaxSize(50, 50);
        this.setFont(new Font("Calibri", 24));

        /*
        Limits the textfield to only have one letter.
         */

        /*
        this.setOnKeyPressed(e -> {
            //System.out.println(e.getCode());
            if(cc.isAllowed(e.getCode())) {
                Platform.runLater(() -> {
                    this.setText(e.getText());
                });
            }else if(!(e.getCode() == KeyCode.TAB)){
                e.consume();
            }

        });
        */
        this.setTextFormatter(new TextFormatter<String>((Change change) -> {
            String newText = change.getControlNewText();
            newText = newText.trim();

            if(newText.length() > 1){
                newText = newText.substring(newText.length() - 1);
            }
            System.out.println("new " + newText);
            if(cc.isAllowed(newText)){
                change.setText(newText);
                return change;
            }else{
                return null;
            }
        }));

    }
}
