package 动态规划算法;

public class 爬楼梯问题70 {
    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        System.out.println(solution70.climbStairs(2));
    }
}
class Solution70{
    public int climbStairs(int n){
        //每次可以爬一节或2节楼梯
        //dp[n]=dp[n-1]+dp[n-2]
        if (n<=1) return n;
        int[] dp=new int[n+1]; //dp[i]表示爬到第i层楼梯的方法个数
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //空间状态压缩
    public int climbStairs2(int n){
        int num1=1;
        int num2=1;
        int res=0;
        for (int i=2;i<=n;i++) {
            res = num1 + num2;
            num1 = num2;
            num2 = res;
        }
        return res;
    }
}
