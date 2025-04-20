package 单调栈.单调栈二刷;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 字符串解码394 {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stackNum=new Stack<>(); //存储需要重复字符串的数字
        Stack<String> stackString=new Stack<>(); //存储待重复的字符串
        //存储当前待重复的字符串
        StringBuilder builder=new StringBuilder();
        int multi=0;
        for (char ch:chars){
            //如果是数字的话
            if (Character.isDigit(ch)){
                multi=multi*10+ch-'0';
            } else if (ch=='[') {
                //说明是新一个待重复的字符串嵌套
                stackNum.push(multi);
                multi=0;
                stackString.push(builder.toString());
                builder=new StringBuilder();
            } else if (ch>='a'&&ch<='z') {
                builder.append(ch);
            }else if(ch==']'){
                //需要进行计算本次的重复字符
                int curNum=stackNum.pop();
                String curStr=builder.toString();
                StringBuilder temp=new StringBuilder();
                for (int i=0;i<curNum;i++){
                    temp.append(curStr);
                }
                String nextStr=stackString.pop();
                builder=new StringBuilder(nextStr+temp.toString());
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        字符串解码394 test = new 字符串解码394();
        System.out.println(test.decodeString("3[a]2[bc]"));
        System.out.println(test.decodeString("3[a2[c]]"));
        System.out.println(test.decodeString("2[abc]3[cd]ef"));
    }
    public String decodeString2(String s){
        Deque<Integer> stackNum=new LinkedList<>();
        Deque<String> stackString=new LinkedList<>();
        int multi=0;
        StringBuilder builder=new StringBuilder();
        for (char ch:s.toCharArray()){
            if (Character.isDigit(ch)){
                multi=multi*10+ch-'0';
            } else if (ch=='[') {
                //说明进入了下一个要重复的元素，因为可能存在循环嵌套的问题
                stackNum.push(multi);
                multi=0;
                stackString.push(builder.toString()); //将上一个未处理完的字符串存储到栈中
                builder=new StringBuilder();
            } else if (ch>='a'&&ch<='z') {
                builder.append(ch);
            } else if (ch==']') {
                //计算当前的重复元素
                int curNum=stackNum.pop();
                StringBuilder temp=new StringBuilder();
                for (int i=0;i<curNum;i++){
                    temp.append(builder);
                }
                String preStr=stackString.pop(); //上一个未处理的重复字符串
                builder.append(preStr+temp.toString());
            }
        }
        return builder.toString();
    }
    public String decodeString3(String s){
        Stack<String> stack=new Stack<>();
        StringBuilder builder=new StringBuilder();
        char[] chars=s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (chars[i]!=']'){
                stack.push(String.valueOf(chars[i]));
            }else{
                //需要弹出栈内的元素
                StringBuilder builder2=new StringBuilder();
                while (!stack.isEmpty()&&!"[".equals(stack.peek())){
                    builder2.append(stack.pop());
                }
                stack.pop(); //弹出'['
                //再弹出要重复的次数
                int sum=0;
                int bei=1;
                while (!stack.isEmpty()&&stack.peek().charAt(0)>='0'&&stack.peek().charAt(0)<='9'){
                    sum=sum+(stack.pop().charAt(0)-'0')*bei;
                    bei=bei*10;
                }
                //进行计算重复字符串
                String str=builder2.toString();
                StringBuilder temp=new StringBuilder();
                for (int k=0;k<sum;k++){
                    temp.append(str);
                }
                stack.push(temp.toString());
            }
        }
        while(!stack.isEmpty()){
            builder.append(stack.pop());
        }
        return null;
    }
}
