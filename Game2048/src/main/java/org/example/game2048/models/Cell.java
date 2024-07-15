package org.example.game2048.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private int row;
    private int col;
    private int value;

    public Cell(int i, int j){
        this.row = i;
        this.col = j;
        this.value = 0;
    }

    public void display() {
        int digiCnt = value==0 ? 1 : (int)(Math.floor(Math.log10(value))+1);
        for(int i=0;i<4-digiCnt;i++)
            System.out.print(" ");
        System.out.print( (value==0 ? "-" : value ) + " ");
    }

    public boolean isEmpty() {
        return value==0;
    }
}
