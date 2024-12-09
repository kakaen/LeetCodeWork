package 滑动窗口算法.定长窗口;

public class 大小为K且平均值大于等于阈值的子数组数目1343 {
    public static void main(String[] args) {
        Solution1343 solution1343 = new Solution1343();
        int[] arr={2,2,2,2,5,5,5,8};
        int k=3,thre=4;
        System.out.println(solution1343.numOfSubarrays(arr, k, thre));
    }
}
class Solution1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        //整数数组arr，和两个整数k
        //返回长度为k，且平均值大于等于
        int count=0;
        int temp=0;
        for (int i=0;i<arr.length;i++){
            temp+=arr[i];
            if (i<k-1) continue;
            //更新答案
            if (temp/k>=threshold){
                count++;
            }
            //出
            temp-=arr[i-k+1];
        }
        return count;
    }
}
