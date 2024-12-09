package 动态规划算法.打家劫舍;

import com.sun.jndi.ldap.LdapPoolManager;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class 删除并获得点数740 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        System.out.println(deletAndEarn(nums));
    }
    public static int deletAndEarn(int[] nums){
        int n=nums.length;
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }

        return n;
    }
    public int deletAndEarn2(int[] nums){
        //删除整数数组nums
        int maxPoint=nums[0];
        int n=nums.length;
        for (int i=1;i<n;i++){
            maxPoint=Math.max(maxPoint,nums[i]);
        }
        //dp[i]表示到达前i个点的最大和。
        int[] sum=new int[maxPoint+1];
        for (int num:nums){
            sum[num]+=num;
        }
        int[] dp=new int[maxPoint+1];
        dp[0]=0;
        dp[1]=sum[1];
        for (int i=2;i<maxPoint+1;i++){
            dp[i]=Math.max(dp[i-2]+sum[i],dp[i-1]);
        }
        return dp[maxPoint];
    }
}
