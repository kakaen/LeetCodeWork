package Top100二刷.动态规划;

public class 打家劫舍198 {
    public int rob(int[] nums){
        //dp[i]表示偷到第i个房间的最大金额
        int n=nums.length; //共有n个房间
        if (n==1) return nums[0];
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        //dp[i]=Math.max(dp[]) 第i间房间不偷拿dp[i]=dp[i-1],第i间房间偷dp[i]=nums[i]+dp[i-2];
        for (int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
    //对空间进行压缩
    public int rob2(int[] nums){
        int n=nums.length;
        if (n==1) return nums[0];
        int first=nums[0];
        int second=Math.max(nums[0],nums[1]);

        for (int i=2;i<n;i++){
            int count=Math.max(first+nums[i],second);
            first=second;
            second=count;
        }
        return second;
    }

    public static void main(String[] args) {
        打家劫舍198 test = new 打家劫舍198();
        System.out.println(test.rob2(new int[]{1, 2, 3, 1}));
        System.out.println(test.rob2(new int[]{2, 7, 9, 3, 1}));
    }
}
