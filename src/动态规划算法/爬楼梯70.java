package 动态规划算法;

public class 爬楼梯70 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs2(3));
    }
}
class Solution {

    public int climbStairs(int n) {
        //1.确定dp[i]的含义 爬到第i阶楼梯有dp[i]种方法
        //2.确定递推公式，dp[i]可以有俩个方向 ，一个是dp[i-1]，再跳一个就到了dp[i]
        //另一个是dp[i-2],再跳两个台阶就到了
        //3.如何初始化dp数组
        if (n<=2) return n;
        int[] dp=new int[2];
        dp[0]=1; //到第一阶楼梯只有一种方式
        dp[1]=2; //到第二阶楼梯有两种方式
        for (int i=3;i<=n;i++){
            int sum=dp[0]+dp[1];
            dp[0]=dp[1];
            dp[1]=sum;
        }
        return dp[1];
    }
    public int climbStairs2(int n){
        //dp[i]:表示爬到第i层楼梯的方法总数，
        //第i层可以从前一个状态推出 假设从第i-1层爬上来的，或从第i-2层上来的

        int first=1;
        int second=1;
        //状态压缩，我只需要知道前两个状态的值就可以了

        for (int i=2;i<=n;i++){
            int newF=first+second;
            first=second;
            second=newF;
        }
        return second;
    }
}
