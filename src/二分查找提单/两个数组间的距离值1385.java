package 二分查找提单;

import java.util.Arrays;

public class 两个数组间的距离值1385 {
    public static void main(String[] args) {

    }
}
class Solution1385 {
    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        //暴力做法，不存在任何实现arr2[j]-d<=arr1[i]<=arr2[j]+d
        int count=0;
        for (int num1 : arr1) {
            boolean flag=false; //表示是否存在距离元素
            for (int num2 : arr2) {
                if (num1>=num2-d&&num1<=num2+d){
                    flag=true;
                    break;
                }
            }
            if (flag) count++;
        }
        return count;

    }
    //第二种方法，使用二分查找，判断arr2中是否存在arr2[j]-d<=arr1[i]<=arr2[j]+d
    //即arr1[i]-d<=arr2[j]<=arr1[i]+d;
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count=0;
        //首先使用二分查找，在arr2中进行查找，因此需要把arr2进行排序
        Arrays.sort(arr2);
        for (int num1:arr1){
            //在arr2中使用二分查找，查看是否存在元素arr1[i]-d<=arr2[j]<=arr1[i]+d;
            if (!binarySearch(arr2,num1-d,num1+d)){
                count++;
            }
        }
        return count;
    }
    public boolean binarySearch(int[] nums,int low,int high){
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            //如果中点元素在[low,high]的范围内，则返回true
                if (nums[mid]>=low&&nums[mid]<=high){
                    return true;
                } else if (nums[mid]<low) {
                    //如果当前mid的值小于low，则说明 0--mid的值 都小于low，
                    // 因此我们在查找 mid+1,right的值的大小
                    left=mid+1;
                } else if (nums[mid]>high) {
                    //如果当前mid的值大于high，说明 mid---right的值都大于high
                    //因此我们更新区间为 low,mid-1.
                    right=mid-1;
                }
        }
        return false;
    }
}