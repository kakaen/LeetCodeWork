package 每日一题;

public class 不包含相邻元素的子序列的最大和3165 {
    public static void main(String[] args) {
        不包含相邻元素的子序列的最大和3165 test = new 不包含相邻元素的子序列的最大和3165();
        int[] nums=new int[]{3,5,9};
        int[][] queries=new int[][]{{1,-2},{0,-3}};
        int[] nums2=new int[]{0,-1};
        int[][] queries2=new int[][]{{0,-5}};
        System.out.println(test.maximumSumSubsequece(nums, queries));
        System.out.println(test.maximumSumSubsequece(nums2, queries2));
    }
    public int maximumSumSubsequece(int[] nums,int[][] queries){
        //一个整数nums，二维数组queries[][]
        int n=queries.length;
        //将nums[]中的元素值设置为x[i]。然后计算查询的答案，nums中不包含相邻元素的子序列的最大和
        long count=0;
        for (int i=0;i<n;i++){
            nums[queries[i][0]]=queries[i][1];
            //如何快速的进行查找子序列的最大值？不包含相邻元素的子序列的最大和。
            count=(count+findSubNum(nums))%1000000007;
        }
        return (int)count;
    }
    public int findSubNum2(int[] nums){
        return 0;
    }
    //每次查询的，子序列的最大和
    public int findSubNum(int[] nums){
        long sum=0;
        int n=nums.length;
        //求不相邻的子序列的最大和。
        int[] dp=new int[n+1]; //dp[i]表示前i个元素的总数和最大的。最后是dp[n]
        //dp[i]=Math.max(dp[i-2]+nums[i-1],dp[i-1])
        dp[0]=0;
        dp[1]=Math.max(dp[0],nums[0]);
        int max=0;
        if (n==1) return dp[1];
        for (int i=2;i<=nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i-1],dp[i-1])%1000000007;
            max=Math.max(dp[i],max);
        }
        return max;
    }
    //如何在O(n)的方法内去解决
    public int maximumSumSubsequece2(int[] nums,int[][] queries){
        int mod=1000000007;
        long sum=0;
        int n=queries.length;
        for (int i=0;i<n;i++){
            nums[queries[i][0]]=queries[i][1]; //进行替换每个
            sum=sum+queries[0][1];
        }
        return (int)sum;
    }
}
