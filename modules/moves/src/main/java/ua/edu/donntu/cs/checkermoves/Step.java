package ua.edu.donntu.cs.checkermoves;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Александр
 * Date: 24.03.12
 * Time: 9:01
 * To change this template use File | Settings | File Templates.
 */
public class Step {
    public Step( boolean fl, ArrayList<char[]> position)
    {
        move=position;
        taking=fl;
    }
    public  ArrayList<char[]> getStep()
    {
        return move;
    }
    public boolean getTaking()
    {
        return taking;
    }
    private ArrayList<char[]> move;
    private boolean taking;
}
