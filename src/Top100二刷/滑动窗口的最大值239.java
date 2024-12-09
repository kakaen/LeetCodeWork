package Top100二刷;

import java.util.*;

public class 滑动窗口的最大值239 {
    public int[] maxSlidingWindow(int[] nums,int k){
        int n=nums.length;
        int[] res=new int[n-k+1];
        int left=0; //左边界
        int max=Integer.MIN_VALUE; //记录窗口的最大值
        //如何求k个数中的最大值,使用Priorityqueue优先级队列会超时
        PriorityQueue<Integer> windows = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int right=0;right<n;right++){
            //右边界向右移动一位
            windows.add(nums[right]);
            if (right<k-1){
                continue;
            }
            //将当前窗口的最大值放入结果集
            res[left]=windows.peek();
            //将左边界右移一位,删除窗口左边界的值
            windows.remove(nums[left]);
            left++;
        }
        return res;
    }
    public int[] maxSlidingWindow2(int[] nums,int k){
        int n=nums.length;
        int[] res=new int[n-k+1];
        int left=0; //左边界
        int max=Integer.MIN_VALUE; //记录窗口的最大值
        //如何求k个数中的最大值,使用Priorityqueue优先级队列会超时
        //使用单调队列，来求滑动窗口中的最大值
        Deque<Integer> deque=new LinkedList<>(); //单调栈来实现

        for (int right=0;right<n;right++){
            //右边界向右移动一位，
            // 如果当前元素的值大于队尾元素的值，则队尾元素的值永远不可能为最大值
            //将其弹出栈，
            while (!deque.isEmpty()&&nums[right]>=nums[deque.getLast()]){
                deque.pollLast();//如果当前右边界的值大于队列头部
            }
            deque.offerLast(right);
            if (right<k-1){
                continue;
            }
            //判断队首的值是否超出界限，如果超出界限则去除，找到第一个在窗口界限的
            while (deque.peekFirst()<right-k+1){
                deque.pollFirst();
            }
            //将当前窗口的最大值放入结果集
            res[right-k+1]=nums[deque.peekFirst()];

        }
        return res;
    }
    public int[] maxSlidingWindow3(int[] nums,int k){
        int n=nums.length;
        int[] res=new int[n-k+1];

        //使用一个单调递增栈来维护窗口的最大值
        //栈内元素存储元素的下标
        Deque<Integer> deque=new LinkedList<>();
        for (int right=0;right<n;right++){
            while (!deque.isEmpty()&&nums[deque.peekLast()]<nums[right]){
                deque.pollLast();
            }
            //当前元素入栈
            deque.addLast(right);
            if (right<k-1) continue;
            //查找当前queue中的对头元素是否符合下标
            while (deque.peekFirst()<right-k+1){
                deque.pollFirst();
            }
            res[right-k+1]=nums[deque.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        滑动窗口的最大值239 test = new 滑动窗口的最大值239();
        int[] ints = test.maxSlidingWindow3(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        int[] ints2 = test.maxSlidingWindow3(new int[]{1},1);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));
    }
}
