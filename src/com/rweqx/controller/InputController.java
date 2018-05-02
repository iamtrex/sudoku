package com.rweqx.controller;

import com.rweqx.logic.Board;
import com.rweqx.logic.Box;
import com.rweqx.logic.Solver;
import com.rweqx.view.UI;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

public class InputController {

    private Board board;
    private Solver solver;
    private UI ui;

    public InputController(Stage window){
        this.board = new Board();
        this.ui = new UI(window, this);

        this.board = board;
        solver = new Solver();

    }

    public void attemptSolveBox() {
        Board solved = solver.solveByBruteForce(board);

        if(solved != null){
            //Overwrite the board.
            Box[] boxes = solved.getBoxes();
            for(int i=0; i<boxes.length; i++){
                ui.setBoxValue(i, boxes[i].toString());
            }
        }else{
            System.out.println("Cannot solve board!");
        }
    }

    public boolean acceptInput(int boxID, int i){
        return board.attemptAdd(boxID, i);
    }



}
