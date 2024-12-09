package 滑动窗口算法.定长窗口二刷;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 几乎唯一子数组的最大和2841 {
    public static void main(String[] args) {

    }
}
class Solution2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        //窗口长度为k
        int left=0,right=0;
        long result=0,count=0;
        //窗口
        Map<Integer,Integer> map=new HashMap<>();
        //枚举右边界
        for (right=0;right<nums.size();right++){
            //右边界入
            map.merge(nums.get(right),1,Integer::sum);
            count+=nums.get(right);
            if (right<k-1) continue;
            //更新答案
            if (map.size()>=m){
                result=Math.max(result,count);
            }
            //左边界出
            map.merge(nums.get(left),-1,Integer::sum);
            if (map.get(nums.get(left))==0){
                map.remove(nums.get(left));
            }
            count-=nums.get(left);
        }
        return result;
    }
}
