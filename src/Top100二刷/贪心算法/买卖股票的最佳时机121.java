package Top100二刷.贪心算法;


public class 买卖股票的最佳时机121 {
    public int maxProfit(int[] prices){
        //选择在某一天买入这只股票
        int minPost=prices[0];
        int maxPrice=0;
        int ans=0;
        for (int i=1;i<prices.length;i++){
            if (prices[i]<minPost){
                minPost=prices[i];
            }else{
                ans=Math.max(ans,prices[i]-minPost);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        买卖股票的最佳时机121 test = new 买卖股票的最佳时机121();
        System.out.println(test.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
