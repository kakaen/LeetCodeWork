package 动态规划算法.爬楼梯;

import java.util.Arrays;

public class 组合总和IV377 {
    public static void main(String[] args) {
        Solution377 solution377 = new Solution377();
        int[] nums={1,2,3};int target=4;
        System.out.println(solution377.combinationSum5(nums, target));
    }
}
class Solution377{
    public int res=0;
    public int combinationSum4_377(int[] nums,int target){
       //使用回溯法求解,会超时哎
        backTracking(nums,0,target);
        return res;
    }
    public void backTracking(int[] nums,int starIndex,int target){
        if (target==0){res++; return;}
        if (target<0) return;
//        if (starIndex==nums.length||target<0) return;
        for (int i=0;i<nums.length;i++){
            target-=nums[i];
            backTracking(nums,i+1,target);
            target+=nums[i];
        }
    }
    public int combinationSum4(int[] nums,int target){
        //使用动态规划算法解决该方案。
        //相当于每次往上爬nums[i]层楼梯每家
        int[] dp=new int[target+1]; //dp[i]表示nums和为i的组合个数
        //dp[i]表示到总和为i的元素组合的个数。
        //dp[i]=sum(dp[i-nums[i]])，和为i的组合可以来自 i-nu
        int n=nums.length;
        //组合总和IV

        //初始状态
        dp[0]=1;
        for (int sum=1;sum<=target;sum++){ //dp[sum]
            for (int i=0;i<n;i++){
                if (nums[i]<=sum){
                    dp[sum]+=dp[sum-nums[i]];
                }
            }
        }
        return dp[target];
    }
    public int combinationSum5(int[] nums,int target){
        //从nums中找出总和为target的元素组合的个数,每次爬nums[i]节楼梯
        //dp[i]表示爬到第i层的方法，dp[i]=sum(dp[i-nums[j]) j->(0~n-1)
        int n=nums.length;
        int[] dp=new int[target+1];
        dp[0]=1;
        for (int i=1;i<=target;i++){
            for (int j=0;j<n;j++){
                if (i<nums[j]) continue;
                dp[i]+=dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}
