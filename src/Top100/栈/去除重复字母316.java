package Top100.栈;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 去除重复字母316 {
    public static void main(String[] args) {

    }
}
class Solution316{
    public String removeDuplicateLetters(String s){
     //如何去除一个字符，使字符串字典序最小，找出最小的满足 s[i]>s[i+1]的下标，去除s[i]
        //使用单调栈来维护去除关键字后，如果栈顶字符大于当前字符s[i]，说明栈顶字符为关键字符，应该被去除
        int[] num=new int[26];
        for (char ch:s.toCharArray()){
            num[ch-'a']++;
        }
        boolean[] vis=new boolean[26];
        Deque<Character> stack=new LinkedList<>();
        for (char ch:s.toCharArray()){
            if (!vis[ch-'a']){

            }
        }
        return "";
    }
}
