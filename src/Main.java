import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private int[] cnts=new int[256];   //int型数组:长度为256，默认值为0，0，0，0，0，0，0.......
    private Queue<Character> queue =new LinkedList<>();

    public  void Insert (char ch){
        cnts[ch]++;
        queue.add(ch);
        while(!queue.isEmpty() && cnts[queue.peek()] > 1)   // peek()方法：查看首个元素，不会移除首个元素，如果队列是空的就返回null
            queue.poll();   //poll()方法：将首个元素从队列中弹出，如果队列是空的，就返回null
    }
    public char FirstAppearingOnce(){
        return queue.isEmpty() ? '#' : queue.peek();
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        int[] cnts=new int[256];
        cnts['a']++;   //java中自动将'a'转换成97
        System.out.println(cnts['a']);

        Class c = Class.forName("firstNotRepeatingChar2");
        System.out.println("获取所有的公共的构造方法");
        Constructor[] constructors1 = c.getConstructors();
        Constructor[] constructors2 = c.getDeclaredConstructors();
        Constructor constructors3 =c.getConstructor(new Class[]{String.class,Integer.class,String.class});



        System.out.println(constructors1);
    }
}
