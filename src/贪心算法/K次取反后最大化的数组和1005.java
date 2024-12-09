package 贪心算法;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class K次取反后最大化的数组和1005 {
}
class Solution1005{
    public int largestSumAfterKNegations(int[] nums,int k){
        //当K小于负数个数时
        //排序,按绝对值大小进行排序
        Integer[] integers = new Integer[nums.length];
        for (int i=0;i<nums.length;i++){
            integers[i]=nums[i];
        }
        Arrays.sort(integers,(o1,o2)->{return Math.abs(o1)-Math.abs(o2);});
        for (int i=0;i<integers.length;i++){
            if (k>0&&integers[i]<0){
                integers[i]=-integers[i];
                k--;
            }
        }
        //如果k还大于0，那么翻转数值最小的元素
        while (k>0){
            integers[integers.length-k]=-integers[integers.length-k];
            k--;
        }
        int sum=0;
        for (int num:integers){
            sum+=num;
        }
        return sum;
    }
}
