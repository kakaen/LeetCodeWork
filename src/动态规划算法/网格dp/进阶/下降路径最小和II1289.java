package 动态规划算法.网格dp.进阶;

public class 下降路径最小和II1289 {
    public static void main(String[] args) {
        下降路径最小和II1289 test = new 下降路径最小和II1289();
        System.out.println(test.minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
    public int minFallingPathSum(int[][] grid){
        int n=grid.length;
        if (n==1) return grid[0][0];
        int[][] dp=new int[n][n];
        int firstMinIndex=grid[0][0]<grid[0][1]?0:1;
        int secondMinIndex=grid[0][0]>grid[0][1]?0:1;
        //求第0行的最小值和次小值
        for (int j=0;j<n;j++){
            if (grid[0][j]<grid[0][firstMinIndex]){
                secondMinIndex=firstMinIndex;
                firstMinIndex=j;
            } else if (grid[0][j]<grid[0][secondMinIndex]) {
                secondMinIndex=j;
            }
            dp[0][j]=grid[0][j];  //第一层的dp值
        }
        //第i层的dp
        for (int i=1;i<n;i++){
            int newfirstIndex=0;
            int newSecodIndex=0;
            for (int j=0;j<n;j++){
                //如果当前j等于上一层的最小值的下标，那只能使用次小值的下标
                if (j==firstMinIndex){
                    dp[i][j]=dp[i-1][secondMinIndex]+grid[i][j];
                }else {
                    dp[i][j]=dp[i-1][firstMinIndex]+grid[i][j];
                }
                //以下逻辑是更新该层的最小值和次小值下标的
                if (j==0){
                    newfirstIndex=0;
                }else if(j==1){
                    newfirstIndex=dp[i][0]<dp[i][1]?0:1;
                    newSecodIndex=dp[i][0]>dp[i][1]?0:1;
                } else if (dp[i][j]<dp[i][newfirstIndex]) {
                    newSecodIndex=newfirstIndex;
                    newfirstIndex=j;
                } else if (dp[i][j]<dp[i][newSecodIndex]) {
                    newSecodIndex=j;
                }
            }
            firstMinIndex=newfirstIndex;
            secondMinIndex=newSecodIndex;
        }
        int min=dp[n-1][0];
        for (int num:dp[n-1]){
            if(num<min) min=num;
        }
        return min;
    }
}
