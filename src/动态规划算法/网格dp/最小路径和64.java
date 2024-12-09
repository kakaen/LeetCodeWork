package 动态规划算法.网格dp;

import java.util.Scanner;

public class 最小路径和64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int[][]grid=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                grid[i][j]=scanner.nextInt();
            }
        }
        Solution64 solution64 = new Solution64();
        System.out.println(solution64.minPathSum(grid));
    }
}
class Solution64 {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //dp[i][j]表示到达i，j处的最小数值
        int[][]dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for (int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int j=1;j<n;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        //dp[i][j]的递推公式 dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
    public int minPathSum2(int[][] grid){
        //给一个从左上角到右下角的路径
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for (int j=1;j<n;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        for (int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
    //dp[i][j]
}