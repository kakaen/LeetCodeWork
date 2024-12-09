package 每日一题;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 长度为K的子数组的能量值II3255 {
    public static void main(String[] args) {
        长度为K的子数组的能量值II3255 test = new 长度为K的子数组的能量值II3255();
        System.out.println(Arrays.toString(test.resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3)));
    }
    public int[] resultsArray(int[] nums,int k){
        //所有元素都是依次连续上升的，那能量值为最大的元素
        int n=nums.length;
        int[] res=new int[n-k+1];
        Arrays.fill(res,-1);
        int count=0;
        for (int i=0;i<n;i++){
            if (i>0&&nums[i]==nums[i-1]+1){
                count++;
            }else{
                count=1;
            }
            if (count>=k){
                res[i-k+1]=nums[i];
            }
        }
        return res;
    }
}
