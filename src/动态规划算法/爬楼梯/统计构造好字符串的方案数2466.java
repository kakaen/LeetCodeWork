package 动态规划算法.爬楼梯;

public class 统计构造好字符串的方案数2466 {
    public static void main(String[] args) {
        Solution2466 solution2466 = new Solution2466();
        System.out.println(solution2466.countGoodStrings(3, 3, 1, 1));
    }
}
class Solution2466{
    public int countGoodStrings(int low,int high,int zero,int one){
        //走zero节阶梯和走one节阶梯。
        //dp[i]表示长度为i的字符串的构造方法
        long[] dp=new long[high+1];
        int mod=1000000007;
        dp[0]=1;
        for (int i=1;i<=high;i++){
            if (i>=zero) dp[i]=(dp[i]+dp[i-zero])%mod;
            if(i>=one) dp[i]=(dp[i]+dp[i-one])%mod;
        }
        int total=0;
        for (int i=low;i<=high;i++){
            total+=(int)dp[i];
            total=total%1000000007;
        }
        return total;
    }
}
