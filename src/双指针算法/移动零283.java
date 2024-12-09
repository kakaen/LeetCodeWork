package 双指针算法;

public class 移动零283 {

}
class Solution283 {
    public void moveZeroes(int[] nums) {
        //移动零
        int left=0,right;
        for (right=0;right<nums.length;right++){
            if (nums[right]!=0){
                nums[left++]=nums[right];
            }
        }
        while (left<nums.length){
            nums[left]=0;
        }
    }
}
