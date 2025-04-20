package 单调栈.单调栈二刷;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 有效的括号20 {
    public static void main(String[] args) {
        有效的括号20 test = new 有效的括号20();
        System.out.println(test.isValid("()"));
        System.out.println(test.isValid("()[]{}"));
        System.out.println(test.isValid("(]"));
    }
    public boolean isValid(String s) {
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');map.put('[',']');map.put('{','}');
        Stack<Character> stack=new Stack<>();
        char[] charArray = s.toCharArray();
        for (char ch:charArray){
            if (map.containsKey(ch)){
                stack.push(ch);
            }else{

            }
            if(ch=='('||ch=='{'||ch=='['){
                stack.push(ch);
            }else{
                if (stack.isEmpty()||map.get(stack.peek())!=ch){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
