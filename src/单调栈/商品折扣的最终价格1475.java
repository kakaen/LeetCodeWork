package 单调栈;

import java.util.*;

public class 商品折扣的最终价格1475 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] prices=new int[n];
        for (int i = 0; i < n; i++) {
            prices[i]=scanner.nextInt();
        }
        Solution1435 solution1435 = new Solution1435();
        int[] arr = solution1435.finalPrices(prices);
        System.out.println(Arrays.toString(arr));
    }
}
class Solution1435 {
    public int[] finalPrices(int[] prices) {

        //每个元素右侧的第一个小于等于该元素的值
        //栈需要维护一个递增的状态
        Deque<Integer> stack=new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty()&&prices[stack.peek()]>prices[i]){
                Integer preIndex = stack.pop();
                prices[preIndex]=prices[preIndex]-prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
