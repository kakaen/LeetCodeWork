package Top100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 和为K的子数组560 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        Solution560 solution560 = new Solution560();
        solution560.subarraySum(nums,k);
    }
}
class Solution560 {
    //枚举的方法
    public int subarraySum(int[] nums, int k) {
        int end=0,start=0;
        int result=0;
        for (start=0;start<nums.length;start++){
            int sum=0;
            for (end=start;end>=0;end--){
                sum+=nums[end];
                if (sum==k){
                    result++;
                }
            }
        }
        return result;
    }
    public int subarraySum2(int[] nums,int k){
        int result=0;
        int n=nums.length;
        int pre=0;
        Map<Integer,Integer> map=new HashMap<>();
        //创建
        map.put(0,1);
        for (int i=0;i<n;i++){
           pre+=nums[i];
           if (map.containsKey(pre-k)){
               result+=map.get(pre-k);
           }
           map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return result;
    }
}