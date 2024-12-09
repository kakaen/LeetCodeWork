package 贪心算法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class 用最少数量的剑引爆气球452 {
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points2 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] points3 = {{-2147483646,-2147483645}, {2147483646,2147483647}};
        System.out.println(-2147483646-2147483646);
        Solution452 solution452 = new Solution452();
        System.out.println(solution452.findMinArrowShots(points3));
    }
}
class Solution452{
    public int findMinArrowShots(int[][] points){
        //排序按xStart进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return Integer.compare(o1[1],o2[1]);
                //如何防止溢出问题，使用Integer.compare()进行比较
                return Integer.compare(o1[0],o2[0]);  //o1[0]<o2[0]的话返回-1，就不会进行排序
            }
        });
        int n=points.length; //n个点
        if (n<=1) return n;
        int start=points[0][0];
        int end=points[0][1];
        int count=1;
        for (int i=1;i<n;i++){
            //如果point[i]start<=point[i-1][end]
            if (points[i][0]<=points[i-1][1]){
                //那这只剑应该在 point[i]start---point[i-1][end]
                start=points[i][0];
                if (points[i][1]<=end){
                    end=points[i][1];
                }

            }else{
                //否则就是说，这之间无法满足该气球，因此新射出一支箭
                start=points[i][0];
                end=points[i][1];
                count++;

            }
        }
        return count;
    }
    public int findMinArrowShorts(int[][] points){
        Arrays.sort(points,(a,b)->{return Integer.compare(a[0],b[0]);});
        //
        int n=points.length;
        if (n<=1) return n;
        int result=1;
        for (int i=1;i<n;i++){
            if (points[i][0]<=points[i-1][1]){
                //更新要射出的位置
                points[i][1]= Math.min(points[i][1],points[i-1][1]);
            }else{
                result++; //重新射出一直剑
            }
        }
        return result;
    }
}
