package com.rweqx.logic;

/**
 * The sudoku solver.
 */
public class Solver {


    public Solver() {

    }

    public Board solveByBruteForce(Board b){
        Board copy = new Board(b);

        int square = copy.getNextEmpty();
        //System.out.println("Next Empty is " + square);

        if(square != -1) {
            for (int i = 1; i <= 9; i++) {
                //System.out.println("Setting " + square + " " + i);
                copy.setValue(square, i);
                if (copy.isLegal()) {
                    //System.out.println("Legal, continuing");

                    //Recursively call on the next board spot.
                    Board ret = solveByBruteForce(copy);
                    if (ret != null) { //if ret isn't null then return
                        return ret;
                    }
                    //Otherwise, try other values.

                } else {
                    //System.out.println("Not Legal");
                    //Try next value...
                }
            }
        }else if(copy.isLegal() && copy.isSolved()) {
            System.out.println("Solved!!!!!!!!!!!!!!!!!!");
            return copy;
        }
        return null;
    }

    // TODO
    private Board solveByAnalytics(Board board) {
        return board;
    }

    private boolean solveRowsOrColumn(int ID, boolean isRow) {
        return false;
    }

    private boolean solve3by3(int ID){
        return false;
    }

    private boolean solveBox(int boxID){

        return false;
    }
}
