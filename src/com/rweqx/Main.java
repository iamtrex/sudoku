package com.rweqx;

import com.rweqx.controller.InputController;
import com.rweqx.logic.Board;
import com.rweqx.logic.Box;
import com.rweqx.logic.Solver;
import com.rweqx.view.UI;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;


public class Main{

    //@Override
    public void start(Stage primaryStage) throws Exception{
        Board board = new Board();
        InputController IC = new InputController(board);
        UI ui = new UI(primaryStage, IC);


        Platform.setImplicitExit(true);
    }

    public static void main(String args[]){
        //launch(args);
        Main main = new Main();
    }

    public Main(){
        testMain();
    }

    public void testMain(){
        long start = System.currentTimeMillis();
        Box[] arr = makeBoxes();
        Board board = new Board(arr);
        Solver solver = new Solver();
        Board newBoard = solver.solveByBruteForce(board);

        System.out.println("Original Problem");
        board.printResult();

        System.out.println();
        System.out.println("Solution");
        newBoard.printResult();

        long end = System.currentTimeMillis();
        System.out.println("Time Taken: " + (end-start) + "ms");
    }

    private Box[] makeBoxes() {
        Box[] arr = new Box[81];
        for(int i=0; i<arr.length; i++){
            arr[i] = new Box();
            arr[i].setValue(y[i]);
            //arr[i].setValue(x[i]);
        }
        return arr;
    }

    int x[] = {
            0, 0, 0, 0, 6, 0, 1, 9, 0,
            0, 5, 0, 0, 0, 0, 3, 8, 0,
            0, 0, 0, 0, 0, 8, 0, 4, 7,
            3, 0, 0, 0, 5, 0, 0, 0, 8,
            0, 0, 1, 9, 0, 3, 4, 0, 0,
            8, 0, 0, 0, 1, 0, 0, 0, 9,
            9, 8, 0, 6, 0, 0, 0, 0, 0,
            0, 4, 3, 0, 0, 0, 0, 7, 0,
            0, 1, 5, 0, 4, 0, 0, 0, 0};


    int y[] = {
            9, 4, 0, 0, 7, 0, 0, 3, 2,
            7, 0, 2, 3, 4, 8, 9, 0, 0,
            3, 0, 6, 0, 0, 0, 0, 7, 4,
            0, 7, 0, 0, 0, 0, 0, 0, 3,
            0, 2, 3, 7, 0, 1, 4, 0, 0,
            0, 6, 0, 0, 0, 0, 0, 8, 7,
            2, 0, 0, 5, 0, 0, 7, 0, 0,
            0, 0, 4, 8, 0, 7, 3, 2, 0,
            6, 0, 7, 0, 2, 0, 0, 0, 0};
}
