package Top100二刷.单调栈;

import java.util.*;

public class 股票价格跨度901 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        stockSpanner.next(100);
    }
    static class StockSpanner{
        List<Integer> list;
        public StockSpanner() {
            list=new LinkedList<>();
        }

        public int next(int price) {
            Deque<Integer> stack=new ArrayDeque<>(list);
            int ans=1; //自己本身算一个元素
            while (!stack.isEmpty()&&price<=stack.peek()){
                ans++;
                stack.poll();
            }
            //结束吧当前元素插入到list中
            list.add(price);
            return ans;
        }
    }
}
