package Top100.动态规划.打家劫舍;

import java.util.HashMap;
import java.util.Map;

public class 删除并获取点数740 {
    public static void main(String[] args) {
        删除并获取点数740 test = new 删除并获取点数740();
        System.out.println(test.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
    public int deleteAndEarn(int[] nums){
        int max=Integer.MIN_VALUE;
        for (int num:nums){
            max=Math.max(num,max);
        }
        int[] sums=new int[max+1];
        //将所有的点数相加
        for (int num:nums){
            sums[num]+=num;
        }
        return rob(sums);
    }
    public int rob(int[] sums){
        int[] dp=new int[sums.length]; //sums.length=max+1;
        //dp[i]表示选取前i个的最大值，dp[i]=Math.Max(dp[i-]+sums[i],dp[]
        dp[0]=0;
        dp[1]=sums[1];
        for (int i=2;i< sums.length;i++){
            dp[i]=Math.max(dp[i-2]+sums[i],dp[i-1]);
        }
        return dp[sums.length-1];
    }
}
