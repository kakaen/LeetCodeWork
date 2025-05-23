package Top100.动态规划.网格dp;

public class 不同路径II63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for (int j=0;j<n;j++){
            if (obstacleGrid[0][j]==1) break;
            dp[0][j]=1;
        }
        for (int i=0;i<m;i++){
            if (obstacleGrid[i][0]==1) break;
            dp[i][0]=1;
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
