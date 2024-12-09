package 动态规划算法;

public class 买卖股票仅一次121 {
    public static void main(String[] args) {

    }
}
class Solution121{
    public int maxProfit(int[] prices){
        int maxProfit=0; //记录最大利润
        int cost=0; //记录当前的最小成本,维护最小成本。
        for (int price:prices){
            cost=Math.min(cost,price);
            maxProfit=Math.max(maxProfit,price-cost);
        }
        return maxProfit;
    }
}
