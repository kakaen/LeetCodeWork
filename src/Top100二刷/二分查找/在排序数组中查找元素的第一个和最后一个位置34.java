package Top100二刷.二分查找;

import java.util.Arrays;

public class 在排序数组中查找元素的第一个和最后一个位置34 {
    public static void main(String[] args) {
        在排序数组中查找元素的第一个和最后一个位置34 test = new 在排序数组中查找元素的第一个和最后一个位置34();
        int[] ints = test.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 9);
        System.out.println(Arrays.toString(ints));
    }
    public int[] searchRange(int[] nums,int target){
        //给你一个按照非递减顺序
        int[] ans=new int[]{-1,-1};
        int first = binarySearch(nums, target);
        int second = binarySearch(nums, target + 1) - 1;
        if (first>=0&&first<nums.length&&first<=second){
            return new int[]{first,second};
        }
        return ans;
    }
//    public int binarySearch2(int[] )
    //查找元素大于等于target的第一个
    public int binarySearch(int[] nums,int target){
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }

}
