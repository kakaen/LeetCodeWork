package 滑动窗口算法.不定长窗口.统计子数组的数目;

import 贪心算法.柠檬水找零860;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 统计完全子数组的数目 {
    public static void main(String[] args) {
        Solution2799 solution2799 = new Solution2799();
        int[] nums={1,3,1,2,2};
        System.out.println(solution2799.countCompleteSubarrays(nums));
    }
}
class Solution2799 {
    public int countCompleteSubarrays(int[] nums) {
        int left=0,right=0;
        int n=nums.length;
        //先统计所有数组中的不同元素的数目
        Set<Integer> set=new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        int count=set.size(); //整个数组的不重复的元素个数
        int result=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (right=0;right<n;right++){
            //返回数组中完全子数组的数目，不同元素的个数等于整组不同元素的数目
            //右侧元素进入窗口
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            //判断是否满足子数组的要求,如果满足了则后续的子数组都会满足
            if (map.size()==count){
                result++;
            }
            //找到第一个最大子数组
            while (right==(n-1)&&(left<n)&&map.size()==count){
                //缩减左边界
                if (map.get(nums[left])==1){
                    map.remove(nums[left]);
                }else {
                    map.put(nums[left],map.get(nums[left])-1);
                }
                if (map.size()==count) result++;
            }
        }
        return result;
    }
    public int countCompleteSubarrays2(int[] nums){
        Set<Integer> set=new HashSet<>();
        for (int x:nums) set.add(x);
        int m=set.size();
        //创建窗口
        Map<Integer,Integer> cnt=new HashMap<>();
        int left=0;
        int ans=0;
        //枚举子数组的右端点
        for (int v:nums){
            cnt.merge(v,1,Integer::sum);
            while (cnt.size()==m){
                //开始缩减左数组
                int x=nums[left++];
                if (cnt.merge(x,-1,Integer::sum)==0){
                    cnt.remove(x);
                }
            }
                ans+=left;
        }
        return ans;
    }
//    public boolean check(Map<Integer,Integer> map,int totalCount){
//        int keyCount=map.keySet().size();
//        return keyCount==totalCount;
//    }
}