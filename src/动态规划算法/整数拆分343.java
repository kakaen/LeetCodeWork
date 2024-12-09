package 动态规划算法;

public class 整数拆分343 {
    public static void main(String[] args) {

    }
}

class Solution343{
    public int intergerBreak2(int n){
        //dp[i] 表示正整数i拆分为至少两个正整数的和的最大乘积
        int[] dp=new int[n+1];
        //初始化状态
        dp[0]=0;dp[1]=1;
        //将正整数i拆分出第一个正帧数是1<=j<=i。
        //将正整数拆分成j和i-j.且i-j不再拆分
        for (int i=2;i<=n;i++){
            int curMax=0;
            for (int j=1;j<i;j++){
                curMax=Math.max(curMax,Math.max(j*(i-j),j*dp[i-j]));
            }
        }

        return dp[n];
    }
    public int intergerBreak(int n){
        if (n<=1) return n;
        //可以拆分成
        int[] dp=new int[n+1];
        //dp[i]表示将正整数i拆分成至少两个正整数的和之后，这些正整数的最大乘积
        //设对正整数i拆分出的第一个正整数是j(1<=j<i)则有以下方案
        //将i拆分为 j和 i-j 且i-j不再拆分成多个整数。此时的乘积最大值为j*(i-j)
        //二：将i拆分为j和i-j后，i-j继续拆分 此时的乘积最大值为j*dp[i-j]
        //3.dp初始化
        dp[0]=0;dp[1]=0;
        for (int i=2;i<n;i++){
            int curMax=0;
            for (int j=1;j<i;j++){
                curMax=Math.max(curMax,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i]=curMax;
        }

        return dp[n];
    }
}