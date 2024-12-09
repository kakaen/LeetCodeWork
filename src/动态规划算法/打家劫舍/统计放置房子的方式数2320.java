package 动态规划算法.打家劫舍;

import java.util.Scanner;

public class 统计放置房子的方式数2320 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        Solution2320 solution2320 = new Solution2320();
        System.out.println(solution2320.countHousePlacements(n));
    }
}
class Solution2320 {
    public int countHousePlacements(int n) {
        int[] dp=new int[n+1];
        //dp[i]表示第i个地块如果不放房子，则dp[i-1]可放可不放
        //dp[i]如果放房子 那i-1的地块就无法放置房子(就确定了)，i-2可放可不放dp[i-2]
        dp[0]=1;
        dp[1]=2;//可放可不放
        for (int i=2;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        return (int)((long)dp[n]*dp[n]%1000000007);
    }
    public int countHousePlacements2(int n){
        int[] dp=new int[n+1]; //dp[i]表示前i个地块放置房子的方式
        dp[0]=0;
        //递推公式，dp[i]=Math.max(dp[i-1]),第i个地块不放，第i个地块放 dp[i-2]
        //可能的放置方式
        for (int i=0;i<=n;i++){

        }
        return 0;
    }
}