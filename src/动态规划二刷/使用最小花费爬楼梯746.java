package 动态规划二刷;

public class 使用最小花费爬楼梯746 {
    public int minCostClimbingStairs(int[] cost){
        //cost[i]是从第i个楼梯向上爬的费用
        int n=cost.length;
        int[] dp=new int[n+1]; //dp[i]表示爬到第i层所需的最小花费
        dp[0]=dp[1]=0;
        // dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
        for (int i=2;i<=n;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
    public int function2(int[] cost){
        int sum1=0;
        int sum2=0;
        for (int i = 2; i < cost.length; i++) {
            int sum=Math.min(sum1+cost[i-1],sum2+cost[i-2]);
            sum1=sum2;
            sum2=sum;
        }
        return sum2;
    }

    public static void main(String[] args) {
        使用最小花费爬楼梯746 test = new 使用最小花费爬楼梯746();
        System.out.println(test.minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}
