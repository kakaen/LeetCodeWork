package Top100二刷.子串;

import java.util.HashMap;
import java.util.Map;

public class 和为K的子数组560 {
    public int subarraySum(int[] nums,int k){
      //采用前缀和的方式
        int ans=0;
        int n=nums.length;
        Map<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(0,1);
        int pre=0;
        int[] prefix=new int[n]; //prefix表示从0-i的元素的和
        for (int i=0;i<n;i++){ //假设我们以i为k的结尾元素
            //使用map的方式来判断是否存在
            pre+=nums[i];
            if(hashMap.containsKey(pre-k)){
                ans+= hashMap.get(pre-k);
            }
            hashMap.put(pre,hashMap.getOrDefault(pre,0)+1);
        }
        return ans;
    }
}
