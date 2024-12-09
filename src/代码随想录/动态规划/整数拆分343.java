package 代码随想录.动态规划;

import java.util.Scanner;

public class 整数拆分343 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution343 solution343 = new Solution343();
        System.out.println(solution343.integerBreak(n));
    }
}
class Solution343 {
    public int integerBreak(int n) {
        //将n拆分成k个正整数的和
        // dp[i]表示将整数i拆分后的乘积最大值
        int[] dp=new int[n+1];
        //递推公式dp[i]将i拆分成j，i-j。这里可能i-j还可以继续拆分
        dp[0]=0;
        dp[1]=0;
        for (int i=2;i<=n;i++){
            int curMax=0;
            //需要遍历所有的j得到dp[i]的最大值
            for (int j=1;j<i;j++){
             curMax=Math.max(curMax,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i]=curMax;
        }
        return dp[n];
    }
}
