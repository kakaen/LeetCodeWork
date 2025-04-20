package Top100二刷.动态规划.买股票的最佳时机;

public class 买股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int ans=0;
        int n=prices.length;
        int[][]dp=new int[n][2];
        //dp[i][0]=表示第i天持有现金,不持有股票
        //dp[i][1],表是第i天持有股票
        dp[0][0]=0; //表示不购买第i天天的股票
        dp[0][1]=-prices[0]; //表示购买了第i天的股票
        for (int i=1;i<n;i++){
            //第i天持有现金，有两种来源，一是i-1天没有持有股票，二是i-1天持有了股票，在第i天卖出股票
            dp[i][0]=Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
            //第i天持有股票,有两种来源,一是i-1天没有持有股票，第i天购买股票，二是i-1天持有了股票，不卖出
            dp[i][1]=Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
        买股票的最佳时机II test = new 买股票的最佳时机II();
        System.out.println(test.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
