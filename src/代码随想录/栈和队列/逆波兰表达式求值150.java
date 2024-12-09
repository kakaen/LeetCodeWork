package 代码随想录.栈和队列;



import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 逆波兰表达式求值150 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        String[] tokens=new String[n];
        for (int i=0;i<n;i++){
            tokens[i]=scanner.next();
        }
        for (String token : tokens) {
            System.out.println(token);
        }
        Solution150 solution150 = new Solution150();
        int i = solution150.evalRPN(tokens);
        System.out.println(i);
    }
}
class Solution150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack=new ArrayDeque<>();
        for (String s:tokens){
            if ("+".equals(s)||"-".equals(s)||"*".equals(s)||"/".equals(s)){
                //当前字符是运算符，所以需要进行弹出栈中的两个元素
                int number2 = stack.pop();
                int number1 = stack.pop();
                if (s=="+"){
                    stack.push(number1+number2);
                } else if (s=="-") {
                    stack.push(number1-number2);
                } else if (s=="*") {
                    stack.push(number1*number2);
                }else {
                    stack.push(number1/number2);
                }
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}