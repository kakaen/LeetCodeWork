package Top100.栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 从字符串中移除型号2390 {
    public static void main(String[] args) {
        Solution2390 solution2390 = new Solution2390();
        Scanner scanner = new Scanner(System.in);
        String s= scanner.next();
        System.out.println(solution2390.removeStars(s));
    }
}
class Solution2390{
    public String removeStars(String s){
        char[] chars = s.toCharArray();
//        Deque<Character> stack=new LinkedList<>();
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='*'&&!(builder.length()==0)){
//                stack.pop();
                builder.deleteCharAt(builder.length()-1);
            }else {
//                stack.push(chars[i]);
                builder.append(chars[i]);
            }
        }
        return builder.toString();
    }
}
