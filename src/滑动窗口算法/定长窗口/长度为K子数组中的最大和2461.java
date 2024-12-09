package 滑动窗口算法.定长窗口;

import java.util.HashMap;
import java.util.Map;

public class 长度为K子数组中的最大和2461 {
}
class Solution2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        long result=0;
        //长度为k，所有元素各部相同
        long count=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            count+=nums[i];
            if (i<k-1) continue;
            //更新答案
            if (map.keySet().size()==k){
                result=Math.max(result,count);
            }
            //3.出窗口
            if (map.get(nums[i-k+1])==1){
                map.remove(nums[i-k+1]);
            }else{
                map.put(nums[i-k+1],map.get(nums[i-k+1])-1);
            }
            count-=nums[i-k+1];
        }
        return result;
    }
}