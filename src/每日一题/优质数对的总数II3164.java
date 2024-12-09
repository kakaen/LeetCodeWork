package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class 优质数对的总数II3164 {
    //不可以使用暴力解法
    public long numberOfPairs(int[] nums1,int[] nums2,int k){
        //分别统计nums1和nums2中不同数出现的次数
        //遍历nums2出现的元素，枚举a*k的倍数，如果在nums1中出现过
        Map<Integer,Integer> map1=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();
        int max=0;
        for (int num:nums1){
            map1.put(num,map1.getOrDefault(num,0)+1);
            max=Math.max(max,num);
        }
        for (int num:nums2){
            map2.put(num,map2.getOrDefault(num,0)+1);
        }
        int res=0;
        //枚举nums2中的元素
        for (Integer num2 : map2.keySet()) {
            //枚举num2*k的倍数
            for (int i=num2*k;i<=max;i+=num2*k){
                if (map1.containsKey(i)){
                    res+=map1.get(i);
                }
            }
        }
        return res;
    }
}
