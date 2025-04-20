package Top100二刷.滑动窗口.定长滑动窗口;

import java.util.Arrays;

public class 半径为k的子数组平均值2090 {
    public static void main(String[] args) {
        半径为k的子数组平均值2090 test = new 半径为k的子数组平均值2090();
        System.out.println(Arrays.toString(test.getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3)));
    }
    public int[] getAverages(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n];
        Arrays.fill(res,-1);
        int l=0;
        long count=0;
        int index=0;
        for (int r=0;r<n;r++){
            //1.入窗口
            count+=nums[r];
            //窗口长度为2K+1
            if (r<2*k) continue;
            //2.计算更新
            index=r-k;
            res[index]=(int)(count/(2*k+1));
            //3.移动左指针
            count-=nums[l++];
        }
        return res;
    }
}
