package Top100二刷.排序;

import 代码随想录.二叉树理论.二叉树的遍历方式.前序遍历方式;

import java.util.Arrays;

public class 快速排序 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,3,2,7,4,5};
        quicksort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    public static void quicksort(int[] nums,int low,int high){
       if(low>=high){
           return;
       }
       int left=low;
       int right=high;
       int key=nums[left];
       while (left<right){
           while (right>left&&nums[right]>=key){
               right--;
           }
           //找到第一个小于基准元素的值
           nums[left]=nums[right];
           while (left<right&&nums[left]<=key){
               left++;
           }
           //left元素大于
           nums[right]=nums[left];
       }
       //基准值归为
        nums[left]=key;
       //此时左侧的元素都是小于基准值的
       quicksort(nums,low,left-1);
       quicksort(nums,right+1,high);

    }
   public static void quickSort(int[] nums,int low,int high){
        if(low>=high){
            return;
        }
        int left=low,right=high;
        int pivotNum=nums[left];
        while (left<right){
            while (right>left&&nums[right]>=pivotNum){
                right--;
            }
            nums[left]=nums[right]; //right+1--high的值都排列好了
            while (left<right&&nums[left]<=pivotNum){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=pivotNum;
        quickSort(nums, low,left-1);
        quickSort(nums,right+1,high);
   }
}
