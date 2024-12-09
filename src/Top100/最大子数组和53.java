package Top100;

import java.util.Scanner;

public class 最大子数组和53 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]= scanner.nextInt();
        }
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.maxSubArray53III(nums));
    }
}
class Solution53{
    public int maxSubArray53(int[] nums){
        //dp[i]表示以元素i结尾的最大和
        int n=nums.length;
        int[] dp=new int[n];
        int result=0;
        //初始化
        dp[0]=nums[0];
        result=nums[0];
        //dp[i]=dp[i-1]+nums[i],nums[i]
        for (int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            result=Math.max(result,dp[i]);
        }
        return result;
    }
    public int maxSubArray53II(int[] nums){
        int res=nums[0];
        int sum=0;
        for (int num:nums){
            if (sum>0){
                sum+=num;
            }else{
                sum=num;
            }
            res=Math.max(res,sum);
        }
        return res;
    }
    //使用前缀和计算
    public int maxSubArray53III(int[] nums){
        int n=nums.length;
        int[] index=new int[n+1];
        index[0]=0;
        for (int i=1;i<=n;i++){
            index[i]=index[i-1]+nums[i-1];
        }
        int min=Integer.MAX_VALUE;
        int res=0;
        for (int num:index){
            res=Math.max(res,num-min);
            if (num<min){
                min=num;
            }
        }
        return res;
    }
}
