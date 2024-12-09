package 代码随想录.数组;

import java.util.Arrays;

public class 有序数组的平方977 {
    public static void main(String[] args) {

    }
}
class Solution977{
    public int[] sortedSquares(int[] nums){
        int n=nums.length;
        int[] res=new int[n];
        int left=0,right=n-1;
        int k=n-1;
        while (left<=right){
            int num1=nums[left]*nums[left];
            int num2=nums[right]*nums[right];
            if (num1<num2){
                res[k--]=num2;
                right--;
            }else {
                res[k--]=num1;
                left++;
            }
        }
        return res;
    }
}
