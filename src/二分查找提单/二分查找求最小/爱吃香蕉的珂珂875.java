package 二分查找提单.二分查找求最小;

public class 爱吃香蕉的珂珂875 {
    public static void main(String[] args) {
        Solution875 solution875 = new Solution875();
        int[] piles={805306368,805306368,805306368};int h=1000000000;
        System.out.println(solution875.minEatingSpeed(piles, h));
    }
}
class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        //吃香蕉，n堆香蕉,piles[i]根香蕉，警卫
        //k速度，每个小时吃k根香蕉。
        int result=0;
        //piles[i]/k上取整 得到吃完这堆香蕉的时间
        int left=1;int right=0;
        for (int pile:piles){
            if (pile>right) right=pile;
        }
        while (left<=right){
            int mid=left+(right-left)/2;
            //计算吃完所有香蕉的时间
            int total=0;
            //就是上取整的问题
            for (int pile:piles){
                total+=(pile+mid-1)/mid;
            }
            if (total<=h){
                result=mid;
                right=mid-1;
            }else {
                left=mid+1;
            }
            //int[] mid=new int[]
        }
        return result;
    }
}
