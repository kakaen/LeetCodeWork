package Top100.二分查找相关;

public class 搜索插入位置35 {
    public static void main(String[] args) {
        //排序数组和一个目标值
        Solution35 solution35 = new Solution35();
        int[] nums={1,3,5,6};
        int target=2;
        System.out.println(solution35.searchInsert(nums, target));
    }
}
class Solution35{
    public int searchInsert(int[] nums,int target){
        int n=nums.length;
        int left=0,right=n-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target) left=mid+1;
            if (nums[mid]>target) right=mid-1;
            if (nums[mid]==target){return mid;}
        }
        return right+1;
    }
    public int searchInsert2(int[] nums,int target){
        int n=nums.length;
        int left=0,right=n-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target) left=mid+1;
            else right=mid-1; //找到第一个大于等于target的位置
        }
        return left; //left指向第一个大于等于target的位置
    }
}
