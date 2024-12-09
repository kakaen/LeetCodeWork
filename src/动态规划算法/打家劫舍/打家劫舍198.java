package 动态规划算法.打家劫舍;

import java.util.Scanner;

public class 打家劫舍198 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        int rob = rob2(nums);
        System.out.println(rob);
    }
    public static int rob(int[] nums){
        //不能偷相邻的房子
        int n=nums.length; //n表示共有多少间房子
        if (n<=1) return nums[0];
        int[] dp=new int[n]; //dp[i]表示偷窃到第i间房子的最大金额
        //dp[i]从哪来，当前房子偷,那第i-1间房子就不偷了，nums[i]+dp[i-2]
        //当前房子不偷，那就等于dp[i-1]的最大金额
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<n;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
    //状态压缩，
    public static int rob2(int[] nums){
        int n=nums.length;
        if (n<=1) return nums[0];
        int status0=nums[0];
        int status1=Math.max(nums[0],nums[1]);
        for (int i=2;i<n;i++){
            int newStatus=Math.max(status0+nums[i],status1);
            status0=status1;
            status1=newStatus;
        }

        return status1;
    }
}
