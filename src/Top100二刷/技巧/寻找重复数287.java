package Top100二刷.技巧;

import java.util.Arrays;

public class 寻找重复数287 {
    public static void main(String[] args) {
        寻找重复数287 test = new 寻找重复数287();
        int[] nums=new int[]{1,3,4,2,2};
        System.out.println(test.findDuplicate(nums));
    }
    public int findDuplicate2(int[] nums){
        //采用线性时间复杂度O(n)的解决方法
        int slow=0,fast=0;
        slow=nums[slow];
        fast=nums[nums[fast]];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]]; //快指针走两格
        }
        slow=0;
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;


    }
    public int findDuplicate(int[] nums) {
        //数字都在[1,n]范围内，不修改数组nums
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]==nums[i+1]) return nums[i];
        }
        return 0;
    }
}
