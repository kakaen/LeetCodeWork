package 每日一题;

import java.util.Arrays;

public class 骑士拨号器935 {
    public int knightDialer(int n) {
        //使用动态规划的方式
        //执行n-1次，因为第一次也是一个数字
        //dp[i][j]表示到达ij处的共有多少种方法
        int[][] dp=new int[4][3];
        Arrays.fill(dp,1);
        dp[3][0]=0;dp[3][2]=0;
        //dp[i][j]表示到达i，j有多少条可用路径
        //dp[i][j]=dp[i-2][j-1]+dp[i-1][j-2];
        //前n-1次跳跃，蓝色数字单元格上进行跳跃
        for (int i=0;i<n;i++){
        }
        for (int i=0;i<10;i++){

        }
        return 0;
    }
}
