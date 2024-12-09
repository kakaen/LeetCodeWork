package 代码随想录.栈和队列;

import java.util.*;

public class 滑动窗口的最大值239 {
    public static void main(String[] args) {

    }
}
class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1]; //共n-k+1个数
        int left = 0;
        //窗口值可以获取到最大值,单调栈来找最大值，判断栈顶元素是否
        //每轮窗口滑动时删除nums[left],需要将deque中的元素一起删除
        ArrayDeque<Integer> deque = new ArrayDeque<>(); //双端队列，元素单调递增，每轮窗口滑动添加l元素nums
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> window = new HashMap<>();
        for (int right = 0; right < n; right++) {
            int num = nums[right];
            //右边界入窗口值；将nums[right]入栈，需要将当前栈中的所有
            while (!deque.isEmpty() && deque.getLast() < nums[right]) {
                deque.pop();
            }
            window.put(num, window.getOrDefault(num, 0) + 1);
            if (right < k - 1) continue;
            //记录答案,如何在窗口中找到最大值,如何将获取窗口内最大值的时间复杂度降为从O(k)将为1
            if (nums[right] > max) max = nums[right];

            for (Integer key : window.keySet()) {
                if (key > max) {
                    max = key;
                }
            }
            result[right - k + 1] = max;
            //左指针的值出窗口
            if (window.get(nums[left]) == 1) {
                window.remove(nums[left]);
            } else {
                window.put(nums[left], window.get(nums[left]) - 1);
            }
            left++;
        }
        return result;
    }
}
