package Top100二刷.技巧;

public class 只出现一次的数字136 {
    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
        //给你一个非空整数数组nums，除了某个元素
        //O(1)级别的常量空间
        int ans=0;
        for (int num:nums){
            ans=ans^num;
        }
        return ans;
    }
    public int majorityElement(int[] nums) {
        //多数元素是指在数组中出现次数大于[n/2]的元素
        int n=nums.length;
        int ans=0;
        int x=0;//众数,设x是众数
        int votes=0; //votes是投票数
        for (int num:nums){
            if (votes==0) x=num;
            if (num==x){
                votes++;
            }else{
                votes--;
            }
        }
        return x;
        //O(n),O(1)的算法
        //总共有n个数，nums[i]来找
    }
}
