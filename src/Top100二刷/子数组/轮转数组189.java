package Top100二刷.子数组;

import java.util.Arrays;

public class 轮转数组189 {
    public void rotate(int[] nums,int k){

        int n=nums.length;
        if (n==1) return;
        k=k%n;
        //
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);

    }
    public void reverse(int[] nums,int start,int end){
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
