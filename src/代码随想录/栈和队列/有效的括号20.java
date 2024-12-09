package 代码随想录.栈和队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 有效的括号20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str=scanner.next();
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid(str));
    }
}
class Solution20{
    public char[] charMap=new char[]{'(','{','['};
    public boolean isValid(String s){
        Deque<Character> stack=new ArrayDeque<>();
      for (int i=0;i<s.length();i++){
          if (s.charAt(i)=='('){
              stack.push(')');
          } else if (s.charAt(i)=='{') {
              stack.push('}');
          }else if (s.charAt(i)=='['){
              stack.push(']');
          } else if (stack.isEmpty()||stack.peek()!=s.charAt(i)) {
              return false;
          }else {
              stack.pop();
          }
      }
      return stack.isEmpty();
    }
}
