package 二分查找提单;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Map;

public class 在排序数组中查找元素的第一个和最后一个位置34 {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
    }
  }
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length;
        int[] result = new int[]{-1, -1};
        //目标值的开始位置 就是找>=target的下标，和>=target+1的下标
//        int start = binarySearch(nums, target);
//        int end = binarySearch(nums, target + 1);
        return result;
    }
    public int find(int[] nums,int target){
        int left=0,right=0;
        int len=nums.length;
        while (right<len){
            int mid=(left+right)/2;
            //找
            if (nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return 0;
    }
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //最终 L的左边都是小于target
        return left;
    }
}
