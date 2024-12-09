package Top100二刷;

import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串76 {
    public String minWindow(String s,String t){
        //返回s中覆盖t所有字符的最小子串
        Map<Character,Integer> map=new HashMap<>();
        int[] table=new int[26];
        //将t字符串映射为map集合
        for (char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        //
        char[] chars=s.toCharArray();
        int left=0;
        Map<Character,Integer> sMap=new HashMap<>();
        String minStr="";
        for (int right=0;right<chars.length;right++){
            //右边界入窗口
            char ch=chars[right];
            //我们只入
            if (map.containsKey(ch)){
                Integer i = map.get(ch);
                i--;
                map.put(ch,i);
            }
            //如何判断是否都入队了
            //如果当前右边界已经满足了覆盖t字符串的要求，则右移左指针。来优化最小值
            //将窗口的左边界进行友谊，右移出现的可能情况，一是该字符不是t，二是该字符是t中的但是依然为负数
            while (!map.containsKey(chars[left])||map.get(chars[left])<0){
                if (map.containsKey(chars[left])){
                    map.put(chars[left],map.get(chars[left])+1);
                }
                left++;
                if (minStr==null||(right-left+1)<minStr.length()){
                    minStr=s.substring(left,right+1);
                }
            }
        }
        return minStr;
    }

    public static void main(String[] args) {
        最小覆盖子串76 test = new 最小覆盖子串76();
        System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));
    }
}