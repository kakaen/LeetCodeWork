package Top100二刷.技巧;

import java.util.Arrays;

public class 下一个排列31 {
    public static void main(String[] args) {
        下一个排列31 test = new 下一个排列31();
        int[] nums=new int[]{1,3,2};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void nextPermutation(int[] nums) {
        //下一个数比当前数大，需要
        //从后往前找第一个 (i,i+1)满足nums[i]<nums[i+1]
        int n=nums.length;
        int reversIndex=0;
        for (int i=n-1;i>0;i--){
            if (nums[i]>nums[i-1]){
                reversIndex=i;
                //找到了大数j,[j,end) //这个一定是逆置的
                for (int j=n-1;j>=i;j--){
                    //从后往前找小数，nums[i-1]<nums[k],
                    if (nums[i-1]<nums[j]){
                        int temp=nums[j];
                        nums[j]=nums[i-1];
                        nums[i-1]=temp;
                    }

                }
                break;
            }
        }
        //进行转置
        int i=reversIndex,j=n-1;
        while (i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }


    }

}
