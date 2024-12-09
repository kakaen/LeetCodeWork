package 滑动窗口算法.不定长窗口;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串3 {
    public static void main(String[] args) {

    }
}
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        //转换成char[]加
        char[] arr=s.toCharArray();
        int n=s.length(),ans=0,left=0;
        HashSet<Character> set=new HashSet<>();
        for (int right=0;right<n;right++){
            char ch=arr[right];
            //如果窗口中已经存在了ch，再加一个ch会导致窗口内有重复元素
            boolean[] has=new boolean[128];
            while(has[ch]){
                //窗口内已经存在了ch
                has[arr[left++]]=false;//缩小窗口，直到该窗口中的值全部出
            }
            //直到去除has中相同的ch字符
            has[ch]=true;
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
    public int lengthOfLongestSubstring2(String s) {
        int left=0,right=0;
        int ans=0;
        char[] arr=s.toCharArray();
        Set<Character> set=new HashSet<>();
        for (right=0;right<arr.length;right++){
            char ch=arr[right];
            //如果窗口中存在该元素
            while (set.contains(ch)){
                set.remove(arr[left]);
                left++;
            }
            //当前窗口中 不存在ch了
            set.add(ch);
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}
