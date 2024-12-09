package 滑动窗口算法.不定长窗口.不定长求最大;

import java.util.*;

public class 绝对差不超过限制的最长连续子数组1438 {
    public static void main(String[] args) {
        Solution1438 solution1438 = new Solution1438();
        int[] nums={8,2,4,7};int limit=4;
        System.out.println(solution1438.longestSubarray(nums, limit));
    }
}
class Solution1438 {
    public int longestSubarray(int[] nums, int limit) {
        //任意两个元素之间的绝对差必须小于或等于limit
        //返回最长连续子数组的长度,子数组之间的绝对值差必须小于或等于limit
        int left=0;
        int right;
        int result=0;
        //窗口，求最大绝对值误差
        List<Integer> windows=new ArrayList<>();
        //使用TreeMap进行查找最大值和最小值
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        //子数组中的任意两个元素之间的绝对差必须小于或等于limit
        for(right=0;right<nums.length;right++){
            treeMap.put(nums[right],treeMap.getOrDefault(nums[right],0)+1);
            //如果最大绝对值误差大于limit，则调整左边界
            while (treeMap.lastKey()-treeMap.firstKey() >limit){
                //左边界的值进行缩小
               treeMap.put(nums[left],treeMap.get(nums[left])-1);
               if (treeMap.get(nums[left])==0){
                   treeMap.remove(nums[left]);
               }
                left++;
            }
            //更新答案
            result= Math.max(result,right-left+1);
        }
        return result;
    }
    //计算窗口的最大绝对值差
    public int maxAbs(List<Integer> list){
        //这里会把数组的顺序修改掉
        int min=list.get(0);
        int max=list.get(0);
        for (Integer number : list) {
            if (number>max) max=number;
            if (number<min) min=number;
        }
        return Math.abs(max-min);
    }
}