package Top100.动态规划;

public class 打家劫舍198 {
    public int rob(int[] nums){
        int n=nums.length;
        if (n==1) return nums[0];
        int[] dp=new int[n]; //dp[i]表示到第i家可以获取到的最大金额
        //偷取到第i家的dp[i]来自两个方向，
        //dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1])
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<n;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
}
