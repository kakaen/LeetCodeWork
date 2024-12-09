package 代码随想录.哈希表;

import java.util.HashMap;
import java.util.Map;

public class 两数之和1 {
    public static void main(String[] args) {

    }
}
class Solution{
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int balance=target-nums[i];
            if (map.containsKey(balance)){
                return new int[]{i,map.get(balance)};
            }else {
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
