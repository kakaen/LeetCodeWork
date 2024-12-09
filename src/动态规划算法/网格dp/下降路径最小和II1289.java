package 动态规划算法.网格dp;

import java.util.Scanner;

public class 下降路径最小和II1289 {
    public static void main(String[] args) {

        Solution1289 solution1289 = new Solution1289();
        System.out.println(solution1289.minFallingPathSum4(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
class Solution1289{
    public int minFallingPathSum(int[][] grid){
        //grid整数矩阵n*n返回非零偏移下降路径数字和的最小值
        //从每行选择一个数字，且按顺序选出来的数字中，
        //相邻数字不在原数组的同一列
        int n=grid.length;
        int[][] dp=new int[n][n]; //表示到达i,j处的下降路径最小值
        //第一行为原本值
        for (int j=0;j<n;j++){
            dp[0][j]=grid[0][j];
        }
        for (int i=1;i<n;i++){
            for (int j=0;j<n;j++){
                int min=Integer.MAX_VALUE;
                for (int k=0;k<n;k++){
                    if (k==j) continue;
                    min=Math.min(dp[i-1][k],min);
                }
                dp[i][j]=min+grid[i][j]; //找到最小值
            }
        }
        int res=Integer.MAX_VALUE;
        for (int j=0;j<n;j++){
            res=Math.min(res,dp[n-1][j]);
        }
        return res;
    }
    //对上一个规划进行优化
    public int minFallingPathSum2(int[][] grid){
        int n=grid.length;
        int first_min_sum=0;
        int second_min_sum=0;
        int first_min_index=-1;
        for (int i=0;i<n;i++){
            int cur_first_min_sum=Integer.MAX_VALUE;
            int cur_second_min_sum=Integer.MAX_VALUE;
            int cur_first_min_index=-1;

            for (int j=0;j<n;j++){
                int cur_sum=(j!=first_min_index?first_min_sum:second_min_sum);
                if (cur_sum<cur_first_min_sum){
                    cur_second_min_sum=cur_first_min_sum;
                    cur_first_min_index=cur_sum;
                    cur_first_min_index=j;
                } else if (cur_sum<cur_second_min_sum) {
                    cur_second_min_sum=cur_sum;
                }
            }
            first_min_sum=cur_first_min_sum;
            second_min_sum=cur_second_min_sum;
            first_min_index=cur_first_min_index;
        }
        return first_min_sum;
    }
    public int minFallingPathSum3(int[][] grid){
        int n=grid.length;
        int first_sum=0; //记录上一层的最小值 f(i-1,k)
        int second_sum=0;//记录上一层的次小值（如果index和firs）
        int first_index=-1;

        for (int i=0;i<n;i++){
            //记录当前行的最小值次小值和下标
            int cur_firstNum=Integer.MAX_VALUE;
            int cur_sedNum=Integer.MAX_VALUE;
            int cur_firstIndex=-1;
            for (int j=0;j<n;j++){
                int curSum=(j!=first_index?first_sum:second_sum)+grid[i][j];
                if (curSum<cur_firstNum){
                    cur_sedNum=cur_firstNum;
                    cur_firstNum=curSum;
                    cur_firstIndex=j;
                } else if (curSum<cur_sedNum) {
                    cur_sedNum=curSum;
                }
            }
            first_sum=cur_firstNum;
            second_sum=cur_sedNum;
            first_index=cur_firstIndex;
        }
        return first_sum;
    }
    //下路径最小和II
    public int minFallingPathSum4(int[][] grid){
        //相邻数字步骤同一列,每一行选择一个数字
        int n=grid.length;
        int[][] f=new int[n][n]; //f[i][j]表示到达(i,j)的最小路径
        for (int j=0;j<n;j++){
            f[0][j]=grid[0][j];
        }
        for (int i=1;i<n;i++){
            for (int j=0;j<n;j++){
                //查询上一层的最小值(除(i-1,j))
                int min=Integer.MAX_VALUE;
                for (int k=0;k<n;j++){
                    if (f[i-1][k]<min&&k!=j){
                        min=f[i-1][k];
                    }
                }
                f[i][j]=min+grid[i][j];
            }
        }
        int res=Integer.MAX_VALUE;
        for (int num:f[n-1]){
            if (num<res) res=num;
        }
        return res;
    }

}
