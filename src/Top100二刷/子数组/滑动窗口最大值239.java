package Top100二刷.子数组;

import java.util.*;

public class 滑动窗口最大值239 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]= scanner.nextInt();
        }
        int[] ans=maxSlidingWindow2(nums,k);
        for (int num:ans){
            System.out.print(num+" ");
        }
    }
    public static int[] maxSlidingWindow(int[] nums,int k){
        //有个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
        // 只能看到在滑动窗口内的k个数字。滑动窗口每次只向右移动一位
        int left=0,right=0;
        int n=nums.length;
        int[] ans=new int[n-k+1];
        //使用
        Queue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //这里的难点是如何求k窗口中的最大值
        for (right=0;right<n;right++){
            priorityQueue.add(nums[right]);
            if (right<k-1) continue;
            //查找这k个数中的最大值
            ans[left]=priorityQueue.peek();
            //left右移动
            priorityQueue.remove(nums[left]);
            left++;
        }
        return ans;
    }
    public static int[] maxSlidingWindow2(int[] nums,int k){
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int left=0,right=0;
        //求滑动窗口中的最大值
        //当滑动窗口向右移动时，只要i还在窗口中，那j一定也
        //i在j的左侧，并且i对应的元素不大于j对应的元素(nums[i]<=nums[j])，当滑动窗口右移的时候，只要i还在窗口中，那j也一定还在窗口中
        //由于nums[j]的存在，nums[i]一定不会是滑动窗口中的最大值。
        //我们可以使用一个队列存储所有还没有被移除的下标。在队列中，这些下标按照从小到大的顺序被存储。
        //并且他们在数组nums中对应的值是严格单调递减的
        Deque<Integer> deque=new ArrayDeque<>(); //双端队列
        for (right=0;right<n;right++){
            //保证双端队列是单调递减的
            while (!deque.isEmpty()&&nums[deque.peekLast()]<=nums[right]){
                //弹出队尾，因为我right进来后，你们不管怎么退出，最大的元素还是我
                deque.pollLast();
            }
            deque.addLast(right);
            //判断当前队列中的队首是否有效
            if (deque.peekFirst()<right-k+1){
                deque.pollFirst();
            }
            if (right>=k-1){
                ans[right-k+1]=nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
