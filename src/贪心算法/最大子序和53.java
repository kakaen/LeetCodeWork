package 贪心算法;

public class 最大子序和53 {
    public static void main(String[] args) {

    }
}
class Solution53 {
    public int maxSubArray(int[] nums) {

        //使用暴力法解决会超出时间限制
        int left=0;int right=0;
        int result=Integer.MIN_VALUE;
        //暴力法：
        for (int i=0;i<nums.length;i++){
            int count=0;
            for (int j=i;j<nums.length;j++){
                count+=nums[j];
                result=count>result?count:result;
            }

        }
        return result;
    }
    //贪心算法的解题,
    public int maxSubArray3(int[] nums){
        //如果-2,1在一起，则计算起点的时候，一定是从1开始计算的，因为负数只会拉低总和
        //局部最优，当前连续和为负数时立即放弃，从下一个元素重新计算连续和
        int ans=Integer.MIN_VALUE;
        int sum=0;
        for (int i=0;i<nums.length;i++){
            if (sum>0){
                sum+=nums[i];
            }else {
                sum=nums[i];
            }
            ans=sum>ans?sum:ans;
        }
        return ans;
    }
    //动态规划方法
    public int maxSubArray2(int[] nums){
        int ans=nums[0];
        int sum=0;
        for (int num:nums){
            if (sum>0){
                sum+=num;
            }else {
                sum=num;
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}

