package 动态规划二刷;

public class 爬楼梯70 {
    public int climbStairs(int n){
        //需要n节才能爬到楼顶
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public int climbStairs2(int n){
        int first=1;
        int sencond=1;
        for (int i=2;i<=n;i++){
            int temp=first+sencond;
            first=sencond;
            sencond=temp;
        }
        return sencond;
    }
}
