package Top100.栈;

import java.util.Deque;
import java.util.LinkedList;

public class 字符串解码394 {
    public static void main(String[] args) {

    }
}
class Solution394{
    public String decodeString(String s){
        char[] chars=s.toCharArray();
        //k[encoded_string]:string重复k次
        Deque<Character> stack=new LinkedList<>();
        StringBuilder builder=new StringBuilder();
        //当遇到]时，从栈中弹出字符串及其重复的次数。
        int n=chars.length;
        for (int i=0;i<n;i++){
            if (chars[i]!=']'){
                stack.push(chars[i]);
            }else{
                String str="";

            }
        }
        for (int i=n-1;i>=0;i--){

        }
        return "";
    }
}
