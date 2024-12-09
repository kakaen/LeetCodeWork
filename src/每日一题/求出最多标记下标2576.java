package 每日一题;

import java.util.Arrays;
import java.util.Scanner;

public class 求出最多标记下标2576 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        Solution2576 solution2576 = new Solution2576();
        System.out.println(solution2576.maxNumOfMarkedIndices(nums));
    }
}
class Solution2576{
    public int maxNumOfMarkedIndices(int[] nums){
        //将数组进行排序
        int n=nums.length;
        boolean[] flag=new boolean[n]; //记录判断是否被标记
//        Arrays.sort(nums);
        //从左往右遍历，选择一个最小的nums[i]，
        //然后找到第一个大于等于的nums[j]
        int res=0;
        for (int i=0;i<n;i++){
            if (flag[i]==true) continue;//已经被标记了；
            int count=2*nums[i]; //找到未被标记的
            for (int j=0;j<n;j++){
                if (flag[j]==false&&count<=nums[j]){
                    flag[i]=true;
                    flag[j]=true;
                    res=res+2;
                    break;
                }
            }

        }
        return res;
    }
}
