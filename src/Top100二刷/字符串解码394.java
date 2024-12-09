package Top100二刷;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class 字符串解码394 {
    public static void main(String[] args) {
        字符串解码394 test = new 字符串解码394();
        System.out.println(test.decodeString("3[a2[c]]"));
        System.out.println(test.decodeString("30[a]").length());
        System.out.println(test.decodeString("3[a]2[bc]"));
    }
    public String decodeString(String s){
        Deque<String> stack=new ArrayDeque<>();//创建一个栈
        StringBuilder builder=new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i=0;i<charArray.length;i++){
            if (charArray[i]!=']'){
                stack.push(String.valueOf(charArray[i]));
            }else{
                //遇到]需要弹出栈内的元素
                StringBuilder builder2=new StringBuilder();
                while (!"[".equals(stack.peek())){
                    String str = stack.pop();
                    builder2.append(str);
                }
                stack.pop(); //弹出[
//                String num = stack.pop(); //弹出数字元素,这个部分存在问题，如果数字占多个位数呢？
                int n=0;int flag=0;
                while (!stack.isEmpty()&&stack.peek().charAt(0)>='0'&&stack.peek().charAt(0)<='9'){
                    n=n+(stack.pop().charAt(0)-'0')*(int)Math.pow(10,flag);
                    flag++;
                }

                String str=builder2.toString();
                builder2.delete(0,builder2.length());
                for (int j=0;j<n;j++){
                    builder2.append(str);
                }
                stack.push(builder2.toString());
            }
        }
        while (!stack.isEmpty()){
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }
    public String decodeString2(String s){
        char[] charArray = s.toCharArray();
        Deque<Character> stack=new ArrayDeque<>();
        Deque<String> stack2=new ArrayDeque<>();
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<charArray.length;i++){
            if (charArray[i]!='['){
                stack.push(charArray[i]);
            }else{
                //
                StringBuilder builder2=new StringBuilder();
                while (stack.peek()!='['){
                    builder2.append(stack.pop());
                }
                //弹出[
                stack.pop();
                //准备弹出数字
                int num=0;
                while (stack.peek()>='0'&&stack.peek()<='9'){
                    num=num*10+stack.pop()-'0';
                }
                for (int j=0;j<num;j++){
                    builder.append(builder2.toString());
                }
            }
        }
        return null;
    }
    //对于嵌套的来说,需要从内到外来生成字符串，当c为[时
    public String decodeString3(String s){
        StringBuilder res=new StringBuilder();
        LinkedList<Integer> stack_multi=new LinkedList<>();
        LinkedList<String> stk_res=new LinkedList<>();
        int multi=0;
        LinkedList<String> stack_list=new LinkedList<>();
        for (Character ch:s.toCharArray()){
            if (ch=='['){

            } else if (ch==']') {
                StringBuilder tmp=new StringBuilder();
                int cur_multi=stack_multi.removeLast();
                for (int i=0;i<cur_multi;i++){
                    res=new StringBuilder(stk_res.removeLast()+tmp);
                }
            }
        }
        return null;
    }
}
