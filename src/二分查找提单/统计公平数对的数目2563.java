package 二分查找提单;

import java.util.Arrays;

public class 统计公平数对的数目2563 {
    public static void main(String[] args) {
        Solution2563 solution2563 = new Solution2563();
        int[] nums={0,1,7,4,4,5};
        int lower=3,upper=6;
        System.out.println(solution2563.countFairPairs(nums, 3, 6));
    }
}
class Solution2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // （i，j), low<=nums[i]+nums[j]<=upper
        //查寻 lower-nums[i]<=nums[j]<=upper-nums[i]
        int len=nums.length;
        long count=0;
        Arrays.sort(nums);
        for (int i=0;i<len-1;i++){
            int left = binarySearch(nums,i+1, lower - nums[i]-1);
            //小于等于upper-nums[i] 第一个大于 upper-nums[i]的下标 再减一
            int right=binarySearch(nums,i+1,upper - nums[i])-1;
//            if ((left>=0&&left<copyNums.length)&&(right>=0&&right<copyNums.length)&&(right-left+1>=0)){
//                count+=(right-left)+1;
//            }
            count+=(right-left)+1;
        }
        return count;
    }
    //二分查找,start，由于i<j,因此查询j下标时直接从i+1为初始下标
    public int binarySearch(int[] nums,int start,int target){
        int left=start,right=nums.length-1;
        int count=0;
        //查找第一个大于target的下标
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<=target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return left;
    }
}
