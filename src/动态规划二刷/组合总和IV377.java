package 动态规划二刷;

import java.util.Arrays;

public class 组合总和IV377 {
    public static void main(String[] args) {
        组合总和IV377 test = new 组合总和IV377();
        System.out.println(test.combinationSum4(new int[]{1, 2, 3}, 4));
    }
    public int ans=0;
    public int combinationSum4(int[] nums, int target) {
        //dp[i]就表示从nums中选取和为i的组合个数
        int[] dp=new int[target+1];
        Arrays.sort(nums);
        dp[0]=1;
        //递推公式就是 dp[]
        for (int i=1;i<nums.length;i++){
            for (int num:nums){
                if (num<=i) dp[i]+=dp[i-num];
            }
        }
        return dp[target];
    }


}
