package Top100.数组;

import com.sun.scenario.effect.Brightpass;

public class 搜索旋转排序数组33 {
    public static void main(String[] args) {
        搜索旋转排序数组33 test = new 搜索旋转排序数组33();
        System.out.println(test.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
    public int search(int[] nums,int target){
       //原本都是有序的
        int n=nums.length;
        //现在是两断有序的
        int left=0,right=n-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (target==nums[mid]) return mid;
            if (nums[left]<=nums[mid]){
                if (nums[0]<=target&&target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{

            }
        }
        return -1;
    }
}
