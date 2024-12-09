package Top100.栈;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 有效的括号20II {
//    public static final Map<Character,Character> map=new HashMap<Character,Character>(){{
//        map.put('(',')');
//        map.put('{','}');
//        map.put('[',']');
//    }};

    public static void main(String[] args) {
        String s="()";
        有效的括号20II test = new 有效的括号20II();
        System.out.println(test.isValid(s));
        System.out.println(test.isValid("()[]{}"));
        System.out.println(test.isValid("(]"));
        System.out.println(test.isValid("([{}]){}"));
    }
    public boolean isValid(String s){
        return false;
    }
    public boolean isValid2(String s){
        Map<Character,Character> pair=new HashMap<>();
        Deque<Character> deque=new LinkedList<>();
        pair.put(')','(');pair.put(']','[');pair.put('}','{');
        int n=s.length();
        for (int i=0;i<n;i++){
            char ch=s.charAt(i);
            if (pair.containsKey(ch)){
                if (deque.isEmpty()||deque.peek()!=pair.get(ch)){
                    return false;
                }
                deque.pop();
            }else {
                deque.push(ch);
            }
        }
        return deque.isEmpty();
    }
}
