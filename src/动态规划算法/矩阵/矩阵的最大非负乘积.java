package 动态规划算法.矩阵;

public class 矩阵的最大非负乘积 {
    public static int maxProductPath(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp1=new int[m][n]; //表示到达为止(i,j)的乘积
        dp1[0][0]=grid[0][0]; //dp1记录最大的非负值，dp2记录最小的负值
        int[][] dp2=new int[m][n]; // 查找负数
        dp2[0][0]=grid[0][0];
        //(m-1,n-1)的乘积只来自dp[i][j]=dp[i-1][j]*grid[i][j],dp[i][j-1]*grid[i][j];
        //首先判断grid[m-1][n-1]是正数还是负数
        for (int j=0;j<n;j++){
            dp1[0][j]=dp1[0][j-1]*grid[0][j];
            dp2[0][j]=dp2[0][j-1]*grid[0][j];
        }
        //先判断grid[m-1][n-1]是正数还是负数
        if (grid[m-1][n-1]<0){
            //找负数，即找最小值
            for (int i=1;i<m;i++){
                for (int j=1;j<n;j++){
                    dp1[i][j]=Math.max(dp1[i][j-1]*grid[i][j],dp1[i-1][j]*grid[i][j]);
                    dp2[i][j]=Math.min(dp2[i][j-1]*grid[i][j],dp2[i-1][j]*grid[i][j]);
                }
            }
        }else{
            //可能为0或者为正数，找最大值
        }
        //进行递推的赋值
        return 0;
    }
}
