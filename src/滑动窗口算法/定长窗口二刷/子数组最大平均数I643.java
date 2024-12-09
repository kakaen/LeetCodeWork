package 滑动窗口算法.定长窗口二刷;

public class 子数组最大平均数I643 {
    public static void main(String[] args) {
        Solution643 solution643 = new Solution643();
        int[] arr=new int[1];
        arr[0]=-1;
        System.out.println(solution643.findMaxAverage(arr, 1));
    }
}
class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int left=0,right;
        double result=Double.MIN_VALUE;
        double count=0;
        for (right=0;right<nums.length;right++){
            //入窗口队列
            count+=nums[right];
            if (right<k-1) continue;
            //更新答案值
            result=Math.max(result,count/k);
            //出窗口值
            count-=nums[left++];
        }
        return result;
    }
}
