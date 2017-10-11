package com.rweqx.controller;

import com.rweqx.logic.Board;
import com.rweqx.logic.Box;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InputController {

    Board board;

    public InputController(Board board){
        this.board = board;

    }

    public void acceptInput(int boxID, KeyEvent e){
        if(acceptedCode(e)){
            System.out.println("Accepted input " + e.getCharacter());
            board.attemptAdd(boxID, e);
        }
    }

    private boolean acceptedCode(KeyEvent e){
        KeyCode code = e.getCode();
        for(KeyCode c : allowedCodes){
            if(c == code){
                return true;
            }
        }
        return false;
    }

    private final KeyCode[] allowedCodes = {
            KeyCode.DIGIT1,
            KeyCode.DIGIT2,
            KeyCode.DIGIT3,
            KeyCode.DIGIT4,
            KeyCode.DIGIT5,
            KeyCode.DIGIT6,
            KeyCode.DIGIT7,
            KeyCode.DIGIT8,
            KeyCode.DIGIT9,
            KeyCode.NUMPAD1,
            KeyCode.NUMPAD2,
            KeyCode.NUMPAD3,
            KeyCode.NUMPAD4,
            KeyCode.NUMPAD5,
            KeyCode.NUMPAD6,
            KeyCode.NUMPAD7,
            KeyCode.NUMPAD8,
            KeyCode.NUMPAD9
    };


}
