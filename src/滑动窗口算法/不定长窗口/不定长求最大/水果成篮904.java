package 滑动窗口算法.不定长窗口.不定长求最大;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 水果成篮904 {
    public static void main(String[] args) {
        Solution904 solution904 = new Solution904();
        int[] fruits=new int[]{1,2,1};
        System.out.println(solution904.totalFruit(fruits));
    }
}
class Solution904 {
    public int totalFruit(int[] fruits) {
        //fruits[i]是第i棵树的水果种类
        //窗口中只包含两种元素
        int left=0;
        int result=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            //right先进入篮子
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            //判断是否超过两种数据类型的水果，超过则缩小左边界
            while (map.size()>2){
                if (map.get(fruits[left])==1){
                    map.remove(fruits[left]);
                }else {
                    map.put(fruits[left],map.get(fruits[left])-1);
                }
                left++;
            }
            //更新窗口
            result=Math.max(result,right-left+1);
        }
        return result;
    }
}
