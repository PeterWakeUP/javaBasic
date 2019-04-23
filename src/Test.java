import java.lang.reflect.Array;
import java.util.*;

public class Test {


    public static void main(String[] args){
        /*long sum = sum(20);
        System.out.println(sum);*/

        Vector<Integer> v = new Vector<>(100);
        Integer i = new Integer(1);
        v.addElement(i);
        v.addElement(i);

        System.out.println(v);

        Enumeration<Integer> elements = v.elements();

        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }


        List<String> list = new LinkedList<>();
        list.add("jkl");
        list.add("abc");
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals("abc")){
                iterator.remove();
            }
        }
        System.out.println(list);


        TreeSet<String> treeSet = new TreeSet<>();
    }



    public static long sum(int n){
        long sum = 0;
        for(int i=1; i<=n; i++){
            sum += jiecheng(i);
        }
        return sum;
    }


    public static long jiecheng(int n){
        long sum = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
        }
        return sum;
    }

}
