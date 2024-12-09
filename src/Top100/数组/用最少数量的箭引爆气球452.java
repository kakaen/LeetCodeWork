package Top100.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 用最少数量的箭引爆气球452 {
    public int findMinArrowShots(int[][] points){
        //合并数组，有多少个不相邻的数组
        //先排序，将数组按照xstart进行排序
        Arrays.sort(points,(a,b)->{return a[0]-b[0];});
        int n=points.length;
        List<int[]> ans=new ArrayList<>();
        for (int i=0;i<n;i++){
        }
        return ans.size();
    }
}
