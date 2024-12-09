package 二分查找提单.二分法求最大;

import java.util.Arrays;

public class 每个小孩最多能分到多少糖果2226 {
    public static void main(String[] args) {

    }
}
class Solution2226 {
    public int maximumCandies(int[] candies, long k) {
        //candies[i]每堆的糖果数量
        //糖果数量作为每个小孩只能从一堆中选取
        int left=0;
        int right=0;
        int result=0;
        long count=0;
        for (int candie:candies){
            count+=candie;
            if (candie>right) right=candie;
        }
        if (count<k) return 0;
        int n=candies.length;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (check(candies,mid,k)){
                result=mid;
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return 0;
    }
    public boolean check(int[] candies,int mid,long k){
        //candies表示排序好的糖果堆,看能不能把他分成k堆
        long count=0;
        for (int candie:candies){
            if (candie>=mid){
                count=count+candie/mid;
            }
        }
        if (count>=k) return true;
        return false;
    }
}
