package Top100二刷.子串;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class 滑动窗口的最大值239 {
    public static void main(String[] args) {
        滑动窗口的最大值239 test = new 滑动窗口的最大值239();
        System.out.println(Arrays.toString(test.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int left=0;
        Deque<Integer> deque=new ArrayDeque<>();
        for(int right=0;right<n;right++){
            while (!deque.isEmpty()&&nums[right]>nums[deque.getFirst()]){
                deque.poll();
            }
            deque.push(right);//这个右指针入窗口
            //判断是否到达第一个窗口的长度
            if(right<k-1) continue;
            //说明到达了k的窗口长度，记录更新当前窗口的值
            ans[left]=nums[deque.getLast()];
            left++; //下一个窗口的左指针、
            //判断是否需要移除队列的首元素
            if(left>deque.getLast()){
                deque.pollFirst();
            }
        }
        return ans;
    }
}
