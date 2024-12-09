package 代码随想录.动态规划;

import java.util.Scanner;

public class 使用最小花费爬楼梯746 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cost=new int[n];
        for (int i=0;i<n;i++){
            cost[i]=scanner.nextInt();
        }
        Solution746 solution746 = new Solution746();
        System.out.println(solution746.minCostClimbingStairs(cost));
    }
}
class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        //dp[i]的含义：表示爬到第i个台阶所需的最小费用
        int n=cost.length;
        int[] dp=new int[n+1];
        dp[0]=cost[0];
        dp[1]=cost[1];
        //确定地推公式 爬到第i个台阶所需的最小费用为 dp[i]=Math.min(dp[i-1],dp[i-2])
        for (int i=2;i<n;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n-1];
    }
}
