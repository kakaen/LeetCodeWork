package 二分查找提单;

public class 搜索插入位置35 {
    public static void main(String[] args) {

    }
}
class Solution {
    public int searchInsert(int[] nums, int target) {
        int len=nums.length;
     int left=0,right=len-1;
     while (left<=right){
         int mid=left+(right-left)/2;
         //在数组中找目标值，返回索引，不存在则插入，意思是找第一个大于等于target的数
         //L指向第一个大于等于target的数，如果nums[L]==target则返回。
         //如果都是小于8的数那L指向下标为数组的长度，也可满足
         if (nums[mid]<target){
             left=mid+1;
         }else{
             right=mid-1;
         }
     }
     return left;
    }
}
