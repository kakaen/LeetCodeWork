package Top100二刷.动态规划;

public class 完全平方数279 {
    public int numSquares2(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        for (int i=1;i<=n;i++){
            dp[i]=Integer.MAX_VALUE;
            for (int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }

        return dp[n];
    }
    public int numSquares(int n){
        //返回和为n的完全平方数的最少数量
        //f[i]表示最少需要多少个数的平方来表示整数i
        //这些数必然落在[1,sqrt(i)]
        //我们可以枚举这些数，假设枚举到j，那我们还需要去取若干整数的平方，构成i-j^2
        int[] dp=new int[n+1];
        dp[0]=0;
        for (int i=1;i<=n;i++){
            int minn=Integer.MAX_VALUE;
            for (int j=1;j*j<=i;j++){
                //这个是计算dp[j]的最小值
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
