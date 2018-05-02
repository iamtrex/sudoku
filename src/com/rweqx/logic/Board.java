package com.rweqx.logic;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a sudoku board with 81 boxes.
 */
public class Board {

    private Box boxes[] = new Box[81];

    /** Copy constructor.
     */
    public Board(Board b){
        Box boxes[] = b.getBoxes();
        for(int i =0; i<81; i++){
            this.boxes[i] = new Box(boxes[i]);
        }
    }

    public Board(){
        for(int i=0; i<boxes.length; i++){
            boxes[i] = new Box();
        }
    }

    public Box[] getBoxes() {
        return boxes;
    }

    //TODO check if add is allowed, currently doesn't prevent obvious incorrect boards.
    public boolean attemptAdd(int boxID, int i) {
        if(true /*Check if allowed*/) {
            boxes[boxID].setValue(i);
            return true;
        }
        return false;
    }


    public boolean isSolved() {
        //Check if all boxes are filled
        for(int i=0; i<81; i++){
            if(boxes[i].getValue() == 0){
                return false;
            }
        }
        return isLegal();
    }

    public int getNextEmpty() {
        for(int i=0; i<boxes.length; i++){
            if(boxes[i].getValue() == 0){
                return i;
            }
        }
        return -1;
    }

    public void setValue(int id, int value) {
        boxes[id].setValue(value);
    }


    /**
     * Returns wehther or current board configuration is legal.
     */
    public boolean isLegal() {
        //Check overlap
        List<Integer> row = new ArrayList<>();
        List<Integer> column = new ArrayList<>();
        List<Integer> box = new ArrayList<>();

        for(int i=0; i<9; i++){ //Row Col or Box #.
            for(int j=0; j<9; j++){ //Element in box.

                //int r = boxes[i*9 + j].getValue();
                int r = getSquareByRow(i, j);
                int c = getSquareByCol(i, j);
                int b = getSquareByBox(i, j);

                if(r != 0 && row.contains(r)){
                    //System.out.println("Row Overlap, contains " + r + " with #" + (i*9 + j));
                    return false;
                }else{
                    row.add(r);
                }


                if(c != 0 && column.contains(c)){
                    //System.out.println("Col Overlap, contains " + c + " with #" + (j*9 + i));
                    return false;
                }else{
                    column.add(c);
                }

                //i = boxnumber (0, 1, 2// 3, 4, 5...), j = loc in box.
                //int x = (i%3)*3 + j%3;
                //int y = i/3*3 + j/3;
                if(b != 0 && box.contains(b)){
                    //System.out.println("Box Overlap, contains " + b + " with #" + (y*9 + x));
                    return false;
                }else{
                    box.add(b);
                }
            }
            row.clear();
            column.clear();
            box.clear();
        }
        return true;
    }



    public List<Integer> getRow(int row){
        List<Integer> ret = new ArrayList<>();

        for(int i=0; i<9; i++){
            ret.add(getSquareByRow(row, i));
        }
        return ret;
    }


    public List<Integer> getCol(int col){


        List<Integer> ret = new ArrayList<>();

        for(int i=0; i<9; i++){
            ret.add(getSquareByCol(col, i));
        }
        return ret;
    }

    public List<Integer> getBox(int box){

        List<Integer> ret = new ArrayList<>();

        for(int i=0; i<9; i++){
            ret.add(getSquareByBox(box, i));
        }
        return ret;
    }

    /**
     * Return ith element of given row number.
     * @param row
     * @param i
     * @return
     */
    private Integer getSquareByRow(int row, int i) {
        return boxes[row*9 + i].getValue();
    }


    /**
     * Return ith element of given col number.
     * @param col
     * @param i
     * @return
     */
    private Integer getSquareByCol(int col, int i) {

        return boxes[i*9 + col].getValue();
    }

    /**
     * Returns the ith element (counting from topleft by rows til the bottom right)
     *     of the given box number.
     * @param box
     * @param i
     * @return
     */
    private Integer getSquareByBox(int box, int i) {
        int x = (box%3)*3 + i%3;
        int y = box/3*3 + i/3;
        return boxes[y*9 + x].getValue();
    }


    /**
     * Prints the board
     */
    public String toString() {
        String s = "";
        for(int i=0; i<81; i++){
            s += boxes[i].toString();

            if((i+1)%9 == 0)
                s += "\n";

        }
        return s;
    }
}
