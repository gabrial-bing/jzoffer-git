/*
* 在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'。
* */
public class firstNotRepeatingChar {
    public static char firstNotRepeatingChar(String str) {
        char p='\0';
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            int n=0;
            for(int j=0;j<str.length();j++){
               if(str.charAt(j) == c){
                   n++;
               }
            }
            if(n==1){
                p=c;
                return p;
            }

        }
        return p;
    }

    public static void main(String[] args) {
        String str="aaccdebff";
        char c = firstNotRepeatingChar(str);
        System.out.println(c);
    }
}
