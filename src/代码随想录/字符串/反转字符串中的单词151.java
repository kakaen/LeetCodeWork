package 代码随想录.字符串;

import java.util.Deque;
import java.util.LinkedList;

public class 反转字符串中的单词151 {
    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        System.out.println(solution151.reverseWords(" this is a apple "));
    }
}
class Solution151{
    public String reverseWords(String s){
        StringBuilder builder=new StringBuilder();
        s.trim(); //去除字符串的首尾中的空格字符
        int n=s.length();
        if (n==0||s.isEmpty()) return "";
        char[] arr=s.toCharArray();
        Deque<Character> stack=new LinkedList<>(); //栈
        int j=n-1;
        int i=j;
        while (j>=0){
            while (i>=0&&s.charAt(i)!=' ') i--;
            builder.append(s.substring(i+1,j+1)+" ");
            while (i>=0&&s.charAt(i)!=' ') i--;
            j=i;//找到下一个单词的开头
        }
        return builder.toString().trim();
    }
}
