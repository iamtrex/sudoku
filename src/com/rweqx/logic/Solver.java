package com.rweqx.logic;

public class Solver {

    Board board;

    public Solver(Board b){
        this.board = b;

    }

    public Solver() {

    }

    public void solve(){
        Board b = solveByBruteForce(board);
        Board b2 = solveByAnalytics(board);
    }

    public Board solveByBruteForce(Board b){
        Board copy = b.copy();
        int square = copy.getNextEmpty();
        //System.out.println("Next Empty is " + square);

        if(square != -1) {
            for (int i = 1; i <= 9; i++) {
                //System.out.println("Setting " + square + " " + i);
                copy.setValue(square, i);
                if (copy.isLegal()) {
                    //System.out.println("Legal, continuing");

                    Board ret = solveByBruteForce(copy);
                    if (ret != null) {
                        return ret;
                    }
                    //System.out.println("Path returned null");
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

    public boolean addTo(Board b, int id, int value){
        b.setValue(id, value);
        return b.isLegal();

    }

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
