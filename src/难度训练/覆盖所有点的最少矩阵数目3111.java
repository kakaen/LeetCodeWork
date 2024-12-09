package 难度训练;

import java.util.Arrays;

public class 覆盖所有点的最少矩阵数目3111 {
    public static void main(String[] args) {
        Solution3111 solution3111 = new Solution3111();
        int[][] points={{0,0},{2,2},{1,1},{6,6},{5,5},{3,3},{4,4}};
        int i = solution3111.minRectanglesToCoverPoints(points, 2);
        System.out.println(i);
    }
}
class Solution3111{
    public int minRectanglesToCoverPoints(int[][] points,int w){
        //矩形的宽度最大为w。高度没有确定
        //因此吧points点按照x坐标进行排序
        Arrays.sort(points,(a,b)->{return a[0]-b[0];});
        int count=0;
        int index=Integer.MIN_VALUE;
        for (int[] arr:points){
            if (arr[0]>(index)){
                count++;
                index=arr[0]+w;
            }
        }
        return count;
    }
}