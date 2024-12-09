package 代码随想录.动态规划;

public class 不同路径62 {
    public static void main(String[] args) {

    }
}
class Solution62 {
    public int uniquePaths(int m, int n) {
        //dp数组 dp[i][j]是到达第i行第j列格子的总路径
        int[][]dp=new int[m][n];
        //计算地推公式，第i行j列的格子可以从第i-1行第j列到达，或第i行第j-1列到达，dp[i][j]=dp[i-1][j]+dp[i][j-1]
        //初始化 dp[0][0]=0; dp[0][1]=1,dp[1][0]=1;
        for (int i=1;i<m;i++){
            dp[i][0]=1;
        }
        for (int j=1;j<n;j++){
            dp[0][j]=1;
        }
        //进行遍历递推
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
