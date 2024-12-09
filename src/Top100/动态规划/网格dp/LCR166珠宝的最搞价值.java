package Top100.动态规划.网格dp;

public class LCR166珠宝的最搞价值 {
    public int jewelleryValue(int[][] frame) {
        int n=frame.length;
        int m=frame[0].length;
        int[][] dp=new int[n][m];
        dp[0][0]=frame[0][0];
        for (int j=1;j<m;j++){
            dp[0][j]=dp[0][j-1]+frame[0][j-1];
        }
        for (int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+frame[i][0];
        }
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+frame[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}
