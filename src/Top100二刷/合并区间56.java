package Top100二刷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间56 {
    public int[][] merge(int[][] intervals){
        //先将start排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        List<int[]> list=new ArrayList<>();
        for (int[] p:intervals){
            int ans=list.size();
            if (ans>0&&p[0]<=list.get(ans-1)[1]){
                list.get(ans-1)[1]=Math.max(p[1],list.get(ans-1)[1]);
            }else{
                list.add(p);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        合并区间56 test = new 合并区间56();
        int[][] intervals=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = test.merge(intervals);
        for (int[] m:merge){
            System.out.println(Arrays.toString(m));
        }
    }
}
