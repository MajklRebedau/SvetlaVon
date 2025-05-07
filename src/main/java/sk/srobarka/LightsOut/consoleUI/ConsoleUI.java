package sk.srobarka.LightsOut.consoleUI;

import sk.srobarka.LightsOut.core.Field;

import java.util.Scanner;

public class ConsoleUI {

    private Field field;
    private Scanner scanner;
    private boolean stop;
    private int attempts;

    public ConsoleUI (Field mainField)
    {
        this.field= mainField;
        this.scanner=new Scanner(System.in);
    }

    public void play ()
    {
        this.attempts=0;
        do
            {
                renderField();
                processInput();
            }
        while (!this.field.isSolved()&&!stop);
        renderField();
        if (this.field.isSolved())
        {
            System.out.print("Vyhral Si");
        }
    }

    public void renderField ()
    {
        String header=String.format("attempts: %02d state: %s", this.attempts, this.field.isSolved());
        System.out.print(header);
        for (var row=0; row<this.field.getRowCount(); row++)
        {
            for (var column=0; row<this.field.getColumnCount(); column++)
            {
                var light=this.field.getLight(row, column);
                System.out.print(light.isOn()? "📀":"💿");
            }
            System.out.println();
        }
    }
}