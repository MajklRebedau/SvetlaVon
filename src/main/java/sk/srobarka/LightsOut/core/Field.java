package sk.srobarka.LightsOut.core;

import java.util.Random;

public class Field {

    private int rowCount;
    private int columnCount;
    private Light[][] lights;

    public Field(int rowCount, int columnCount, int difficulty){
        this.rowCount=rowCount;
        this.columnCount=columnCount;
        this.lights = new Light[rowCount][columnCount];

        generate(difficulty);
    }

    private void generate(int moves){
        initField();
        shuffle(moves);
    }

    private void shuffle (int moves)
    {
        var random= new Random();
        for (var move=0; move<moves; move++)
        {
            var row=random.nextInt(rowCount);
            var column=random.nextInt(columnCount);
            toggleLights(row, column);
        }
    }

    public void toggleLights (int row, int column)
    {
        this.lights[row][column].toggle();
        if (row>0)
        {
            this.lights[row-1][column].toggle();
        }
        if (row<this.rowCount-1)
        {
            this.lights[row+1][column].toggle();
        }
        if (column>0)
        {
            this.lights[row][column-1].toggle();
        }
        if (column<this.columnCount-1)
        {
            this.lights[row][column+1].toggle();
        }
    }

    public int getRowCount ()
    {
        return this.rowCount;
    }

    public int getColumnCount ()
    {
        return this.columnCount;
    }

    public Light getLight (int row, int column)
    {

    }

    private void initField(){
        for(var row=0; row<this.rowCount; row++) {
            for (var column = 0; column < this.columnCount; column++) {
                lights[row][column] = new Light();

            }
        }
    }
}
