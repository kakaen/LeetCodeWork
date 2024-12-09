package 滑动窗口算法.不定长窗口.不定长求最大;

import 贪心算法.监控二叉树968;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 删除子数组的最大得分1695 {
    public static void main(String[] args) {
        Solution1695 solution1695 = new Solution1695();
        int[] arr={4,2,4,5,6};
        int[] arr1={5,2,1,2,5,2,1,2,5};
        System.out.println(solution1695.maximumUniqueSubarray(arr1));
    }
}
class Solution1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int result=0;
        int left=0,right=0;
        int sum=0; //代表窗口值,且窗口值不能有重复值
        //存放下标
        Map<Integer,Integer> windos=new HashMap<>();
        for (right=0;right<nums.length;right++){
            //右边界先进
            sum+=nums[right];
            //如果存在该下标，则需要将left扩到
            if (windos.containsKey(nums[right])){
                while (left<=windos.get(nums[right])){
                    sum-=nums[left];
                    left++;
                }
            }
            windos.put(nums[right],right);
            result=Math.max(result,sum);
        }
        return result;
    }
    public int maximumUniqueSubarray2(int[] nums){
        int sum=0;
        int result=0;
        int left=0,right=0;
        Set<Integer> set=new HashSet<>();
        for (right=0;right<nums.length;right++){
            //判断hashset中是否存在要加入的元素
            while (set.contains(nums[right])){
                //从左往右进行缩小边界，直到可以满足
                sum-=nums[left];
                set.remove(nums[left]);
                left++;
            }
            //可以接收当前的元素了
            sum+=nums[right];
            set.add(nums[right]);
            //更新答案
            result=Math.max(result,sum);
        }
        return result;
    }
}
