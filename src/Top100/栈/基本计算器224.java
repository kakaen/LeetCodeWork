package Top100.栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class 基本计算器224 {
    public int calculate(String s){
        //不可以使用任何将
        Deque<String> numberStack=new LinkedList<>(); //数字栈
        Deque<Character> operationStack=new LinkedList<>(); //操作数栈
        s=s.replaceAll(" ",""); //去除所有的空格
        int n=s.length();
        char[] chars=s.toCharArray();
        for (int i=0;i<n;i++){
            char ch=chars[i];
            if (isNumber(ch)&&isNumber(s.charAt(i))){

            }
        }
        return 0;
    }
    public boolean isNumber(char ch){
        return ch>='0'&&ch<='9';
    }
}
