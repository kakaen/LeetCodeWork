package 滑动窗口算法.不定长窗口.不定长求最小窗口;

import java.util.*;

public class 最短超串面试1718 {
}
class Solution {
    public int[] shortestSeq(int[] big, int[] small) {
        int[] result=new int[2];
        int left=0,right=0;
        //窗口
        Map<Integer,Integer> windows=new HashMap<>();
        for (right=0;right<big.length;right++){
            //进入窗口
            windows.put(big[right], windows.getOrDefault(big[right],0)+1);
            //缩减左端点判断是否
            while (isContain(small,windows)){

            }
        }

        return new int[2];
    }
    public boolean isContain(int[] small,Map<Integer,Integer> map){
        for (int num:small){
            if (map.containsKey(num)){
                if (map.get(num)==1){
                    map.remove(num);
                }else {
                    map.put(num, map.get(num)-1);
                }
            }else {
                return false;
            }
        }
        return true;
    }
}