package 滑动窗口算法.定长窗口;

public class 子数组最大平均数I643 {
    public static void main(String[] args) {

        Solution643 solution643 = new Solution643();
        int[] nums=new int[]{-1};
        int k=1;
        System.out.println(solution643.findMaxAverage(nums, k));
    }
}
class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        //n
        double ans=-Math.pow(10,4);
        System.out.println(Double.MIN_VALUE>-1);
        double temp=0;
        for (int i=0;i<nums.length;i++){
            //第一步先入窗口
            temp+=nums[i];
            if (i<k-1) continue;
            //第二步更新值
            double avg=temp/k;
            ans=Math.max(ans,avg);
            //第三步，出
            temp-=nums[i-k+1];
        }
        return ans;
    }
}
