package 代码随想录.动态规划;

import java.util.Scanner;

public class 不同路径II63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m=scanner.nextInt();
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
        //1.dp[i][j]是到达该点的所有路径
        int[][] dp=new int[m][n];
        //初始化状态
        for (int i=0;i<m;i++){
            //如果边界上存在一个石头
            if (obstacleGrid[i][0]==1) break;
            dp[i][0]=1;
        }
        for (int j=0;j<n;j++){
            if (obstacleGrid[0][j]==1) break;
            dp[0][j]=1;
        }
        //确定递推公式 dp[i][j],如果i-1,j是石头那就无法加，
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
