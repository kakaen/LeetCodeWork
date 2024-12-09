package Top100.栈;

import java.util.Deque;
import java.util.LinkedList;

public class 逆波兰表达式求值150 {
    public static void main(String[] args) {
        逆波兰表达式求值150 test = new 逆波兰表达式求值150();
        String[] strs=new String[]{"10","6","9","3","+",
                "-11","*","/","*","17","+","5","+"};
        System.out.println(test.evalPRN(strs));
    }
    public int evalPRN(String[] tokens){
        //tokens作为字符串数组
        Deque<Integer> numStack=new LinkedList<>();
        for (String str:tokens){
            if ("+".equals(str)||"-".equals(str)||"*".equals(str)||"/".equals(str)){
                int num2=numStack.poll();
                int num1=numStack.poll();
                if ("+".equals(str)){
                    numStack.push(num1+num2);
                } else if ("-".equals(str)) {
                    numStack.push(num1-num2);
                } else if ("*".equals(str)) {
                    numStack.push(num1*num2);
                }else if ("/".equals(str)){
                    numStack.push(num1/num2);
                }
            }else{
                numStack.push(Integer.valueOf(str));
            }
        }
        return numStack.poll();
    }
}
