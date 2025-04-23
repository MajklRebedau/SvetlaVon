package sk.srobarka.LightsOut.core;

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
    private void initField(){
        for(var row=0; row<this.rowCount; row++) {
            for (var column = 0; column < this.columnCount; column++) {
                lights[row][column] = new Light();

            }
        }
    }
}
