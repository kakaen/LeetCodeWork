package Top100二刷.滑动窗口.定长滑动窗口;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 无重复字符的最长子串3 {
    public static void main(String[] args) {
        无重复字符的最长子串3 test = new 无重复字符的最长子串3();
        System.out.println(test.lengthOfLongestSubsstring("abcabcbb"));
    }
    //
    public int lengthOfLongestSubstring2(String s){
      int left=0,right=0;
      int n=s.length();
      Set<Character> set=new HashSet<>();
      //扩展右边界
      for (right=0;right<n;right++){
          //当前考虑的元素
          if (set.contains(s.charAt(right)))
          while (left<=right&&check(set,s,right)){
              //扩展作边界
          }
      }
      return 0;
    }
    //如果set中存在index下标的元素就返回false
    public boolean check(Set<Character> set,String s,int index){
        return set.contains(s.charAt(index));
    }
    public int lengthOfLongestSubsstring(String s){
        //给你一个s字符串，找出其中不含重复字符的最长子串
        int left=0,right=0;
        int n=s.length();
        int ans=0;
        //滑动窗口进行存储。
        //存储对应的字符和下标
        Set<Character> set=new HashSet<>();
        for (right=0;right<n;right++){
            //将右侧压入Map集合中
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            //将右侧right压入集合中
            set.add(s.charAt(right));
            //满足了要求，进行更新操作
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}
