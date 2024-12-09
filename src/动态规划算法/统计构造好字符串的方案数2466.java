package 动态规划算法;

import java.awt.peer.SystemTrayPeer;
import java.util.Scanner;

public class 统计构造好字符串的方案数2466 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low=scanner.nextInt();
        int high=scanner.nextInt();
        int zero=scanner.nextInt();
        int one=scanner.nextInt();
        Solution2466 solution2466 = new Solution2466();
        System.out.println(solution2466.countGoodStrings(low, high, zero, one));
    }
}
class Solution2466 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long count=0;
        //dp数组 dp[i]就是构造长度为i的字符串的个数
        //每次可以爬zero或one个台阶，返回爬到
        long[] dp=new long[high+1];
        //长度为high的字符串的种类是由 high-zero的种类加 high-one的种类相加的
        //dp[i]=dp[i-zero]+dp[i-one];
        //找zero和one中的最小元素
        int min=Math.min(zero,one);
        dp[0]=0;
        dp[min]=1;
        //长度小于min的都为0；
        for (int i=min+1;i<=high;i++){
            dp[i]=dp[i-zero]+dp[i-one];
        }
        for (int i=1;i<=high;i++){
            if (i>=zero) dp[i]=dp[i]+dp[i-zero];
        }
        return (int)(count%1000000007);
    }
}
