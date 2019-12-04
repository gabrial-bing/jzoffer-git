/*
* 数组中出现次数超过一半的数字！
* 题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
* 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
* */
public class mostNumbers {
    public static int MoreThanHalfNum_Solution(int [] array) {
        //int n = 0;
        int p = 0;
        for (int i = 0; i < array.length; i++) {
            int c = array[i];
            int n = 0;    //改位置
            for (int j = 0; j < array.length; j++) {
                if (array[j] == c) {
                    n++;
                }
            }
            //p = array[i];
            if (n > ((array.length ) / 2)) {
                p = array[i];//改位置
                break;
            }
           /* else{
                return p;
            }*/
        }
        return p;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1,2,4,4,2,5,5,2,3};
        int c=MoreThanHalfNum_Solution(array);
        System.out.println(c);
    }
}
