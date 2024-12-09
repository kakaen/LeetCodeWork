package 滑动窗口算法.不定长窗口.不定长求最大;

import java.util.Arrays;

public class 最高频元素的频数1838 {
    public static void main(String[] args) {
        Solution1838 solution1838 = new Solution1838();
        int[] nums={1,4,8,13};int k=5;
        System.out.println(solution1838.maxFrequency(nums, k));
    }
}
class Solution1838 {
    public int maxFrequency(int[] nums, int k) {
        //最大可能频数，元素出现在该数组中的次数
        //将该下标的元素值加一：说明要加1
        //1.第一步先把数组进行排序
        Arrays.sort(nums);
        //2.第二步，枚举右端点，查看右端点对应的大值能否成为最高频数
        int left=0;
        int result=0;
        long sum=0;
        for (int right=0;right<nums.length;right++){
            sum+=nums[right];
            //什么时候需要扩张左边界
            while (sum+k<(right-left+1)*(long)nums[right]){
                //右移左边界
                sum-=nums[left];
                left++;
            }
            result=Math.max(result,right-left+1);
        }
        return result;
    }
}
