package Top100.动态规划.最大子数组的和;

import java.nio.charset.MalformedInputException;

public class 任意子数组和的绝对值的最大值1749 {
    public int maxAbsoluteSum(int[] nums){
        //任意子数组的和的最大值
        return 0;
    }
    public int maxAbsoluteSum2(int[] nums){
        //绝对值和最大，有两种考虑，一种是负数，一种是正数
        //创建dp[i]表示以第i个元素为结尾的最大和
        int n=nums.length;
        int[] dpMin=new int[n]; //记录最小的
        int[] dpMax=new int[n]; //记录最大的、
        dpMin[0]=nums[0];
        dpMax[0]=nums[0];
        //进行递推,dp[i]=
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i=1;i<n;i++){
            dpMin[i]=Math.min(dpMin[i-1],0)+nums[i];
            min=Math.min(min,dpMin[i]);
            dpMax[i]=Math.max(dpMax[i-1],0)+nums[i];
            max=Math.max(max,dpMax[i]);
        }
        return Math.max(Math.abs(max),Math.abs(min));
    }
    public int maxAbsoluteSum3(int[] nums){
        //分别求出子数组和的最大值和最小值
        int subMax=nums[0],subMin=nums[0];
        int max=subMax,min=subMin;
        int n=nums.length;
        for (int i=0;i<n;i++){
            subMax=Math.max(subMax,0)+nums[i];
            subMin=Math.min(subMin,0)+nums[i];
            max=Math.max(max,subMax);
            min=Math.min(min,subMin);
        }
        return Math.max(Math.abs(max),Math.abs(min));
    }
}
