package Top100.动态规划.最大子数组的和;

public class 最大子数组和53 {
    public static void main(String[] args) {
        最大子数组和53 test = new 最大子数组和53();
        System.out.println(test.maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
    public int maxSubArray(int[] nums){
        //连续子数组，
        //dp[i]，表示以i为结尾的子数组的和
        int n=nums.length;
        int count=0;
        int max=Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            if (count>0){
                count+=nums[i];
            }else {
                count=nums[i];
            }
            max=Math.max(count,max);
        }
        return max;
    }
    //使用dp数组来实现
    public int maxSubArray2(int[] nums){
        //dp[i];表示以nums中第i个元素结尾的最大连续子数组之和
        //dp[i]的递推公式，如果前dp[i-1]>0的话，那dp[i]=dp[i-1]+nums[i]
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        int max=dp[0];
        for (int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    //求最大子数组的和
    public int maxSubArray3(int[] nums){
        int n=nums.length;
        int[] dp=new int[n]; //dp[i]表示前i个元素的最大子数组和
        //递推公式：dp[i]=Math.max(dp[i-1],0)+nums[i];
        dp[0]=nums[0];
        int ans=nums[0];
        for (int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1],0)+nums[i];
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
