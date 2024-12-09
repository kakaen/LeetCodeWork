package 贪心算法;

public class 买卖股票的最佳时机122 {
}

class Solution122 {
    public int maxProfit(int[] prices) {
        //贪心算法， 7,1,5,3,6,4，在第二天进行买入，第三天卖出
        //把最终的利润进行分解，第0天卖，第3天卖，price[3]-price[0]
        int[] diffprices=new int[prices.length-1];
        int sum=0;
        //获取差
        for (int i=1;i<prices.length;i++){
            int dif=prices[i]-prices[i-1];
            if (dif>0) sum+=dif;
        }
        //
        return sum;
    }
}