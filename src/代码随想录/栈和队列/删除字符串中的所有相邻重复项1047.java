package 代码随想录.栈和队列;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 删除字符串中的所有相邻重复项1047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str=scanner.next();
        Solution1047 solution1047 = new Solution1047();
        System.out.println(solution1047.removeDuplicates(str));
    }
}
class Solution1047{
    public String removeDuplicates(String s){
        //删除两个相邻的字符
        Deque<Character> stack=new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()&&stack.peek()==c){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        StringBuilder builder=new StringBuilder();
        while (!stack.isEmpty()){
            builder.append(stack.pop());
        }
        String str=builder.toString();

        return builder.reverse().toString();
    }
}
