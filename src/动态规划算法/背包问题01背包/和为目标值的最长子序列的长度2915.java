package 动态规划算法.背包问题01背包;

import java.util.*;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class 和为目标值的最长子序列的长度2915 {
    public static void main(String[] args) {
        Solution2915 test = new Solution2915();
        int[] list=new int[]{1,2,3,4,5};
        List<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);
        System.out.println(test.lengthOfLongestSubsequence(objects, 9));
        List<Integer> list2=new ArrayList<>();
        list2.add(1);list2.add(1);list2.add(5);list2.add(4);list2.add(5);
        System.out.println(test.lengthOfLongestSubsequence(list2,3));
    }
}
class Solution2915 {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        return 0;
    }

}