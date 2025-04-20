package Top100二刷.前缀和题目;

import java.util.HashMap;
import java.util.Map;

public class 和为K的子数组个数 {
    public static void main(String[] args) {

    }
    //返回数组中和为k的子数组的个数
    public int subarraySum(int[] nums,int k){
        //定义pre[i]为0-i的和
        //那nums[j,i]的和等于pre[i]-pre[j-1]=k
        //pre[i]=pre[j-1]+k

        Map<Integer,Integer> map=new HashMap<>();
        int s=0;
        int ans=0;
        map.put(0,1);
        for (int num:nums){
            s+=num;
            if (map.containsKey(s-k)){
                ans+=map.get(s-k);
            }
            map.put(s,map.getOrDefault(s,0)+1);
        }
        return ans;

    }

}
