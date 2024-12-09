package 二分查找提单.二分查找求最小;

import java.util.List;

public class 删除数对后的最小数组长度2856 {
    public static void main(String[] args) {

    }
}
class Solution2856 {
    public int minLengthAfterRemovals(List<Integer> nums) {
        //非递减的整数数组nums
        //选择两个下标i和j，满足nums[i]<nums[j],把
        int n=nums.size(); //确定数组的长度。
        for (int i=0;i<n-1;i++){
            //使用二分查找查询是否存在
            binarySearch(nums.get(i),i,nums);
        }
        return 0;
    }
    //查找第一个大于等于target的下标
    public boolean binarySearch(int target,int index,List<Integer> nums){
        int left=index+1,right=nums.size()-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums.get(mid)<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        if (left<nums.size()) return true;
        return false;
    }
}
