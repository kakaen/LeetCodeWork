package Top100.数组;

public class 买卖股票的最佳时机II122 {
    public int maxProfit(int[] prices){
        //题目转化为找x个长度为1的区间
        int ans=0;
        int n=prices.length;
        for (int i=1;i<n;i++){
            ans+=Math.max(0,prices[i]-prices[i-1]);
        }
        return ans;
    }
    //使用动态规划的算法
    public int maxProfit2(int[] price){
        //
        return 0;
    }
}
