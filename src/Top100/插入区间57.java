package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 插入区间57 {
    public static void main(String[] args) {
        插入区间57 test = new 插入区间57();
        int[][] intervals=new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[][] intervals2=new int[][]{{1,5}};
        int[][] intervals3=new int[][]{};
//        int[][] insert = test.insert(intervals2, new int[]{4, 8});
        int[][] insert2 = test.insert(intervals3, new int[]{2, 7});
        for (int[] p:insert2){
            System.out.println(Arrays.toString(p));
        }
    }
    public int[][] insert(int[][] intervals,int[] newInterval){
        List<int[]> res=new ArrayList<>();
        int n=intervals.length;
        boolean flag=false; //判断新元素是否插入了
        for (int[] p:intervals){
            int m=res.size();
            if (newInterval[0]<=p[0]){
                //如果要插入的元素的头小于当前要插入的头，先插入新元素
                //如果新元素的头值都大于呢，那不就无法插入了
                //先插入newInterval
                if (m>0&&newInterval[0]<=res.get(m-1)[1]){ //需要合并
                    res.get(m-1)[1]=Math.max(res.get(m-1)[1],newInterval[1]);
                }else{
                    res.add(newInterval);
                }
                flag=true;
            }
            m=res.size();
            if (m>0&&p[0]<=res.get(m-1)[1]){ //需要合并
                res.get(m-1)[1]=Math.max(res.get(m-1)[1],p[1]);
            }else{
                res.add(p);
            }
        }
        if (flag==false){
            //插入新元素
            int m=res.size();
            if (m>0&&newInterval[0]<=res.get(m-1)[1]){ //需要合并
                res.get(m-1)[1]=Math.max(res.get(m-1)[1],newInterval[1]);
            }else{
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert2(int[][] intervals,int[] newInterval){
        //总共有三种情况
        List<int[]> res=new ArrayList<>();
        int n=intervals.length;
        int i=0;
        //区间有三种请框，小于带插入元素的
        while (i<n&&intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        //区间和带插入元素有重叠的
        while (i<n&&intervals[i][0]<=newInterval[1]){
            //合并
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        res.add(newInterval);
        //区间大于待插入元素的
        while (i<n&&intervals[i][0]>newInterval[1]){
            res.add(intervals[i]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
