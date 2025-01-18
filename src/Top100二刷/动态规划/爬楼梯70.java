package Top100二刷.动态规划;

public class 爬楼梯70 {
    public int climbStairs(int n){
        //总共爬n节楼梯才会到达
        int[] dp=new int[n+1];
        //dp[i]表示到达第i节楼梯的总方法数，
        //dp[i]=dp[i-1]+dp[i-2]
        dp[0]=1;dp[1]=1;
        int first=1,second=1;
        for (int i=2;i<=n;i++){
            int count=first+second;
            first=second;
            second=count;
        }
        return second;
    }

    public static void main(String[] args) {
        爬楼梯70 test = new 爬楼梯70();
        System.out.println(test.climbStairs(2));
        System.out.println(test.climbStairs(3));
    }
}
