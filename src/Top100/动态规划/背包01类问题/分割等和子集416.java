package Top100.动态规划.背包01类问题;

public class 分割等和子集416 {
    public boolean canPartition(int[] nums){
        //只有正整数的非空数组nums。将其分割成两个子集，
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        if (sum%2!=0) return false;
        int target=sum/2;
        int n=nums.length;
       //从背包中选任意个元素和为target,
        // dp[i][j]表示前i个元素是否有和为j的总个数
        boolean[][] dp=new boolean[n+1][target+1];
        //可以实现前i个元素和为0是否可以达到
        for (int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        //dp[i][j]=()可选第i个物品dp[i][j]=dp[i-1][j-weight]
        //dp[i][j]=不选第i个物品，dp[i-1][j]
        for (int i=1;i<=n;i++){
            int weight=nums[i-1];
            for (int j=0;j<=target;j++){
                if (j<weight){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j-weight]||dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
    //采用空间压缩方法实现
    public boolean canPartition2(int[] nums){
        int n=nums.length;
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        if (sum%2!=0) return false;
        sum=sum/2;
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;
        for (int num:nums){
            for (int j=sum;j>=num;j--){
                dp[j]=dp[j]||dp[j-num];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {

    }
}
