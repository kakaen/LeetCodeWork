package Top100;

import java.util.*;

public class 合并区间56 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] intervals=new int[n][2];
        scanner.nextLine();
        for (int i=0;i<n;i++){
            String str=scanner.nextLine();
            String[] split = str.split(" ");
            for (int j=0;j< split.length;j++){
                intervals[i][j]=Integer.parseInt(split[j]);
            }
        }
        Solution56 solution56 = new Solution56();
        for (int[] ints : solution56.merge(intervals)) {
            System.out.println(Arrays.toString(ints));
        }

    }
    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        }); //左端点进行排序
        List<int[]> res=new ArrayList<>();
        for (int[] p:intervals){
            int m= res.size();
            if (m>0&&p[0]<=res.get(m-1)[1]){ //可以合并
                res.get(m-1)[1]=Math.max(p[1],res.get(m-1)[1]);
            }else{
                //不想交，无法合并
                res.add(p);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
class Solution56 {
    public int[][] merge(int[][] intervals) {
        //list集合中存放两个边界
        List<List<Integer>> list=new ArrayList<>();
        int n=intervals.length;
        //先将intervals按左边界进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        List<int[]> ans=new ArrayList<>();
        for (int[] p:intervals){
            int m=ans.size();
            if (m>0&&p[0]>ans.get(m-1)[1]){
                //可以合并
                ans.get(m-1)[1]=Math.max(p[1],ans.get(m-1)[1]);
            }else{
                ans.add(p);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
