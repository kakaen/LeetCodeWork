package 动态规划算法.打家劫舍;

import java.util.Scanner;

public class 打家劫舍_198 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        Solution_198 solution198 = new Solution_198();
        System.out.println(solution198.rob(nums));
    }
}
class Solution_198{
    public int rob(int[] nums){
        //偷窃房屋，
        int n=nums.length;
        //dp[i]表示到达第i间房子偷取的最大值，这里第i间房子如果偷的话
        //那就dp[i-2]+nums[i]。如果不投的话，那就是dp[i-1]
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<=n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }
}