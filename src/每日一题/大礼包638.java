package 每日一题;

import java.util.List;

public class 大礼包638 {
    public int shoppingOffers(List<Integer>price,List<List<Integer>> special,List<Integer> needs){
        //所有商品数量不可以超过need[i]
        int[] array =price.stream().mapToInt(Integer::valueOf).toArray();
        int n=price.size();
        //有很多种大礼包special[i]，每种大礼包中n个物品对应的数量为special[i][j]
        //先判断大礼包的价格和单买哪个便宜
        int singlePrice=0;
        int specialPrice=0;
        //int[][]dp=new int[n][n]; dp[i][j]表示第i个物品购买的
        //所有数组所需的物品数量为need
        //遍历每种大礼包，看看是否便宜
        for (List<Integer> bag:special){
            for (int i=0;i<n;i++){

            }
        }
        return 0;
    }
}
