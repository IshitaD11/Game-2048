package org.example.game2048.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private int size;
    private List<List<Cell>> cells;
    private boolean containMax;
    private int maxVal;
    private List<Cell> emptyCells;

    public Board(int sz,int max){
        size = sz;
        maxVal = max;
        cells = new ArrayList<>();
        emptyCells = new ArrayList<>();
        for(int i=0;i<size;i++){
            cells.add(new ArrayList<>());
            for(int j=0;j<size;j++){
                cells.get(i).add(new Cell(i,j));
                emptyCells.add(cells.get(i).get(j));
            }
        }
    }

    public void displayBoard(){
        System.out.println("|--------------------------|");
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print("|");
                cells.get(i).get(j).display();
                System.out.print("|");
            }
            System.out.println();
            System.out.println("|--------------------------|");
        }
    }

    public int moveLeft() {
        int score = 0;
        for(int i = 0 ; i < size ; i++) {
            int j = 0;
            int k = 0;
            int prev = -1;
            for ( ; j < size; j++) {

                if(cells.get(i).get(j).getValue()==0) {
                    continue;
                }

                if(cells.get(i).get(j).getValue() == prev){
                    int new_val = cells.get(i).get(j).getValue() + prev;
                    cells.get(i).get(j).setValue(0);
                    cells.get(i).get(k-1).setValue(new_val);
                    score += new_val;
                    if(cells.get(i).get(k-1).getValue()==maxVal)
                        containMax = true;
                    prev = -1;
                }
                else{
                    int val = cells.get(i).get(j).getValue();
                    cells.get(i).get(j).setValue(0);
                    cells.get(i).get(k).setValue(val);
                    prev = val;
                    k++;
                }
            }
        }
        return score;
    }

    public void transpose() {
        for(int i=1;i<size;i++){
            for(int j=0;j<i;j++){
                int tempValue = cells.get(i).get(j).getValue();
                cells.get(i).get(j).setValue(cells.get(j).get(i).getValue());
                cells.get(j).get(i).setValue(tempValue);
            }
        }
    }

    public void reverse() {
//        System.out.println("before reverse");
//        displayBoard();
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size/2; j++) {
                int tempValue = cells.get(i).get(j).getValue();
                cells.get(i).get(j).setValue(cells.get(i).get(size-j-1).getValue());
                cells.get(i).get(size-j-1).setValue(tempValue);
            }
        }
//        System.out.println("After reverse");
//        displayBoard();
    }


    public boolean contains2048() {
        return containMax;
    }

    public boolean isEmptyCellExists() {
        return !emptyCells.isEmpty();
    }

    public void recalculateEmptyCells(){
        emptyCells = new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(cells.get(i).get(j).getValue()==0)
                    emptyCells.add(cells.get(i).get(j));
            }
        }
    }

}
