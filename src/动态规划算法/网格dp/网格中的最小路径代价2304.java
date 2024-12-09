package 动态规划算法.网格dp;

public class 网格中的最小路径代价2304 {
    public static void main(String[] args) {
        Solution2304 solution2304 = new Solution2304();
        int[][] grid={{5,3},{4,0},{2,1}};
        int[][] grid2={{5,1,2},{4,0,3}};
        int[][] moveCost={{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};
        int[][] moveCost2={{12,10,15},{20,23,8},{21,7,1},{8,1,13},{9,10,25},{5,3,2}};
        System.out.println(solution2304.minPathCost(grid2, moveCost2));
    }
}
class Solution2304 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        //移动到下一行的任何其他单元格
        //dp[i][j]表示移动到第i行第j个元素的最小路径代价
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        //第一行的所有元素的代价都是节点本身
        for (int j=0;j<n;j++){
            dp[0][j]=grid[0][j];
        }
        //dp[i][j]=Math.min(dp[i-1][j]+moveCost[])
        for (int i=1;i<m;i++){
            for (int j=0;j<n;j++){ //进行赋值第i行的(0,n-1)的所有元素的最小代价值
                int min=Integer.MAX_VALUE;
                for (int k=0;k<n;k++){
                    int num=grid[i-1][k]; //假设从上一个（i-1,j）节点到达
                    min=Math.min(dp[i-1][k]+moveCost[num][j],min);
                }
                dp[i][j]=min+grid[i][j];
            }
        }
        int res=Integer.MAX_VALUE;
        for (int j=0;j<n;j++){
            res=Math.min(res,dp[m-1][j]);
        }
        return res;
    }
    public int minPathCost2(int[][] grid,int[][] moveCost){
      int m=grid.length;
      int n=grid[0].length;
      int[][]f=new int[m][n]; //表示到达(i,j)处的最小路径代价
        int min=Integer.MAX_VALUE;
        for (int j=0;j<n;j++){
            f[0][j]=0;
        }
        return min;
    }
    public void backTracking(int start,int row,int[][] moveCost,int[][] grid){
      return;
    }

    public static void main(String[] args) {
        Solution2304 test = new Solution2304();
        System.out.println(test.minPathCost2(new int[][]{{5, 3}, {4, 0}, {2, 1}}, new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}}));
    }
}