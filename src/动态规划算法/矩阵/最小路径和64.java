package 动态规划算法.矩阵;

public class 最小路径和64 {
    public static void main(String[] args) {
        最小路径和64 test = new 最小路径和64();
        System.out.println(test.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
    public int minPathSum(int[][] grid ){
        //找一条从左上角到右下角的路径，每次只能向下或者向由
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        //到达i,j处的数字最小和
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
    //状态压缩法
    public int minPathSum2(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        for (int j=1;j<n;j++){
            grid[0][j]+=grid[0][j-1];
        }
        for (int i=1;i<m;i++){
            grid[i][0]+=grid[i-1][0];
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }
        return grid[m-1][n-1];
    }
}
