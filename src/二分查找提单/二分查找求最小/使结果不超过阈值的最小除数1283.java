package 二分查找提单.二分查找求最小;

import 二分查找提单.统计公平数对的数目2563;

import java.util.Arrays;

public class 使结果不超过阈值的最小除数1283 {
    public static void main(String[] args) {
       int[] nums={1,2,5,9};
       int threshold=6;
        Solution1283 solution1283 = new Solution1283();
        System.out.println(solution1283.smallestDivisor(nums, threshold));
    }
}
class Solution1283{
    public int smallestDivisor(int[] nums, int threshold) {
        //给一个整数数组nums和一个正整数threshold，
        //选择一个正整数（最小的那个）
        /**
         * 计算于所有小于除数的，他们的和为个数之和
         *
         */
        int len=nums.length;
        Arrays.sort(nums);
        int result=0;


        //递归枚举除数，
        // 这里除数最大只可能大于等于最大值，再大也无法改变和
        //选择除数i，当i递增时，total递减
        int left=1,right=nums[len-1];
        while (left<=right){
            int mid=left+(right-left)/2;
            int count=0;
            for (int num : nums) {
                count+=(num+mid-1)/mid;
            }
            //找
            if (count<=threshold){
                result=nums[mid];
                right=mid-1;
            }else {
                left=mid+1;
            }
        }

        return result;

    }

}
