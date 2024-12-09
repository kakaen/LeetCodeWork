package Top100.哈希表;

import java.util.HashMap;
import java.util.Map;

public class 存在重复元素II219 {
    public static void main(String[] args) {
        存在重复元素II219 test = new 存在重复元素II219();
        System.out.println(test.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(test.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 3));
        System.out.println(test.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
    public boolean containsNearbyDuplicate(int[] nums,int k){
        //不同的索引i和j，满足nums[i]==
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])&&(i-map.get(nums[i]))<=k){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
