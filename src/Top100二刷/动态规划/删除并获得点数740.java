package Top100二刷.动态规划;

import java.util.Arrays;

public class 删除并获得点数740 {
    public static void main(String[] args) {
        删除并获得点数740 test = new 删除并获得点数740();
        System.out.println(test.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(test.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
    public int deleteAndEarn(int[] nums){
        int max=0;
        for (int num:nums){
            max=Math.max(max,num);
        }
        int[] arr=new int[max+1];
        //把相同的点数进行合并
        for (int num:nums){
            arr[num]+=num;
        }
        //使用dp进行
        int n=arr.length;
        int[] dp=new int[n+1]; //dp[i]表示前i个店铺的最大点数
        dp[0]=0;
        dp[1]=arr[0];
        for (int i=2;i<=n;i++){
            dp[i]=Math.max(dp[i-2]+arr[i-1],dp[i-1]);
        }
        return dp[n];
    }
}
