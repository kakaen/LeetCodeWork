package Top100.动态规划.背包01类问题;

import java.util.Arrays;

public class 将一个数字表示成幂的和的方案数27887 {
    public int numberOfWays(int n,int x){
        //返回将n表示为 n1^x+n2^x+n3^x;
        //就是从[1---n]中选取元素，使其和为n的方案数
        //dp[i][j]表示从前i个元素中选取，和为j的最多方案数
        long[][] dp=new long[n+1][n+1];
        int offset=1000000007;
        for (int i=0;i<=n;i++){
            Arrays.fill(dp[i],0);
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        //递推公式，dp[i][j]=dp[i-1][j]+dp[i-1][j-num]
        for (int i=1;i<=n;i++){
            int num=(int)Math.pow(i,x);
            for (int j=0;j<=n;j++){
                if (j<num){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=(dp[i-1][j-num]+dp[i-1][j])%offset;

                }
            }
        }
        return (int)dp[n][n];
    }
    //采用空间状态压缩的方法
    public int numberOfWays2(int n,int x){
        int[] dp=new int[n+1];
        dp[0]=1;
        for (int i=1;i<=n;i++){
            int num=(int) Math.pow(i,x);
            for (int j=n;j>=num;j--){
                dp[j]=(dp[j]+dp[j-num])%1000000007;
            }
        }
        return dp[n];
    }
    //采用状态压缩
    public int numberOfWay3(int n,int x){
        //将n看成一个背包,dp[ii]表示背包为i的不同方法次数
        long[] dp=new long[n+1];
        dp[0]=1;
        for (int i=1;Math.pow(i,x)<=n;i++){
            int num=(int)Math.pow(i,x);
            for (int j=n;j>=num;j--){
                dp[j]=(dp[j-num]+dp[j]); //选或不选
            }
        }
        return (int)(dp[n]%1000000007);
    }

    public static void main(String[] args) {
        System.out.println((int)Math.pow(2,2));
        将一个数字表示成幂的和的方案数27887 test = new 将一个数字表示成幂的和的方案数27887();
        System.out.println(test.numberOfWays2(10, 2));
        System.out.println(test.numberOfWays2(4, 1));
    }
}
