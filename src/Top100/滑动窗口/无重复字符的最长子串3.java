package Top100.滑动窗口;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class 无重复字符的最长子串3 {
    public static void main(String[] args) {
        无重复字符的最长子串3 test = new 无重复字符的最长子串3();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(test.lengthOfLongestSubstring("bbbbb"));
    }
    public int lengthOfLongestSubstring(String s){
        //找出不含有重复字符的最长子串的长度
        int n=s.length();
        int left=0,right=0;
        Set<Character> set=new HashSet<>(); //用一个set集合来记录滑动窗口中字符的数量
        char[] chars=s.toCharArray();
        int maxLen=0;
        for (right=0;right<n;right++){
            //判断窗口中是否存在chars[right]这个字符
            while (left<=right&&set.contains(chars[right])){
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);//加入窗口中。
            maxLen=Math.max(maxLen,right-left+1);
            }
        return maxLen;
        }
    }
