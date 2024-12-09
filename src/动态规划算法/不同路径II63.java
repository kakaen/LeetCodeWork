package 动态规划算法;

public class 不同路径II63 {
    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
        solution63.uniquePathsWithObstacles(new int[][]{{0,1},{0,0}});
    }
}
class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //网格中有障碍物（用1来表示）空的用0来表示
        //1.dp[i][j]为从0,0到达i,j的所有路径总数
        //2.dp方程需要判断当前i,j是否为1，如果为一，则设置dp[i][j]=0
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        //3.初始化
        boolean flag=false;
        for (int j=0;j<n;j++){
            if (flag==true||obstacleGrid[0][j]==1){
                dp[0][j]=0;
                flag=true; //说明有障碍物
            }else{
                dp[0][j]=1;
            }

        }
        boolean flagRow=false;
        for (int i=0;i<m;i++){
            if (flagRow==true||obstacleGrid[i][0]==1) {
                dp[i][0] = 0;
                flagRow = true;
            }else{
                dp[i][0]=1;
            }
        }
        //进行动态方程的推导
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                System.out.print(dp[i][j]);
                System.out.print(" , ");
            }
            System.out.println("--------");
        }
        return dp[m-1][n-1];
    }
}