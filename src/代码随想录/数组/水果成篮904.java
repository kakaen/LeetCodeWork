package 代码随想录.数组;

import java.util.HashMap;
import java.util.Map;

public class 水果成篮904 {
    public static void main(String[] args) {
        Solution904 solution904 = new Solution904();
        System.out.println(solution904.totaFruit(new int[]{0,1,2,2}));
        System.out.println(solution904.totaFruit(new int[]{1,2,3,2,2}));
        System.out.println(solution904.totaFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
class Solution904{
    public int totaFruit(int[] fruits){
        //窗口值只有2
        int res=0;
        int n=fruits.length;
        //窗口
        Map<Integer,Integer> map=new HashMap<>(); //记录水果树出现的次数
        int left=0;
        for (int right=0;right<n;right++) {
            //将右指针指向的元素入窗口
            //将消息
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            //判断当前窗口是否符合条件，不符合条件则缩减左边界
            while (map.size()>2&&left<=right) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                //移除最左侧的
                if (map.get(fruits[left])==0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}
