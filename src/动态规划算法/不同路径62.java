package 动态规划算法;

public class 不同路径62 {
}
class Solution62 {
    public int uniquePaths(int m, int n) {

        //机器人只能向下或向右移动一步
        //1.dp[i].
        //到达end只有两种finish的上一个(m-1,n)然后往下和到达finish的左侧(m,n-1)然后往右
        int[][] dp=new int[m][n];
        //2.状态转移方程 dp[i][j]=dp[i-1][j]+dp[i][j-1](i,j坐标的左侧一个)
        //3.初始化

        for (int j=0;j<n;j++){
            dp[0][j]=1;
        }
        for (int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}