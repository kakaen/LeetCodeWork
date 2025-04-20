package Top100二刷.动态规划.买股票的最佳时机;

public class 买股票的最佳时机121 {
    public int maxProfit(int[] prices){
        int minCost=Integer.MAX_VALUE;
        int maxProfit=Integer.MIN_VALUE;
        int ans=0;
        for (int i=0;i<prices.length;i++){
            if (minCost>prices[i]) minCost=prices[i];
            maxProfit=Math.max(prices[i]-minCost,maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        买股票的最佳时机121 test = new 买股票的最佳时机121();
        System.out.println(test.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(test.maxProfit(new int[]{7,6,4,3,1}));
    }
}
