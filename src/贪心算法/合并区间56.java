package 贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间56 {
    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int[][] arr=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = solution56.merge(arr);
        for (int i=0;i<merge.length;i++){
            System.out.println("["+merge[i][0]+","+merge[i][1]+"]");
        }
    }
}
class Solution56{
    public int[][] merge(int[][] intervals){
        //先将区间按边界进行排序
        Arrays.sort(intervals,(a,b)->{
            if (a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];
       for (int i=1;i<intervals.length;i++){
           if (intervals[i][0]<=end){
               end=Math.max(end,intervals[i][1]);
           }else {
               ArrayList<Integer> list = new ArrayList<>();
               list.add(start);
               list.add(end);
               lists.add(list);
               start=intervals[i][0];
               end=intervals[i][1];
           }
       }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        lists.add(list);
       int[][] result=new int[lists.size()][2];
       for (int i=0;i<lists.size();i++){
           List<Integer> listi = lists.get(i);
           result[i][0]=listi.get(0);
           result[i][1]=listi.get(1);

       }
        return result;
    }
}