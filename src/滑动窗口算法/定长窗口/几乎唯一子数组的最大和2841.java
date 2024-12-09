package 滑动窗口算法.定长窗口;

import java.util.*;

public class 几乎唯一子数组的最大和2841 {
    public static void main(String[] args) {
        Solution2841 solution2841 = new Solution2841();
        Integer[] nu={1,1,1,3};int m=2;int k=2;
        List<Integer> list = Arrays.asList(nu);
        System.out.println(list.toString());
        System.out.println(solution2841.maxSum(list, m, k));

    }
}
class Solution2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        // m,k;
        //几乎唯一：至少有m个互不相同的元素，就称为几乎唯一的子数组
        int result=0;
        //判断窗口k中是否有m个互不相同的元素

        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        for (int i=0;i<nums.size();i++){
            //第一步进入窗口
            //存在问题：我如果连续两个进入了1，我set中存储的只有一个1
            //导致我移除的时候，直接移除完了
            map.put(nums.get(i),map.getOrDefault(nums.get(i),0)+1);
            count+=nums.get(i);
            //判断是否到达窗口值
            if (i<k-1){
                continue;
            }
            //第二步更新答案,如果当前窗口中不同元素的个数大于等于m，
            // 则可以更新答案
            if (map.keySet().size()>=m){
                result=Math.max(result,count);
            }
            //第三步，出窗口，
            if (map.get(nums.get(i-k+1))==1){
                map.remove(nums.get(i-k+1));
            }else {
                map.put(nums.get(i-k+1),map.get(nums.get(i-k+1))-1);
            }
            count-=nums.get(i-k+1);
        }
        return result;
    }
}