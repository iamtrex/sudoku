package com.rweqx.logic;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Box boxes[] = new Box[81];

    public Board(Box[] boxes){
        this.boxes = boxes;
    }

    public Board(){
        for(int i=0; i<boxes.length; i++){
            boxes[i] = new Box();


        }
    }

    public boolean attemptAdd(int boxID, KeyEvent e) {
        if(true /*Check if allowed*/) {
            int i = getIntFromCode(e);

            boxes[boxID].setValue(i);
            return true;
        }
        return false;
    }


    private int getIntFromCode(KeyEvent e) {
        return Integer.parseInt(e.getText());
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

    public Board copy() {
        Box[] newBoxes = new Box[81];
        for(int i=0; i<81; i++){
            newBoxes[i] = new Box();
            newBoxes[i].setValue(boxes[i].getValue());
        }
        return new Board(newBoxes);
    }


    //Ignores 0's (default values)
    public boolean isLegal() {
        //Check overlap
        List<Integer> row = new ArrayList<Integer>();
        List<Integer> column = new ArrayList<Integer>();
        List<Integer> box = new ArrayList<Integer>();
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

               // int c = boxes[j*9 + i].getValue();
                if(c != 0 && column.contains(c)){
                    //System.out.println("Col Overlap, contains " + c + " with #" + (j*9 + i));
                    return false;
                }else{
                    column.add(c);
                }

                //i = boxnumber (0, 1, 2// 3, 4, 5...), j = loc in box.
                int x = (i%3)*3 + j%3;
                int y = i/3*3 + j/3;
                //int b = boxes[y*9 + x].getValue();
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

    private Integer getSquareByRow(int row, int i) {
        return boxes[row*9 + i].getValue();
    }
    private Integer getSquareByCol(int col, int i) {

        return boxes[i*9 + col].getValue();
    }

    private Integer getSquareByBox(int box, int i) {
        int x = (box%3)*3 + i%3;
        int y = box/3*3 + i/3;
        return boxes[y*9 + x].getValue();
    }


    public void printResult() {
        for(int i=0; i<81; i++){
            System.out.print(boxes[i].getValue());
            if((i+1)%9 == 0){
                System.out.println();
            }
        }
    }
}
