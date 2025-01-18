package Top100二刷.单调栈;

import java.util.*;

public class 每日温度739 {
    //从左到右的开始
    public int[] dailyTemperatures(int[] temperatures) {
      //单调递增栈
        Deque<Integer> stack=new ArrayDeque<>();
        int n=temperatures.length;
        int[] ans=new int[n];
        for (int i=0;i<n;i++){
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                ans[stack.peek()]=i-stack.poll();
            }
            stack.push(i);
        }
        return ans;

    }

    public static void main(String[] args) {
        每日温度739 test = new 每日温度739();
        int[] ints = test.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }
    }
