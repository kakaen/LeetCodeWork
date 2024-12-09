package 贪心算法.从最小最大开始贪心;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class K次取反后最大化的数组和1005 {
    public static void main(String[] args) {

    }
}
class Solution1005 {
    public static int BIAS=100;
    public int largestSumAfterKNegations(int[] nums, int k) {
        //使用桶排序
        Map<Integer,Integer> map=new HashMap<>();
        //将元素放入桶中
        int total=0;
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            total+=num;
        }
        //判断是否存在负数
        for (int i=-100;i<0;i++) {
            if (map.containsKey(i)) {
                int num = map.get(i);
                if (num >= k) {
                    total += k * (-i) * 2;
                    k = 0;
                    break;
                } else {
                    total += num * 2 * (-i);
                    k -= num;
                    map.put(-i, map.getOrDefault(-i, 0) + num);
                }
            }
        }
        //剩一个基数
        if (k>0&&k%2==1&&!map.containsKey(0)){
            for (int j=1;j<=100;j++){
                if (map.containsKey(j)){
                    total-=j*2;
                    break;
                }
            }
        }
        return total;
    }
}
