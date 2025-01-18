package Top100二刷.二分查找.二分法求最大值;

public class 每个小孩最多能分到多少糖果2226 {
    public static void main(String[] args) {
        每个小孩最多能分到多少糖果2226 test = new 每个小孩最多能分到多少糖果2226();
        System.out.println(test.maximumCandies(new int[]{5, 8, 6}, 3));
        System.out.println(test.maximumCandies(new int[]{2,5}, 11));
    }
    public int maximumCandies(int[] candies, long k) {
        //分配给K个小孩,每个小孩分到相同数量的糖果
        int n=candies.length;
        int maxCount=0;
        for (int c:candies){
            maxCount=Math.max(maxCount,c);
        }
        int l=1;
        int r=maxCount;
        while (l<=r){
            int m=l+(r-l)/2;
            long sum=0;
            for (int c:candies){
                sum+=c/m;
            }
            if (sum>=k){
                l=m+1;
            }else {
                r=m-1;
            }
        }
        return r;
    }
}
