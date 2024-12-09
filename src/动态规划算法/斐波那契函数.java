package 动态规划算法;

public class 斐波那契函数 {
}
class Solution509 {
    //使用递归算法进行计算
    public int fib(int n) {
        if (n<=1) return n;
        return fib(n-1)+fib(n-2);
    }
    //使用动态规划
    public int fib2(int n){
        //1. 确定dp数组及下标的含义。 dp[i]的定义为：第i个数的斐波那契数值
        //2.确定递推公式  dp[i]=dp[i-1]+dp[i+1]
        //3.dp数组如何初始化 dp[0]=0;dp[1]=1;
        if (n<=1) return n;
        int[] dp=new int[n+1];
        int[] dp2=new int[2];
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            int sum=dp[0]+dp[1];
            dp[0]=dp[1];
            dp[1]=sum;
        }
        return dp[1];
        //改进，不需要维护整个dp数组，只需要维护两个值

    }
    public int fib3(int n){
        int f0=0,f1=1;
        for (int i=2;i<=n;i++){
            int newF=f0+f1;
            f0=f1;
            f1=newF;
        }
        return f1;
    }
}