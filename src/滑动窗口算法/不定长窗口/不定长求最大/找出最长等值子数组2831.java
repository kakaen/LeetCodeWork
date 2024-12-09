package 滑动窗口算法.不定长窗口.不定长求最大;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 找出最长等值子数组2831 {
    public static void main(String[] args) {
        Solution2831 solution2831 = new Solution2831();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(1);
        int i = solution2831.longestEqualSubarray(list, 2);
        System.out.println(i);
    }
}
class Solution2831 {
    public int longestEqualSubarray2(List<Integer> nums,int k){
        //将相同元素记录到哈希表中,key为对应元素，list集合为相应的下标
        Map<Integer,List<Integer>> map=new HashMap<>();
        //把所有下标对应的放入map集合中。
        for (int i=0;i<nums.size();i++){
            List<Integer> orDefault = map.getOrDefault(nums.get(i), new ArrayList<>());
            orDefault.add(i);
            map.put(nums.get(i),orDefault);
        }
        int asn=0;
        //遍历每个key，取出其位置集合
        for (List<Integer> vec : map.values()) {
            for (int left=0,right=0;right<vec.size();right++){
                //缩小窗口值，直到不同元素数量小于等于k
                //数组的范围是[vec.get(right)-vec.get(left)+1]
                //相同的数为 right-left+1;
                while (vec.get(right)-vec.get(left)-(right-left)>k){
                    left++;
                }
                asn=Math.max(asn,right-left+1);
            }
        }
        return asn;


    }
    public int longestEqualSubarray(List<Integer> nums, int k) {
        //返回最长等值子数组的长度
        int left=0;
        int result=0;
        Map<Integer,Integer> window=new HashMap<>();
        for (int right=0;right<nums.size();right++){
            //右边界值进入窗口，
            window.put(nums.get(right),window.getOrDefault(right,0)+1);
            //判断是否符合窗口，不符合则调整左边界
            while (!check(window,k)){
                Integer i = window.get(nums.get(left));
                if (i<=1){
                    window.remove(nums.get(left));
                }else {
                    window.put(nums.get(left),window.get(nums.get(left))-1);
                }
                left++;
            }
            int maxCount=0;
            for (Map.Entry<Integer, Integer> entry : window.entrySet()) {
                if (maxCount<entry.getValue()) maxCount=entry.getValue();
            }
            result=Math.max(result,maxCount);
        }
        return result;
    }
    public boolean check(Map<Integer,Integer> map,int k){
        //判断当前map中最小值的相加
        if (map.size()==1) return true; //如果窗口元素只有一个则为真
        int maxCount=0; //选择最大的元素个数
        int totalCount=0;//所有元素加和
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()>maxCount){
                maxCount= entry.getValue();
            }
            //计算总和
            totalCount+=entry.getValue();
        }
        return (totalCount-maxCount)>k?false:true;

    }
}