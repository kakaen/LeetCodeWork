package 动态规划算法.爬楼梯;

public class 使用最小花费爬楼梯746 {
    public static void main(String[] args) {
        int[] cost={10,15,20};
        int[] cost2={1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(minCostClimbingStairs(cost2));
    }
    public static int minCostClimbingStairs(int[] cost){
        //整数cost，从楼梯第i个台阶向上爬需要的支付费用
        //dp[i],表示爬到第i层楼梯的最少花费
        //dp[i]=dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]
        int n=cost.length;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for (int i=2;i<=n;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
    //状态压缩
    public static int minCostClimbingStairs2(int[] cost){
        int f0=0,f1=0;
        for (int i=2;i<=cost.length;i++){
            int newF=Math.max(f0+cost[i-2],f1+cost[i-1]);
            f0=f1;
            f1=newF;
        }
        return f1;
    }
}

