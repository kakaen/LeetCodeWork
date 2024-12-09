package 贪心算法.从最小最大开始贪心;

import java.util.*;

public class 非递增顺序的最小子序列1403 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        Solution1403 solution1403 = new Solution1403();
        List<Integer> list = solution1403.minSubsequence(nums);
        for (Integer i : list) {
            System.out.print(i+" ");
        }
    }
}
class Solution1403 {
    public List<Integer>minSubsequence(int[] nums) {
        //将数组进行排序
        Arrays.sort(nums);
        int total=0;
        for (int num : nums) {
            total+=num;
        }
        int subCount=0;
        List<Integer> result=new ArrayList<>();
        for (int i=nums.length-1;i>=0;i--){
            result.add(nums[i]);
            subCount+=nums[i];
            total-=nums[i];
            if (subCount>total){
                break;
            }
        }
        return result;
    }
}