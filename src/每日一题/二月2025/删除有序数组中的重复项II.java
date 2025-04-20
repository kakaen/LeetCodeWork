package 每日一题.二月2025;

import java.util.Arrays;

public class 删除有序数组中的重复项II {
    public int removeDuplicates(int[] nums) {
       int n=nums.length;
       if (n<=2) return n;
       int slow=2,fast=2; //slow指向待插入的元素位置，fast指向下一个可以插入的元素位置
        while (fast<2){
            //如果nums[slow]==nums[slow-1]; nums[slow-1]=nums[slow-2]
            if (nums[slow-2]!=nums[slow]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        删除有序数组中的重复项II test = new 删除有序数组中的重复项II();
        int[] nums1=new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(test.removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));
        int[] nums2=new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(test.removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));
        int[] nums3=new int[]{0,0,0,0,0,0,0,3,3};
        System.out.println(test.removeDuplicates(nums3));
        System.out.println(Arrays.toString(nums3));
    }
}
