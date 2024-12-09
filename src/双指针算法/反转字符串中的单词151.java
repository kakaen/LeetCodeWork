package 双指针算法;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 反转字符串中的单词151 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        Solution151 solution151 = new Solution151();
        System.out.println(solution151.reverseWords(string));
    }
}
class Solution151 {
    public String reverseWords(String s) {
        StringBuilder builder=new StringBuilder();
        s.trim(); //去除首尾空格
        Deque<String> stack=new ArrayDeque<>();
        int j=0;
        for (int i=0;i<s.length();){

            while (j<s.length()&&s.charAt(j)!=' '){
                j++;
            }
            stack.push(s.substring(i,j+1));
            while (s.charAt(j)==' '){
                j++;
            }
            i=j; //找到下一个不为0的下标
        }
        while (!stack.isEmpty()){
            builder.append(stack.pop()+" ");
        }
        return builder.toString().trim();
    }
}
