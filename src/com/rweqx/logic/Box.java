package com.rweqx.logic;

/**
 * Represents a spot on the sudoku grid.
 */
public class Box {

    private int value;

    public Box(){
        value = 0;
    }

    /**
     * Copy constructor
     * @param box
     */
    public Box(Box box) {
        this.setValue(box.getValue());
    }

    public void setValue(int i){
        value = i;

    }

    public int getValue(){
        return value;
    }

    public String toString(){
        return Integer.toString(value);
    }
}
