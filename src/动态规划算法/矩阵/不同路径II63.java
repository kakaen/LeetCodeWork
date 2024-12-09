package 动态规划算法.矩阵;

public class 不同路径II63 {
    public static void main(String[] args) {
        不同路径II63 test = new 不同路径II63();
        System.out.println(test.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(test.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for (int j=0;j<n;j++){
            if (obstacleGrid[0][j]==1){
                break;
            }else{
                dp[0][j]=1;
            }
        }
        for (int i=0;i<m;i++){
            if (obstacleGrid[i][0]==1){
                break;
            }else{
                dp[i][0]=1;
            }
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
    //采用状态压缩空间复杂度。将空间复杂度优化为O(m)
    public int uniquePathsWithObstacles2(int[][] obstacleGrid){
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[] dp=new int[n];
        dp[0]=obstacleGrid[0][0]==0?1:0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (obstacleGrid[i][j]==1){
                }
            }
        }
        return 0;
    }
}
