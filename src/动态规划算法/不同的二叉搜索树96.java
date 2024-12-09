package 动态规划算法;

public class 不同的二叉搜索树96 {

}
class Solution96 {
    public int numTrees(int n) {
       //dp[i
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=dp[0]*dp[i-1]+dp[i-1]*dp[0]+dp[(i-1)/2]*dp[(i-1)/2];
        }
        return 0;
    }
}
