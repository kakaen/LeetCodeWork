package 滑动窗口算法.定长窗口;

public class 半径为k的子数组平均值 {
    public static void main(String[] args) {

        Solution2090 solution2090 = new Solution2090();
        int[] nums={7,4,3,9,1,8,5,2,6};
        int k=3;
        for (int average : solution2090.getAverages(nums, k)) {
            System.out.println(average);
        }

    }
}

class Solution2090 {
    public int[] getAverages(int[] nums, int k) {
        int n=nums.length;
        int[] avg=new int[n];

        int count=0;
        //要计算的区间是 2*k+1. i+k - i-k +1这个区间的元素的值
        //窗口大小为2k+1
        for (int i=0;i<n;i++){
            if (i<k||(i+k>=n)){
                avg[i]=-1;
            }
            //第一步：进入窗口,总窗口的大小为2k+1
            count+=nums[i];
            if (i<2*k){
                continue;
            }
            //第二步更新答案
            avg[i-k]=count/(2*k+1);
            //第三步，出
            count=count-nums[i-2*k];
        }
        return avg;
    }
}