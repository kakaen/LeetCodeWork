package Top100.动态规划.打家劫舍;

import java.util.Arrays;

public class 施咒的最大总伤害3186 {
    public static void main(String[] args) {
        施咒的最大总伤害3186 test = new 施咒的最大总伤害3186();
        System.out.println(test.maximumTotalDamage(new int[]{1, 1, 3, 4}));
    }
    public long maximumTotalDamage(int[] power){
        //循环遍历，查找最大值
        int max=power[0];
        for (int p:power){
            max=Math.max(max,p);
        }
        int[] sums=new int[max+1]; //下标为符咒伤害
        for (int p:power){
            sums[p]+=p;
        }
        int[] dp=new int[max+1]; //dp[i]表示到达第i个点的伤害之和的最大值总和

        //dp[i]=Math.max(dp[]+sums[i],dp[]),第i个点选取sums[i]+dp[i-3],不选则为dp[i-1]
        dp[0]=0;
        dp[1]=sums[1];
        dp[2]=Math.max(sums[1],sums[2]);
        dp[3]=Math.max(dp[2],sums[3]);
        for (int i=3;i<=max;i++){
            dp[i]=Math.max(dp[i-3]+sums[i],dp[i-1]);
        }
        return dp[max];
    }
}
