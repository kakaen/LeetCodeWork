package Top100二刷;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

public class 最大子数组和53 {
    public int maxSubArray(int[] nums){
        //最大和的连续子数组
        int res=Integer.MIN_VALUE;
        int count=0;
        for (int num:nums){
            if (count>0){
                count+=num;
            }else{
                count=num;
            }
            res=Math.max(count,res);
        }
        return res;
    }

    public static void main(String[] args) {
        最大子数组和53 test = new 最大子数组和53();
        System.out.println(test.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
