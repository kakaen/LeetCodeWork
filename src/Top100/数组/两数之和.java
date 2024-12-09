package Top100.数组;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums=new int[]{2,7,11,15};
        int target=9;
        System.out.println(solution1.twoSum(nums, target));
    }
}
class Solution1{
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }
}
