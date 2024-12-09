package 二分查找提单.二分查找求最小;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 准时到达的列车最小时速1870 {
    public static void main(String[] args) {
        Solution1870 solution1870 = new Solution1870();
        int[] dist={1,1,100000}; double hour=2.01;
        System.out.println(solution1870.minSpeedOnTime(dist, hour));
    }
}
class Solution1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int minSpeed=0;
        //最后一辆车的时间无需上取整,前面n-1，每趟车至少花费一小时，因此 hour要大于n-1
        int maxDist=0;
        for (int di : dist) {
            if (di>maxDist){
                maxDist=di;
            }
        }
        //列车的速度可以作为递增的数组，[1,maxDist],如果最后一个
        int left=1; int right=10000000;
        while (left<=right){
            int mid=left+(right-left)/2;
            double total=0;
            //前n-1辆车的运行时间
            for (int i=0;i<dist.length-1;i++){
                total+=(dist[i]+mid-1)/mid;
                }
            total+=1.0*dist[dist.length-1]/mid;
        //加上最后一个站点所需的时间
            if (total<=hour){
                minSpeed=mid;
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return minSpeed==0?-1:minSpeed;
    }
}