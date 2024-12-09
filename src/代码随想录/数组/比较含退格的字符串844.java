package 代码随想录.数组;

import java.util.Deque;
import java.util.LinkedList;

public class 比较含退格的字符串844 {
    public static void main(String[] args) {
        Solution844 solution844 = new Solution844();
        System.out.println(solution844.backspaceCompare("ab##", "c#d#"));
    }
}
class Solution844{
    public boolean backspaceCompare(String s,String t){
        Deque<Character> stack1=new LinkedList<>();
        StringBuilder builder=new StringBuilder();
        for (char ch:s.toCharArray()){
            if (ch=='#'&&builder.length()!=0){
                builder.deleteCharAt(builder.length()-1);
            }else {
                builder.append(ch);
            }
        }
        String newS=builder.toString();
        builder.delete(0,builder.length());
        for (char ch:t.toCharArray()){
            if (ch=='#'&&builder.length()!=0){
                builder.deleteCharAt(builder.length()-1);
            }else if (ch!='#'){
                builder.append(ch);
            }
        }
        String newT=builder.toString();
       return newS.equals(newT);
    }
    public boolean backspaceCompare2(String s,String t){
        int i=s.length()-1;
        int j=s.length()-1;
        int skipS=0;
        int skipT=0;
        while (i>=0||j>=0){
            while (i>=0){
                if (s.charAt(i)=='#'){
                    skipS++;
                    i--;
                } else if (skipS>0) {
                    skipS--;
                    i--;
                }else {
                    break;
                }
            }
            while (j>=0){
                if (t.charAt(j)=='#'){
                    skipT++;
                    j--;
                } else if (skipT>0) {
                    j--;
                }else {
                    break;
                }
            }
            if (i>=0&&j>=0){
                if (s.charAt(i)!=t.charAt(j)) return false;
            }else{
                if (i>=0||j>=0){
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
