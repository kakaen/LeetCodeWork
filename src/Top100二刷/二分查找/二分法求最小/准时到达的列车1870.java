package Top100二刷.二分查找.二分法求最小;

import java.util.Arrays;

public class 准时到达的列车1870 {
    public static void main(String[] args) {
        准时到达的列车1870 test = new 准时到达的列车1870();
        int[] dist=new int[]{1,3,2};
        System.out.println(test.minSpeedOnTime(dist, 6));
        System.out.println(test.minSpeedOnTime(dist,2.7));
        System.out.println(test.minSpeedOnTime(dist,1.9));
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int l=1;
        //距离的最大值，这样就可以使得前n-1趟列车的时间都为1
        int r= Arrays.stream(dist).max().getAsInt();
        int n=dist.length;
        //计算最后一辆列车的时间,当前n-1辆车的时间都为1
        double lastTime=hour-n+1;
        if (lastTime<=0) return -1; //肯定到不了
        int lastSpeed=(int)Math.ceil((long)dist[n-1]/lastTime);
        r=Math.max(r,lastSpeed);

        while (l<=r){
            int m=l+(r-l)/2;
            //计算所需时间
            double sum=0;
            for (int i=0;i<n-1;i++){
                sum+=(int)Math.ceil((double) dist[i]/m);
            }
            //最后一辆汽车不需要进行取整操作
            sum+=(double) dist[n-1]/m;
            if (sum>hour){
                l=m+1;
            }else {
                r=m-1;
            }
        }
        return l;
    }
}
