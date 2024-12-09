package 贪心算法.从最小最大开始贪心;

import java.util.Arrays;

public class 装满石头的背包的最大数量2279 {
    public static void main(String[] args) {

    }
}
class Solution2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        //第i个背包可以装capacity[i]块石头，当前已经装了rocks[i]块石头
        //additionalRocks，表示额外的石头数量，返回装满石头的背包的最大数量
//        int[] empty=new int[capacity.length]; //还空的位置
        for (int i=0;i<capacity.length;i++){
            capacity[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(capacity);
        int res=0;
        for (int num:capacity){
            if (additionalRocks-num>=0){
                res++;
                additionalRocks-=num;
            }else{
                break;
            }
        }
        return res;
    }
}
