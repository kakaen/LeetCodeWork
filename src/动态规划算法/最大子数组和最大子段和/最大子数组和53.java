package 动态规划算法.最大子数组和最大子段和;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.Scanner;

public class 最大子数组和53 {
    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        int result = solution53.maxSubArray3(nums);
        System.out.println(result);
    }
}
class Solution53 {
    public int maxSubArray(int[] nums) {
        //用f(i)代表第i个数结尾的连续子数组的最大和，
        //第i个数,nums[i]单独成为一个子数组，那么f(i)=nums[i]
        //nums[i]和前面f(i-1)拼起来
        //f(i)=Math.max(nums[i],f(i-1)+nums[i])
        int result=Integer.MIN_VALUE;
        int preCount=0;
        for (int num:nums){
            int curCount=Math.max(num,num+preCount);
            preCount=curCount;
            result=Math.max(result,preCount);
        }
        return result;
    }
    public int maxSubArray2(int[] nums){
        int result=Integer.MIN_VALUE;
        int n=nums.length;
        int[] f=new int[n+1];
        //f[i]表示以下标i结尾的最大值
        int i=0;
        f[0]=0;
        for (int j = 1; j < nums.length; j++) {
            f[i]=Math.max(f[i-1]+nums[i],nums[i]);
            result=Math.max(f[i],result );
        }
        return result;
    }
    public int maxSubArray3(int[] nums){
        //dp[i]表示以第i个元素结尾的子数组的最大和
        int result=Integer.MIN_VALUE;
        int n=nums.length;
        int[] dp=new int[n];
        //dp[i]的最大元素为 Math.max(nums[i]，dp[i-1]+nums[i]);
        dp[0]=nums[0];
        result=dp[0];
        for (int i=1;i<n;i++){
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            result=Math.max(result,dp[i]);
        }
        return result;
    }
    public int maxSubArray4(int[] nums){
        //具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
        int n=nums.length;
        int[] dp=new int[n+1];
        //dp[i]表示前i个元素的最大和连续子数组
        //dp[i]=Math.max(dp[i-1]+nums[i-1],nums[i-1])
        dp[0]=0;
        int res=Integer.MIN_VALUE;
        for (int i=1;i<=n;i++){
            dp[i]=Math.max(dp[i-1]+nums[i-1],nums[i-1]);
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}