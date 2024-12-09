package Top100.栈;

import java.util.*;

public class 有效的括号20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("()"));
    }
}
class Solution20{
    public boolean isValid(String s){
        Deque<Character> stack=new LinkedList<>();
        char[] charArray = s.toCharArray();
        int n=charArray.length;
        if (n%2!=0) return false;
        Map<Character,Character> map=new HashMap<Character,Character>();
        map.put('[',']');
        map.put('{','}');
        map.put('(',')');
        for (int i=0;i<n;i++){
            if (map.containsKey(charArray[i])){
                stack.push(charArray[i]);
            }else{
                if (stack.isEmpty()||charArray[i]!=map.get(stack.peek())){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public boolean compareChar(char ch1,char ch2){
        if ((ch1=='('&&ch2==')')||(ch1=='{'&&ch2=='}')||(ch1=='['&&ch2==']')){
            return true;
        }
        return false;
    }
    public boolean isValid2(String s){
        int n=s.length();
        if (n==1) return false;
        Queue<Character> queue=new LinkedList<>();
        char[] charArray = s.toCharArray();
        for (int i=0;i<n;i++){
            if (charArray[i]=='('||charArray[i]=='{'||charArray[i]=='['){
                queue.add(charArray[i]);
            }else{
                if (queue.isEmpty()) return false;
                char ch= queue.poll();
                if (!isTrue(ch,charArray[i])) {
                    return false;
                }
            }
        }
        if (queue.isEmpty()) return true;
        return false;
    }
    public boolean isTrue(char ch,char ch2){
        if (ch2==')'){
            if (ch=='('){
                return true;
            }else{
                return false;
            }
        } else if (ch2=='}') {
            if (ch=='{'){
                return true;
            }else {
                return false;
            }
        } else if (ch2==']') {
            if (ch=='['){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}