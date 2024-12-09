package 动态规划算法.网格dp;

import java.util.Scanner;

public class 不同路径II63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m= scanner.nextInt();
        int n=scanner.nextInt();
        int[][] obstacleGrid=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                obstacleGrid[i][j]=scanner.nextInt();
            }
        }
        Solution63 solution63 = new Solution63();
        System.out.println(solution63.uniquePathsWithObstacles(obstacleGrid));
    }
}
class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        //dp[i][j]表示到达i，j的总路径
        int[][]dp=new int[m][n];
        //初始化
        dp[0][0]=1;
        for (int i=1;i<m;i++){
            if (obstacleGrid[i][0]==1) break;
            dp[i][0]=1;
        }
        for (int j=1;j<n;j++){
            if (obstacleGrid[0][j]==1) break;
            dp[0][j]=1;
        }
        //dp[i][j]的递推公式
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (obstacleGrid[i][j]==1) {
                    dp[i][j]=0;
                    continue;
                }
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePathsWithObstacles2(int[][] obstacleGrid){
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n]; //表示到达i,j处的总路径
        //如果oG[i][j]=1,则将dp[i][j]置为0
        for (int j=0;j<n;j++){
            if (obstacleGrid[0][j]==1) break;
            dp[0][j]=1;
        }
        for (int i=0;i<m;i++){
            if (obstacleGrid[i][0]==1) break;
            dp[i][0]=1;
        }
        //进行遍历
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (obstacleGrid[i][j]==1) dp[i][j]=0;
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
