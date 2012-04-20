package ua.edu.donntu.cs.checkermoves;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Александр
 * Date: 23.03.12
 * Time: 8:48
 * To change this template use File | Settings | File Templates.
 */
public class Notation {
    public Notation()
    {

    }
    public ArrayList<Step> StringToObject(String str)
    {
        String buf;
        ArrayList<Step> st = new ArrayList<Step>();
        ArrayList<char[]> steps = new ArrayList<char[]>();
        boolean fl;
        int startindex,endindex,colstep,k;
        endindex=0;
        startindex=endindex;
        endindex=str.indexOf(" ",startindex);
        while(endindex!=-1)
        {
        buf=str.substring(startindex, endindex);
        colstep=(buf.length()+1)/3;
        fl=(buf.charAt(2)==':');
        k=0;
        for(int i=0;i<colstep;i++)
        {
            steps.add(buf.substring(k,k+2).toCharArray());
            k+=3;
        }
        st.add(new Step(fl, (ArrayList<char[]>)steps.clone()));
        steps.clear();
        startindex=endindex+1;
        endindex=str.indexOf(" ",startindex);
        }
        endindex=str.length();

        buf=str.substring(startindex, endindex);
        colstep=(buf.length()+1)/3;
        fl=(buf.charAt(2)==':');
        k=0;
        for(int i=0;i<colstep;i++)
        {
            steps.add(buf.substring(k,k+2).toCharArray());
            k+=3;
        }
        st.add(new Step(fl, (ArrayList<char[]>)steps.clone()));
        return st;
    }
    public String ObjectToString(ArrayList<Step> steps)
    {
        StringBuilder st= new StringBuilder();
        Step step;
        ArrayList<char[]> buf;
        while (!steps.isEmpty())
        {
            step=steps.get(0);
            steps.remove(0);
            buf=step.getStep();
            while(!buf.isEmpty())
            {
                st.append(buf.get(0));
                buf.remove(0);
                if(!buf.isEmpty())
                {
                    if(step.getTaking())
                        st.append(":");
                    else
                        st.append("-");
                }
            }
            st.append(" ");
        }
        if(st.length()!=0)
            st.deleteCharAt(st.length()-1);
        return st.toString();
    }
    private static String testStr1 = "e3-d4 g3-f4 c5:e3:g5";
    private static ArrayList<Step> testList = new ArrayList<Step>(2);
}
