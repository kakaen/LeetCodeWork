package 滑动窗口算法.不定长窗口二刷;

import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长子串3 {
    public static void main(String[] args) {

    }
}
class Solution33 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int result=0;
        Map<Character, Integer> map = new HashMap<>();
        for (right = 0; right < s.length(); right++) {
            //准备向右扩展窗口
            char ch = s.charAt(right);
            while (map.containsKey(ch)){
                int  i = map.get(s.charAt(left));
                if (i==1){
                    map.remove(s.charAt(left));
                }else{
                    map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)+1);
                }
                left++;
            }
            map.put(ch,map.getOrDefault(ch,0)+1);
            //更新答案
            result=Math.max(result,right-left+1);
        }
        return result;
    }
}
