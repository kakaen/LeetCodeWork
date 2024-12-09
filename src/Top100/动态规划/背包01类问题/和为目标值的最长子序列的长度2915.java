package Top100.动态规划.背包01类问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 和为目标值的最长子序列的长度2915 {

    public int lengthOfLongestSubqequence(List<Integer> nums,int target){
       int n=nums.size();
       //dp[i][j]:表示从前i个元素中选择元素和恰好为j的最长子序列的长度
       int[][] dp=new int[n+1][target+1];
       Arrays.fill(dp[0],-1);
       //初始化
        for (int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        //遍历前i个元素
        for (int i=1;i<=n;i++){
            int num=nums.get(i-1);
            for (int j=0;j<=target;j++){
                if (j<num){
                    dp[i][j]=dp[i-1][j];
                }else {
                    //这里需要判断是否可以从j-num
                    if (dp[i-1][j-num]==-1){
                        dp[i][j]=dp[i-1][j];
                    }else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-num]+1);
                    }
                }

            }
        }
        for (int[] d:dp){
            for (int num:d){
                System.out.print(num+" ");
            }
            System.out.println();
        }
        return dp[n][target];
    }
    //进行空间优化
    public int lengthOfLongestSubqequence2(List<Integer> nums,int target){
        int n=nums.size();
        int[] dp=new int[target+1]; //dp[j],表示前i个元素和为j的最长子数组
        Arrays.fill(dp,-1);
        dp[0]=0;
        for (int num:nums){
            for (int j=target;j>=num;j--){
                if (dp[j-num]!=-1){
                    dp[j]=Math.max(dp[j],dp[j-num]+1);
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        和为目标值的最长子序列的长度2915 test = new 和为目标值的最长子序列的长度2915();
        List<Integer> nums=new ArrayList<>();
        nums.add(1);nums.add(2);nums.add(3);nums.add(4);nums.add(5);
        List<Integer> nums2=new ArrayList<>();
        nums2.add(4);nums2.add(1);nums2.add(3);nums2.add(2);nums2.add(1);nums2.add(5);
        System.out.println(test.lengthOfLongestSubqequence2(nums, 9));
        System.out.println(test.lengthOfLongestSubqequence2(nums2, 7));
    }
}
