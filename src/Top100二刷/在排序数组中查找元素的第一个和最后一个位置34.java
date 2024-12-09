package Top100二刷;

public class 在排序数组中查找元素的第一个和最后一个位置34 {
    public int[] searchRange(int[] nums, int target) {
        //按照非递减顺序排列的整数数组nums，和一个target，
        // 找到给定目标值开始位置和结束位置。
        int[] res=new int[]{-1,-1};
        res[0]=binarySearch(nums,target);
        res[1]=binarySearch(nums,target+1)-1;
        return res;
    }
    //使用二分查找第一个大于target的下标
    public int binarySearch(int[] nums,int target){
        int left=0,right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[mid]<=target){
                left=mid+1;
            }else{
                right=mid+1;
            }
        }
        return left;
    }
}
