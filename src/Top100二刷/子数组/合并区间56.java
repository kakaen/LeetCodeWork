package Top100二刷.子数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间56 {
    public static void main(String[] args) {
        合并区间56 test = new 合并区间56();
        int[][] intervals=new int[][]{{1,3},{2,6},{15,18},{8,10}};
        int[][] merge = test.merge(intervals);
        for (int[] point:merge){
            System.out.println(point[0]+" :"+point[1]);
        }
    }
    public int[][] merge(int[][] intervals){
        //intervals[i]=[starti,endi];
        //把数组按照start进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> list=new ArrayList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];
        for (int[] point :intervals){
            if (point[0]<=end){
                end=Math.max(end,point[1]);
            }else {
                list.add(new int[]{start,end});
                start=point[0];
                end=point[1];
            }
        }
        list.add(new int[]{start,end});
        int[][] array = list.toArray(new int[list.size()][2]);
        return array;
    }
}
