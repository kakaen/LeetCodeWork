package Top100二刷.单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 商品折扣后的最终价格1475 {
    public static void main(String[] args) {
        商品折扣后的最终价格1475 test = new 商品折扣后的最终价格1475();
        int[] ints = test.finalPrices(new int[]{8, 4, 6, 2, 3});
        int[] ints2 = test.finalPrices(new int[]{10, 1, 1,6});
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));
    }
    public int[] finalPrices(int[] prices) {
        //商店折扣的最终价格
        int n=prices.length;
        int[] ans=new int[n];
        int[] res=new int[n];
        Deque<Integer> stack=new ArrayDeque<>();
        //递增栈元素
        for (int i=0;i<n;i++){
            while (!stack.isEmpty()&&prices[i]<=prices[stack.peek()]){
                res[stack.peek()]=prices[stack.poll()]-prices[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            res[stack.peek()]=prices[stack.poll()];
        }
        return res;
    }
    }
