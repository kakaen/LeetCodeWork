package 动态规划算法.矩阵;

import java.util.Arrays;

public class 最大正方形221 {
    public static void main(String[] args) {
        最大正方形221 test = new 最大正方形221();
        char[][] matrix=new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','1','1','1'},
                {'0','1','1','1','1'}};
        System.out.println(test.maximalSquare(matrix));
    }
    public int maximalSquare(char[][] matrix){
        //找到只包含1的最大正方形，并返回其面积
        int n=matrix.length;
        int[][] dp=new int[n][n];
        //dp的初始状态
        for (int j=0;j<n;j++){
            dp[0][j]=matrix[0][j]-'0';
            dp[j][0]=matrix[j][0]-'0';
        }
        System.out.println(Arrays.toString(dp[0]));
        //dp[i][j]；表示该行到达j处连续多少个1
        //dp[i][j]=Math.min(上，左，左上)+1
        int max=0;
        for (int i=1;i<n;i++){
            for (int j=1;j<n;j++){
                if (matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
                if (dp[i][j]>max){
                    max=dp[i][j];
                }
            }
        }
        return max*max;
    }
}
