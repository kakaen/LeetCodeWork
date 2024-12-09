package 动态规划算法.网格dp;

import java.util.Scanner;

public class 不同路径62 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        Solution62 solution62 = new Solution62();
        System.out.println(solution62.uniquePaths(m, n));
    }
}
class Solution62 {
    public int uniquePaths(int m, int n) {
        //dp[i][j]表示到达i,j的总路径
        int[][]dp=new int[m][n];
        //初始化
        for (int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for (int j=1;j<n;j++){
            dp[0][j]=1;
        }
        //dp[i][j]=dp[i-1][j]+dp[i][j-1];
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePaths2(int m,int n){
        //start,到达m,n共有多少条路径
        //int[][]dp=new int[][],dp[i][j]表示到达i，j的总路径数量
        int[][] dp=new int[m][n];
        for (int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for (int j=0;j<n;j++){
            dp[0][j]=1;
        }
        //递推公式为 dp[i][j]=dp[i-1][j]+dp[i][j-1]
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}