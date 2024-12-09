package 代码随想录.数组;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

public class 二分查找704 {
    public static void main(String[] args) {
        Solution704 solution704 = new Solution704();
        int[] nums={-1,0,3,5,9,12};
        System.out.println(solution704.search(nums, 9));
    }
}
class Solution704{
    public int search(int[] nums,int target){
        int n=nums.length;
        int left=0,right=n-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        if (right+1>=n){
            return -1;
        }
        return nums[right+1]==target?right+1:-1;
    }
}
