package 每日一题;

public class 超过阈值的最少操作数I2065 {
    public static void main(String[] args) {

    }
    public int minOperations(int[] nums,int k){
        //下标从0开始的整数数组nums和一个整数k
        //一次操作中，可以删除nums中的最小元素
        int count=0;
        for (int num:nums){
            if (num<k) count++;
        }
        return count;
    }
}
