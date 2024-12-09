package Top100二刷;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 无重复字符的最长子串3 {
    public int lengthOfLongestSubstring(String s){
        //找出不含有重复字符的最长子串的长度
        int n=s.length();
        //作为窗口来判断当前值是否重复
        Set<Character> set=new HashSet<>();
        int left=0;
        int maxLen=0;
        char[] chars=s.toCharArray();
        for (int right=0;right<n;right++){
            //判断当前窗口是否存在right的值
            while (set.contains(chars[right])){
                set.remove(chars[left]);
                left++;
            }
            //当前窗口不存在right指针指向的字符，可以将right指向的字符加入窗口
            set.add(chars[right]);
            //更新结果值
            maxLen= Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}
