package 二分查找提单;

public class 二分查找704 {
    public static void main(String[] args) {

    }
}
class Solution704 {
    public int search(int[] nums, int target) {
      int left=0,right=nums.length-1;
      //查找第一个大于等于target的值，然后判断L是否==n,如果为n则返回-1
        //如果nums[l]！=target 则返回-1
      while (left<=right){
          int mid=left+(right-left)/2;
          if (nums[mid]<target){
              left=mid+1;
          }else {
              right=mid-1;
          }
      }
      if (left<nums.length){
          return nums[left]==target?left:-1;
      }
      return -1;
    }
}