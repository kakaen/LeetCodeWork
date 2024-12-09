package 代码随想录.动态规划;

public class 爬楼梯70 {
    public static void main(String[] args) {

    }
}
class Solution70 {
    public int climbStairs(int n) {
        //dp[i]的含义，指爬到第i阶的方法
        int[] dp=new int[n+1];
        //确定dp的递推公式，dp[i]=dp[i-1]+dp[i-2]. 我可以从第i-1阶楼梯爬一节，或i-2阶爬2节
        //确定初始化状态
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //状态压缩法，压缩空间使用率
    public int climbStairs2(int n){
        int n1=1;
        int n2=1;
        for (int i=2;i<=n;i++){
            int next=n1+n2;
            n1=n2;
            n2=next;
        }
        return n2;
    }
}
