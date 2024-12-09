package 每日一题.竞赛;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 替换为数位和以后的最小元素Q1 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nu=new int[]{6,6,6,3,7,2,6,5};
        int[] nu3=new int[]{2,3,4,3};
        int[] nu2=new int[]{1,0};
        System.out.println(solution2.maximumTotalSum(nu));
        System.out.println(solution2.maximumTotalSum(nu2));
        System.out.println(solution2.maximumTotalSum(nu3));
    }
}
class Solution1{
    public int minElement(int[] nums){
        int min=Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++){
            nums[i]=func(nums[i]);
            min=Math.min(min,nums[i]);
        }
        return min;
    }
    public int func(int num){
        int total=0;
        while (num!=0){
            total+=num%10;
            num=num/10;
        }
        return total;
    }
}
class Solution2{
    public long maximumTotalSum(int[] maximumHeight) {
        //所有塔高度互不相同,先将最大值进行排序
        Arrays.sort(maximumHeight);
        int n=maximumHeight.length;
        int total=maximumHeight[n-1];
        if (n==1) return total;
        Set<Integer> set=new HashSet<>();
        set.add(maximumHeight[n-1]);
        int min=maximumHeight[n-1];
        for (int i=n-2;i>=0;i--){
            if (maximumHeight[i]>=min){
                maximumHeight[i]=min-1;
            }
            if (maximumHeight[i]<=0) return -1;
            set.add(maximumHeight[i]);
            min=Math.min(maximumHeight[i],min);
            total+=maximumHeight[i];
        }
        return total;
    }
}
