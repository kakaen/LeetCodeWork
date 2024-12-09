package Top100.数组;

public class 买卖股票的最佳时机121 {
    public static void main(String[] args) {
        买卖股票的最佳时机121 test = new 买卖股票的最佳时机121();
        System.out.println(test.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
    public int maxProfit(int[] prices){
        int minCost=prices[0]; //最小买入股票成本
        int res=0;
        for (int i=0;i<prices.length;i++){
            res=Math.max(res,prices[i]-minCost);
            minCost=Math.min(prices[i],minCost);

        }
        return res;
    }
}
