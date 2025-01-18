package Top100二刷.二分查找;

import java.util.Arrays;

public class 两个数组间的距离值1385 {
    public int findTheDistanceValue(int[] arr1,int[] arr2,int d){
        //请你返回两个数组之间的距离值
        //a1+d<a2<a1-d;
        // a2<=a1-d(找到a2>=a1-d的下标), a2>=a1+d;
        int count=0;
        //先将a2进行排序
        Arrays.sort(arr2);
        for (int i=0;i<arr1.length;i++){
            if (!binarySearch(arr2,arr1[i]+d,arr1[i]-d)){
                count++;
            }
        }
        return count;
    }
    //从arr2中找元素大于等于low且小于等于high的元素
    public boolean binarySearch(int[] nums,int low,int high){
        int l=0,r=nums.length-1;
        while (l<=r){
            int m=l+(r-l)/2;
            if (nums[m]>=low&&nums[m]<=high){
                return true;
            }else if (nums[m]<low){
                l=m+1;
            }else if (nums[m]>high){
                r=m-1;
            }
        }
        return false;
    }
}
