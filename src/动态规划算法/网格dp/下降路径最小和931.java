package 动态规划算法.网格dp;

import java.util.Scanner;

public class 下降路径最小和931 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();

        int[][] matrix=new int[n][n];

        scanner.nextLine();
        for (int i=0;i<n;i++){
            String str=scanner.nextLine();
            String[] nums = str.split(" ");
            for (int j = 0; j < nums.length; j++) {
                matrix[i][j]=Integer.parseInt(nums[j]);
            }
        }
        Solution931 solution931 = new Solution931();
        System.out.println(solution931.minFallingPathSum(matrix));
    }
}
class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        if (n==1) return matrix[0][0];
        //dp[i][j]表示到达i，j处的位置所需的最小路径和
        int[][]dp=new int[n][n];
        //dp[i][j]=
        // Math.min(dp[i-1][j-1],dp[i-1][j],dp[i-1][j+1])+matrix[i][j]
        //但是有的位置没有三个元素怎么办呢，如第一列，没有j-1.最后一列没j+1
        for (int j=0;j<n;j++){
            dp[0][j]=matrix[0][j];
        }
        for (int i=1;i<n;i++){
            //第一列的dp[i][j]只能来自
            dp[i][0]=Math.min(dp[i-1][0],dp[i-1][1])+matrix[i][0];
            for (int j=1;j<n-1;j++){
                dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i-1][j+1]))+matrix[i][j];
            }
            dp[i][n-1]=Math.min(dp[i-1][n-1],dp[i-1][n-2])+matrix[i][n-1];
        }
        int result=Integer.MAX_VALUE;
        for (int j=0;j<n;j++){
            if (dp[n-1][j]<result) result=dp[n-1][j];
        }
        return result;
    }
    public int minFallingPathSum2(int[][] matrix){
        int n=matrix.length;
        int[][] dp=new int[n][n];
        //dp[i][j]表示到达i,j处路径最小和。
        //初始化状态
        for (int j=0;j<n;j++){
            dp[0][j]=matrix[0][j];
        }
        //递推公式，
        // dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i-1][j+1])+matrix[i][j]
        for (int i=1;i<n;i++){
            for (int j=0;j<n;j++){
                if (j==0){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j+1])+matrix[i][j];
                } else if (j==n-1) {
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+matrix[i][j];
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i-1][j+1])+matrix[i][j];
                }
            }
        }
        int res=Integer.MAX_VALUE;
        for (int j=0;j<n;j++){
            if (res>dp[n-1][j])
                res=dp[n-1][j];
        }
        return res;
    }
}
