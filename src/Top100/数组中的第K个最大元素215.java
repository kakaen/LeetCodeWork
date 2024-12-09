package Top100;

import sun.security.mscapi.CPublicKey;

public class 数组中的第K个最大元素215 {
    public static void main(String[] args) {

    }
}
class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        //第k个最大元素，而不是第k个不同的元素
        int n=nums.length;
        int result=0;
        for (int num:nums){
            if (num==k){

            }
        }
        return 0;
    }
    public int quickSelect(int[] nums,int left,int right,int k){
        int i=left,j=right;
        int privot=nums[left];
        while (i<j){
            //从右往左找小于基准值的数
            while (i<j&&(nums[j]>privot)){
                j--;
            }
            //从左往右找大于基准值的数
            while (i<j&&(nums[i]<privot)){
                i++;
            }
            if (nums[left]==nums[right]){
                left++;
            }else{
                int temp=nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
            }

        }
        return 0;
    }
}
