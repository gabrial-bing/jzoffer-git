import java.nio.CharBuffer;

public class replaceSpace {
    public static String replaceSpace(StringBuffer str) {
        //先查看原字符串中空格的数量，每遇到一个空格，源字符串长度加2
        int p1=str.length()-1;
        for(int i=0;i <=p1;i++){
            if(str.charAt(i)==' ')
                str.append("  ");
        }

        int p2=str.length()-1; //此时字符串长度为添加之后的长度

        while(p1>=0 && p2>p1){
            char c = str.charAt(p1--);
            if(c == ' '){
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }
            else{
                str.setCharAt(p2--,c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str =new StringBuffer(" we are happy");
        //char[] str = new char[c.length()];
        replaceSpace(str);
        System.out.println(str);
    }
}
