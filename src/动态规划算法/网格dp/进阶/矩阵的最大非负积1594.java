package 动态规划算法.网格dp.进阶;

public class 矩阵的最大非负积1594 {
    public static void main(String[] args) {

    }
}
class Solution1594{
    public int maxProductPath(int[][] grid){
        //从
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        //最大非负积，如果是负数的话，就存储最小负数。
        //如果是正数的话就存储最大正数
        //dp[i][j]可以来自dp[i-1][j]或dp[i][j-1];


        return 0;
    }
}
