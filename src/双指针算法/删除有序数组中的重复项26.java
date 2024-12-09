package 双指针算法;

public class 删除有序数组中的重复项26 {
}
class Solution26 {
    public int removeDuplicates(int[] nums) {
        int left=0,right;
        for(right=0;right<nums.length;right++){
            //left指向当前最后一个元素
            if (nums[right]!=nums[left]){
                left++;
                nums[left]=nums[right];
            }
        }

        return  left+1;
    }
}