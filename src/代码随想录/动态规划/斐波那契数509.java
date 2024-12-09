package 代码随想录.动态规划;

public class 斐波那契数509 {
    public static void main(String[] args) {


    }
    class Solution509{
        public int fib(int n){
            //用一维数组来保存递归的结果
            int[] dp=new int[n+1];
            //dp[i]是第i个数的斐波那契值
            //确定地推公式 dp[i]=dp[i-1]+dp[i-2]
            //4.确定遍历顺序
            //5dp数组如何初始化
            dp[0]=0;dp[1]=1;
            for (int i=2;i<=n;i++){
                dp[i]=dp[i-1]+dp[i-2];
            }
            return dp[n];
        }
    }
}

