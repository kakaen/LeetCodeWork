package 滑动窗口算法.定长窗口二刷;

import java.util.Arrays;
import java.util.Map;

public class 学生分数的最小差值1984 {
    public static void main(String[] args) {

    }
}
class Solution1984 {
    public int minimumDifference(int[] nums, int k) {
        int left=0,right=0;
        //任选k个学生的分数
        int result=Integer.MAX_VALUE;
        int count=0;
        //先排序
        Arrays.sort(nums);
        for (right=0;right<nums.length;right++){
            //入窗口，right
            if (right<k-1) continue;
            //更新答案
            count=nums[right]-nums[right-k+1];
            result= Math.min(count,result);
            //出窗口
        }
        return result;
    }
}
