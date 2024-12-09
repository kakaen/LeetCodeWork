package 动态规划算法.最大子数组和最大子段和;

public class K次串联后最大子数组之和1191 {
    public static void main(String[] args) {
        Solution1191 solution1191 = new Solution1191();
        int[] arr={-1,-2};
        int k=5;
        System.out.println(solution1191.kConcatenationMaxSum(arr, k));
    }
}
class Solution1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        //最大值，可以分解为 第k次result[k]
        //result[k]来自result[k-1]拼k-1个arr
        //求最大子数组的和，只需要求arr中的最大值再乘以k就好
        int mod=1000000007;
        int n=arr.length;
        int[] nums=new int[n*k];
        for (int i=0;i<nums.length;i++){
            nums[i]=arr[i%n];
        }
        int[] dp=new int[nums.length+1];
        int res=0;
        for (int i=1;i<=nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[(i-1)%n],nums[(i-1)%n])%mod;
            res=Math.max(res,dp[i])%mod;
        }
        return res;
    }
    public int KConcatenationMaxSum2(int[] arr,int k){
        int n=arr.length;
        //重复修改k次来修改数组,考虑k=2时，可以把两个数组连接起来，同样利用上述方法求解
        for (int i=0;i<n;i++){

        }
        return 0;
    }
}