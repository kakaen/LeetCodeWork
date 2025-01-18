package Top100二刷.滑动窗口.定长滑动窗口;

public class 大小为K且平均值大于等于阈值的子数组数目1343 {
    public static void main(String[] args) {
        大小为K且平均值大于等于阈值的子数组数目1343 test = new 大小为K且平均值大于等于阈值的子数组数目1343();
        System.out.println(test.numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
    }
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        //大小为k
        int sum=0;
        int ans=0;
        int l=0;
        for (int r=0;r<arr.length;r++){
            //1.入窗口
            sum+=arr[r];
            if (r<k-1) continue;
            //2.更新值
            if ((1.0*sum/k)>=threshold) ans++;
            //3.右移动左指针
            sum-=arr[l++];
        }
        return ans;
    }
}
