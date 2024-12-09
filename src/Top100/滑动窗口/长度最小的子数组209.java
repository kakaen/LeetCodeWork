package Top100.滑动窗口;

public class 长度最小的子数组209 {
    public static void main(String[] args) {
        长度最小的子数组209 test = new 长度最小的子数组209();
        System.out.println(test.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
    public int minSubArrayLen(int target,int[] nums){
        //长度大于等于target的最小长度子数组
        int n=nums.length;
        int res=n+1;
        int left=0,right=0;
        int count=0;
        for (right=0;right<n;right++){
            count+=nums[right]; //入窗口
            //判断当前窗口是否满足要求，满足的话缩减左指针，寻找最优解
            while (left<=right&&count>=target){
                res=Math.min(res,right-left+1);
                count-=nums[left];
                left++;
            }
            //结束
        }
        return res==n+1?0:res;
    }
}
