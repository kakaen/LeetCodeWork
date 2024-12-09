package Top100.区间合并相关题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 用最少数量的箭引爆气球452 {
    public static void main(String[] args) {
        用最少数量的箭引爆气球452 test = new 用最少数量的箭引爆气球452();
       int[][]points= new int[][] {{10,16},{2,8},{1,6},{7,12}};
       int[][]points2= new int[][] {{1,2},{3,4},{5,6},{7,8}};
        System.out.println(test.findMinArrowShorts(points));
        System.out.println(test.findMinArrowShorts(points2));
    }
    public int findMinArrowShorts(int[][] points){
        Arrays.sort(points,(a,b)->{
            if (a[0]>b[0]){
                return 1;
            }else{
                return 0;
            }
        });
        for (int[] po:points){
            System.out.println(Arrays.toString(po));
        }
        List<int[]> res=new ArrayList<>();
        int n=points.length;
        for (int i=0;i<n;i++){
            int m=res.size();
            if (m>0&&points[i][0]<=res.get(m-1)[1]){
                res.get(m-1)[0]=points[i][0];
                res.get(m-1)[1]=Math.min(points[i][1],res.get(m-1)[1]);
            }else{
                res.add(points[i]);
            }
        }

        return res.size();
    }
}
