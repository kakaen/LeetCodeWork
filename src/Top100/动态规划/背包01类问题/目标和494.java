package Top100.动态规划.背包01类问题;

public class 目标和494 {
    public int findTargetSumWays(int[] nums,int target){
        //s:nums的总和，p添加正号的元素和，s-p为添加负数的元素和。target=p-(s-p)=2*p-s;
        //p=(s+t)/2;从nums中选择一些数。必须(s+t)为偶数
        for (int i=0;i<nums.length;i++){
            target+=nums[i];
        }
        if (target<0||target%2!=0) return 0;
        target=target/2;
        int n=nums.length;
        //修改为递推,dp[i][j]表示前i个元素中选取元素，和为j的方案数
        int[][] dp=new int[n+1][target+1]; //表示前i个元素的和为target的方案数量
        dp[0][0]=1;
        int w0=nums[0];
        if (w0<=target) dp[1][w0]=1;
        for (int i=1;i<=n;i++){
            int weight=nums[i-1];
            for (int j=0;j<=target;j++){
                if (j<weight){
                    dp[i][j]=dp[i-1][j];
                }else {
                    //选第i个元素，和不选第i个元素
                    dp[i][j]=dp[i-1][j-weight]+dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
    //优化空间
    public int findTargetSumWays2(int[] nums,int target){
        for (int i=0;i<nums.length;i++){
            target+=nums[i];
        }
        if (target<0||target%2!=0) return 0;
        target=target/2;
        int n=nums.length;
        //采用滚动数组来实现二维dp
        int[] dp=new int[target+1]; //填满j的所有方案，dp[j]=
        dp[0]=1;
        if (nums[0]<=target) dp[nums[0]]=1;
        for (int i=1;i<nums.length;i++){
            int we=nums[i];
            for (int j=target;j>=0;j--){
                if (we>j){
                    continue;
                }
                dp[j]=dp[j-we]+dp[j];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        目标和494 目标和494 = new 目标和494();
        System.out.println(目标和494.findTargetSumWays2(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(目标和494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
