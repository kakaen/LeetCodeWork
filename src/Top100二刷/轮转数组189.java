package Top100二刷;

import java.util.Arrays;

public class 轮转数组189 {
    public static void main(String[] args) {
        轮转数组189 test = new 轮转数组189();
        int[] nums=new int[]{1,2,3,4,5,6,7};
        test.rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }
    public void rotate(int[] nums,int k){
        if (nums.length==1) return;
        //将数组向右轮转k
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int start,int end){
        //将数组中的start到end进行翻转
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
