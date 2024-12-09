package 动态规划算法.打家劫舍;

import java.util.Arrays;
import java.util.Scanner;

public class 打家劫舍II213 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        Solution213 solution213 = new Solution213();
        System.out.println(solution213.rob(nums));
    }
}
class Solution213 {
    public int rob(int[] nums) {
        int n=nums.length;
        //第一间房子和最后一间房子中，只能有一个偷窃
        //1.在不偷窃第一个房子的情况下最大金额为nums[1:]
        int p1 = rob2(Arrays.copyOfRange(nums, 1, n));
        //2.在不偷窃最后一个房子的情况下最大金额为nums[0:n-1]
        int p2=rob2(Arrays.copyOfRange(nums,0,n-1));
        return Math.max(p1,p2);
    }
    //常规的打家劫舍
    public int rob2(int[] nums){
        int n=nums.length;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];
        for (int i=2;i<=n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }
    public int rob3(int[] nums){
        //所有房屋都围成一圈。 第一个房屋选，第一个房屋不选.
        // 第一个房屋和最后一个房屋只能选一个.不投第一个额房子
        //dp[i]表示偷取房屋i所
        //dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1])
        int n=nums.length;
        if (n<2) return nums[n-1];
        return Math.max(myRob(Arrays.copyOfRange(nums,0,n-1)),
                myRob(Arrays.copyOfRange(nums,1,n)));
    }
    //原始的打家劫舍
    public int myRob(int[] nums){
        int n=nums.length;
        int[] dp=new int[n+1];
        int pre=0,cur=0,tmp;
        for (int num:nums){
            tmp=cur;
            cur=Math.max(pre+num,cur);
            pre=tmp;
        }
        return cur;
    }
}
