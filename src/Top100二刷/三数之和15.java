package Top100二刷;

import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class 三数之和15 {
    public List<List<Integer>> threeSum(int[] nums){
       //排序+双指针，不重复的本质是 第二重循环的元素不小于第一重
        //（a,b,c）满足 a<=b<=c
        //对于每一层循环也必须不相同
        int n=nums.length;
        Arrays.sort(nums); //先将数组按顺序排序
        //枚举元素a
        for (int i=0;i<n-2;i++){
            //需要和上次枚举的元素不一样
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        三数之和15 test = new 三数之和15();
        List<List<Integer>> lists = test.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list:lists){
            System.out.println(list.toString());
        }
    }
}
