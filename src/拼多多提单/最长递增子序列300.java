package 拼多多提单;

public class 最长递增子序列300 {
    public int lengthOfLIS(int[] nums){
        //找出最长严格递增子序列
        if (nums.length==0) return 0;
        int n=nums.length;
        int[] dp=new int[n+1];// dp【i】表示以第i个数字结尾的最长上升子序列的长度
        //dp[i]=Max(dp[j])+1 num[j]<num[i]
        dp[0]=1;
        int maxans=1;
        for (int i=1;i<n;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j])+1;
                }
            }
            maxans=Math.max(dp[i], maxans);
        }
        return maxans;
    }
}
