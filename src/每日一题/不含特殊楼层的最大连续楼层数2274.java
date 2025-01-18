package 每日一题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 不含特殊楼层的最大连续楼层数2274 {
    public static void main(String[] args) {
        不含特殊楼层的最大连续楼层数2274 test = new 不含特殊楼层的最大连续楼层数2274();
        System.out.println(test.maxConsecutive2(2, 9, new int[]{4, 6}));
        System.out.println(test.maxConsecutive2(6, 8, new int[]{7, 6, 8}));
    }
    public int maxConsecutive2(int bottom,int top, int[] special){
        int max=0;
        int n=special.length;
        Arrays.sort(special); //将特殊楼层从小到大进行排序
        //bottom是一定大于等于special中的值的
        max=Math.max(max,special[0]-bottom);
        max=Math.max(max,top-special[n-1]);
        for (int i=1;i<n;i++){
            max=Math.max(max,special[i]-special[i-1]-1);
        }
        return max;
    }
    public int maxConsecutive(int bottom,int top, int[] special){
        Set<Integer> set=new HashSet<>();
        for (int num:special){
            set.add(num);
        }
        //滑动窗口
        int left=bottom,right=bottom;
        int max=0;
        while (right<=top){

        }
        return 0;
    }
}
