package ua.edu.donntu.cs.checkermoves;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: Александр
 * Date: 13.04.12
 * Time: 8:08
 * To change this template use File | Settings | File Templates.
 */
public class NotationTest {
    @Test
    public void testToObj()
    {
        Notation nt = new Notation();
        testList=nt.StringToObject(testStr2);
        testStr=nt.ObjectToString(testList);
        assertTrue("toObj failed",testStr.equals(testStr2));
        
    }
    @Test
    public void testToStr()
    {
        Notation nt = new Notation();
        initList();
        testStr=nt.ObjectToString(list2);
        assertTrue("toStr failed",testStr.equals(testStr2));
    }
    @Test
    public void test2()
    {
        Notation nt= new Notation();
        testList=nt.StringToObject(testStr1);
        testStr=nt.ObjectToString(testList);
        System.out.print(testStr);
        assertTrue("toObj failed",testStr.equals(testStr1));
    }
    public void initList()
    {
        list1.add(new char[] { 'e', '3'});
        list1.add(new char[] { 'd', '4' });
        testStep1=new Step(false,list1);
        list2.add(testStep1);
    }
    private ArrayList<char[]> list1 = new ArrayList<char[]>(2);
    private ArrayList<Step> list2 = new ArrayList<Step>(2);
    private ArrayList<Step> testList = new ArrayList<Step>(2);
    private String testStr1 = "e3-d4 g3-f4 c5:e3:g5";
    private String testStr2 = "e3-d4";
    private String testStr3 = "c5:e3:g5";
    private String testStr;
    private Step testStep1;
}
