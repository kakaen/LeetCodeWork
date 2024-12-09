package 动态规划算法.最大子数组和最大子段和;

public class 任意子数组和的绝对值的最大值1749 {
    public static void main(String[] args) {
        Solution1749 solution1749 = new Solution1749();
        int[] nums={2,-5,1,-4,3,-2};
        System.out.println(solution1749.maxAbsoluteSum2(nums));
    }
}
class Solution1749 {
    public int maxAbsoluteSum(int[] nums) {
        //dp[0]表示以当前num结尾的子数组的最大值，dp[1]代表最小值
        int[] dp=new int[2];
        int ans=0;
        for (int num:nums){
            //存储了dp[i-1]的值
            dp[0]=dp[0]>0?dp[0]+num:num;
            dp[1]=dp[1]<0?dp[1]+num:num;
            ans=Math.max(ans,Math.max(dp[0],-dp[1]));
        }
        return ans;
    }
    public int maxAbsoluteSum2(int[] nums){
       //该问题可以转换成求最大子数组和以及最小子数组和的绝对值，这二者中的最大值就是答案。
        int n=nums.length;
        int[] dpMax=new int[n+1];
        int max=Integer.MIN_VALUE;
        int[] dpMin=new int[n+1];
        int min=Integer.MAX_VALUE;
        dpMax[0]=dpMin[0]=0;
        for (int i=1;i<=n;i++){
            dpMax[i]=Math.max(dpMax[i-1],0)+nums[i-1];
            max=Math.max(max,dpMax[i]);
            dpMin[i]=Math.min(dpMin[i-1],0)+nums[i-1];
            min=Math.min(min,dpMin[i]);
        }
        return Math.max(Math.abs(max),Math.abs(min));
    }
}
