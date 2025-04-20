package Top100二刷.单调栈二刷;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures){
        Deque<Integer> deque=new LinkedList<>();
        int n=temperatures.length;
        int[] ans=new int[n];
        //创建一个单调递减的栈
        for (int i=0;i<n;i++){
            int t=temperatures[i];
            while (!deque.isEmpty()&&temperatures[deque.peek()]<t){
                Integer index = deque.pop();
                ans[index]=i-index;
            }
            deque.push(i);
        }
        while (!deque.isEmpty()){
            int i=deque.pop();
            ans[i]=0;
        }
        return ans;
    }

    public static void main(String[] args) {
        每日温度 test = new 每日温度();
        int[] ints = test.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }
}
