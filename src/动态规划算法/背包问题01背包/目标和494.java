package 动态规划算法.背包问题01背包;

public class 目标和494 {
    public static void main(String[] args) {
        Solution494 solution494 = new Solution494();
        int[] nums={1,1,1,1,1}; int target=3;
        System.out.println(solution494.findTargetSumWays2(nums, target));
    }
}
class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        for (int num:nums){
            target+=num;
        }
        //设p是数组中选择为正数的和，s为数组的元素和
        //则s-p为剩下要赋值为负的元素和（绝对值）
        //p-(s-p)=t---> p=(s+t)/2  选择一些数字使其等于（s+t)/2的方案数
        if (target<0||target%2!=0) return 0;
        target=target/2;

        return backtracking(target,0,nums);
    }
    public int backtracking(int p,int start,int[] nums){
        if (start==nums.length){
            return p==0?1:0;
        }
        if (p<nums[start]){
            return backtracking(p,start+1,nums);
        }
        //选择nums[start]作为正数，和不选nums[start]作为正数
        return backtracking(p-nums[start],start+1,nums)
                +backtracking(p,start+1,nums);
    }
    public int findTargetSumWays2(int[] nums,int target){
        int s=0;
        for (int num : nums) {
            s+=num;
        }
        s=s-Math.abs(target);
        //设p是数组中选择为正数的和，s为数组的元素和//则s-p为剩下要赋值为负的元素和（绝对值）
        //p-(s-p)=t---> p=(s+t)/2  选择一些数字使其等于（s+t)/2的方案数
        if (s<0||s%2==0) return 0;
        int m=s/2;  //背包容量
        int n=nums.length;
        //dp[i][j]表示在数组nums的前i个数中选取元素，使得这些元素之和等于j的方案个数
        int[][] dp=new int[n+1][m+1];
        //初始化状态条件,[i][capacity] 其中的i表示nums[i]是否选择。capacity表示容量
        dp[0][0]=1;
        for (int i=0;i<n;i++){
            for (int c=0;c<=m;c++){
                if (c<nums[i]){
                    dp[i+1][c]=dp[i][c]; //如果容量c小于当前物品的重量，只能不选
                }else{
                    //有不选方案，和选的方案，
                    // 选的方案就等于说我选了nums[i]的物品，现在背包还有c-nums[i],这么大的背包容量能放多少物品的方案
                    dp[i+1][c]=dp[i][c]+dp[i][c-nums[i]];
                }
            }
        }
        return dp[n][m];
    }
    public int findTargetSumWays3(int[] nums,int target){
        int s=0;
        for (int num:nums) s+=num;
        int m=s-Math.abs(target);
        if (m<0||m%2==1) return 0;
        m=m/2;
        //定义dp数组,dp[i][j]表示从前i个数中选取target为j的方案
        int n=nums.length;
        int[][] dp=new int[n+1][m+1];
        //初始化状态数组
        dp[0][0]=1;
        for (int i=1;i<=n;i++){
            for (int j=0;j<=m;j++){
                if (j<nums[i]){
                    dp[i+1][j]=dp[i][j];
                }else{
                    dp[i+1][j]=dp[i][j]+dp[i][j-1]; //不选和选两种方式
                }
            }
        }
        return dp[n][m];
    }
}
