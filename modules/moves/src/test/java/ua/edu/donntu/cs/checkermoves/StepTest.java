package ua.edu.donntu.cs.checkermoves;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: Александр
 * Date: 13.04.12
 * Time: 8:53
 * To change this template use File | Settings | File Templates.
 */
public class StepTest {
    @Test
    public void testTaking()
    {
        initStep();
        assertTrue("Taking test failed",testStep.getTaking() == false);
    }
    @Test
    public void testGetStep()
    {
        initStep();
        assertTrue("GetStep failed",testStep.getStep() == list1);
    }
    public void initStep()
    {
        list1.add(new char[] { 'e', '3'});
        list1.add(new char[] { 'd', '4' });
        testStep=new Step(false,list1);
    }
    private ArrayList<char[]> list1 = new ArrayList<char[]>(2);
    private Step testStep;
}
