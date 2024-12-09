package Top100;

import 卡玛周赛.哈沙德数3099;

import java.util.*;

public class 找到字符串中所有字母异位词438 {
    public static void main(String[] args) {
        Solution438 solution438 = new Solution438();
        List<Integer> anagrams = solution438.findAnagrams("baa", "aa");
        for (Integer anagram : anagrams) {
            System.out.print(anagram+" ");
        }
    }
}
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        int[] str=new int[27]; //存储s字符串的hash表
        int[] subStr=new int[27]; //存储p字符串的hash表
//        for (char ch:s.toCharArray()){
//            str[ch-'a']++;
//        }
        for (char ch:p.toCharArray()){
            subStr[ch-'a']++;
        }
        //滑动窗口
        int left=0,right=0;
        for (right=0;right<s.length();right++){
            //右边界入窗口
            char ch=s.charAt(right);
            str[ch-'a']++;
            //
            if (right<p.length()-1) continue;
            //判断当前窗口是否满足
            if (Arrays.equals(str,subStr)){
                result.add(left);
            }
            //左边界收缩
            str[s.charAt(left)-'a']--;
            left++;
        }
        return result;
    }

    /**
     *
     * 判断窗口是否为异位词

     */

//    private boolean needShrink(Map<Character,Integer> windows, Set<Character> hset) {
//        //需要缩小窗口的意思就是，其中的元素已经满足异位词，但存在其他元素
//        for (Character ch:windows.keySet()){
//            if (!hset.contains(ch)){
//                return true;
//            }
//        }
//        return false;
//    }

}
