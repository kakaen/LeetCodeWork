package 双指针算法;

public class 移除元素27 {

}
class Solution {
    public int removeElement(int[] nums, int val) {
        //双指针快慢指针，慢指针指向当前不等于val的位置，快指针进行遍历
        int left=-1,right=0;
        for (right=0;right<nums.length;right++){
            if (nums[right]==val){
                continue;
            }else {
                left++;
                nums[left]=nums[right];
            }
        }
        return left+1;
    }
}