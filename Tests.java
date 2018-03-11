import java.util.ArrayList;

public class Tests
{
    public static void main(String[] args)
    {
        ArrayList myArrList = new ArrayList();
        myArrList.add("Hello!");
        myArrList.add(1);
        myArrList.add(1.5f);
        System.out.println("Размер списка = " + myArrList.size());
        System.out.println(myArrList.toString());
        System.out.println(myArrList.get(0));
        System.out.println(myArrList.get(1));
        System.out.println(myArrList.get(2));
    
        System.out.println();
        
        ArrayList<String> myArrList2 = new ArrayList<String>();
        myArrList2.add("First line.");
        myArrList2.add("The second line.");
        System.out.println("Размер списка = " + myArrList2.size());
        System.out.println(myArrList2.toString());
        for (String s : myArrList2)
        {
            System.out.println(s);
        }
        System.out.println("\"The second line.\" is at " + myArrList2.indexOf("The second line."));
    }
}


