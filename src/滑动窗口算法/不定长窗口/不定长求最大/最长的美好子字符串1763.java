package 滑动窗口算法.不定长窗口.不定长求最大;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最长的美好子字符串1763 {
    public static void main(String[] args) {

    }
}
class Solution1763 {
    public String longestNiceSubstring(String s) {
        //返回最长的子串
        int left=0,right;
        int result=0;
        //窗口定义，A，a出现，Bb都出现  A-Z：大写字母， a-z：小写字母 97-
        int[] windows=new int[128];
//        Map<Character,Integer> windows=new HashMap<>();
        for (right=0;right<s.length();right++){
            //把右边界入窗口
            char ch=s.charAt(right);
            windows[(int)ch]++;
            //判断窗口值是否符合，如过不符合，则缩减左侧指针，
            while (!isBeautiful(windows)){

            }

        }
        return "0";
    }
    //判断窗口是否满足美好子字符串的定义
    public boolean isBeautiful(int[] windows){
        //

        return false;
    }
}
