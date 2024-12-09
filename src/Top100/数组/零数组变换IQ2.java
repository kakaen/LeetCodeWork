package Top100.数组;

import java.util.Map;

public class 零数组变换IQ2 {
    public static void main(String[] args) {
        零数组变换IQ2 test = new 零数组变换IQ2();
        System.out.println(test.isZeroArray(new int[]{1, 0, 1}, new int[][]{{0, 2}}));
        System.out.println(test.isZeroArray(new int[]{4, 3, 2, 1}, new int[][]{{1, 3}, {0, 2}}));
    }
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        //quer[i]=[l,r];
        //nums是
        int[] count=new int[n]; //表示可以删除的1的次数
        for (int[] q:queries){
            int start=q[0];
            int end=q[1];
            for (int i=start;i<=end;i++){
                if (nums[i]>0) nums[i]--;
            }

        }
        for (int i=0;i<n;i++){
            if (nums[i]>0) return false;
        }
        return true;
    }
}
