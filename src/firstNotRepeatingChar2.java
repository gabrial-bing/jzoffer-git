import java.util.LinkedList;
import java.util.Queue;
/*
* 在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'。
* */
//标准方法？？？？？没学会呢
public class firstNotRepeatingChar2 {
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

    public static void main(String[] args) {
        int[] cnts=new int[256];
        cnts['a']++;   //java中自动将'a'转换成97
        System.out.println(cnts['a']);

    }
}
