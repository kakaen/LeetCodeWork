package 滑动窗口算法.定长窗口二刷;

public class 大小为K且平均值大于等于阈值的子数组数目1343 {
    public static void main(String[] args) {

    }
}
class Solution1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result=0;
        long count=0;
        int left=0,right=0;
        for (right=0;right<arr.length;right++){
            //入窗口
            count+=arr[right];
            if (right<k-1) continue;
            //更新值
            if (count/k>=threshold) result++;
            //出窗口值
            count-=arr[left++];
        }
        return result;
    }
}
