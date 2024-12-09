package 动态规划算法.矩阵;

public class 不同路径62 {
    public static void main(String[] args) {
        不同路径62 test = new 不同路径62();
        System.out.println(test.uniquePaths(3, 7));
        System.out.println(test.uniquePaths(3, 2));
    }
    public int uniquePaths(int m,int n){
        int[][] dp=new int[m][n];//dp[i][j]表示到达第i,j处的路径总个数

        for (int j=1;j<n;j++){
            dp[0][j]=1;
        }
        for (int i=1;i<m;i++){
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
