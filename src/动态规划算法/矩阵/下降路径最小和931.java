package 动态规划算法.矩阵;

public class 下降路径最小和931 {
    public static void main(String[] args) {
        下降路径最小和931 test = new 下降路径最小和931();
        int[][] matrix=new int[][]{{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(test.minFallingPathSum(matrix));
    }
    public int minFallingPathSum(int[][] matrix){
        //下降路径的最小和
        int n=matrix.length;
        if (n==1) return matrix[0][0];
        //dp[i][j]表示到达i,j处的最小和
        int[][] dp=new int[n][n];
        //第一行进行初始化操作
        for (int j=0;j<n;j++){
            dp[0][j]=matrix[0][j];
        }
        //
        for (int i=1;i<n;i++){
            for (int j=0;j<n;j++){
                if (j==0){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j+1])+matrix[i][j];
                } else if (j==n-1) {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+matrix[i][j];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i-1][j+1]))+matrix[i][j];
                }
            }
        }
        int min=dp[n-1][0];
        for (int num:dp[n-1]){
            if (num<min){
                min=num;
            }
        }
        return min;
    }
    public int minFallingPathSum2(int[][] matrix){
        int n=matrix.length;
        int[][]f=new int[n][n];
        for (int j=0;j<n;j++){
            f[0][j]=matrix[0][j];
        }
        for (int i=1;i<n;i++){
            f[i][0]=Math.min(f[i-1][0],f[i-1][1])+matrix[i][0];
            for (int j=1;j<n-1;j++){
                f[i][j]=Math.min(Math.min(f[i-1][j-1],f[i-1][j]),f[i-1][j+1])+matrix[i][j];
            }
            f[i][n-1]=Math.min(f[i-1][n-1],f[i-1][n-2])+matrix[i][n-1];
        }
        int min=f[n-1][0];
        for (int num:f[n-1]){
            if (min>num) min=num;
        }
        return min;
    }
    //使用滚动数组进行空间优化，
    public int minFallingPathSum3(int[][] matrix){
        int n=matrix.length;
        if (n==1) return matrix[0][0];
        int[] f=new int[n];
        for (int j=0;j<n;j++){
            f[j]=matrix[0][j];
        }
        int preJ_1;
        for (int i=1;i<n;i++){
            //定义一个变量来记录上一层的第j+1个元素
            preJ_1=f[n-1];
            f[n-1]=Math.min(f[n-1],f[n-2])+matrix[i][n-1];
            for (int j=n-2;j>0;j--){
                int temp=f[j]; //记录下
                f[j]=Math.min(Math.min(f[j-1],f[j]),preJ_1)+matrix[i][j];
                preJ_1=temp;
            }
            f[0]=Math.min(f[0],preJ_1);
        }
        int min=f[0];
        for (int num:f){
            if (num<min) min=num;
        }
        return min;
    }
}
