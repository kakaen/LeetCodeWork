package 滑动窗口算法.不定长窗口.不定长求最大;

import java.util.HashMap;
import java.util.Map;

public class 最多k个重复元素的最长子数组2958 {
    public static void main(String[] args) {
        Solution2958 solution2958 = new Solution2958();
        int[] nums=new int[]{1,2,1,2,1,2,1,2};
        int k=1;
        System.out.println(solution2958.maxSubarrayLength(nums,k));
    }
}
class Solution2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int left=0,right=0;
        int result=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (right=0;right<nums.length;right++){
            //判断是否可以进入窗口
            //如果nums[i]的值大于了k
            while (map.containsKey(nums[right])&&(map.get(nums[right])>k)){
                //左侧缩小窗口
                if (map.get(nums[left])==1){
                    map.remove(nums[left]);
                }else{
                    map.put(nums[left],map.get(nums[left])-1);
                }
                left++;

            }
            //将right入窗口,更新答案值
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            result=Math.max(right-left+1,result);
        }
        return result;
    }
}
