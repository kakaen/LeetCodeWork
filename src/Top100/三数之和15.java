package Top100;

import java.util.*;

public class 三数之和15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        Solution15 solution15 = new Solution15();
        List<List<Integer>> lists = solution15.threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println(" ");
        }
    }
}
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int k=0,i,j;
        int n=nums.length;
        List<List<Integer>> result=new ArrayList<>();
        //固定指针k,枚举a
        for (k=0;k<n;k++){
            //需要和上次枚举的不一样
            if (k>0&&nums[k]==nums[k-1]){
                continue;
            }
            //c对应的指针初始指向数组的最右端
            j=n-1;
            int target=-nums[k];
            //枚举b
            for (i=k+1;i<n;i++){
                //需要和上次枚举的数不同
                if (i>k+1&&nums[k]==nums[k-1]){
                    continue;
                }
                //保证b的指针在c的指针的左侧
                while (i<j&&nums[i]+nums[j]>target){
                    j--;
                }
                //
                if (i==j) break;
                if (nums[i]+nums[j]==target){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
