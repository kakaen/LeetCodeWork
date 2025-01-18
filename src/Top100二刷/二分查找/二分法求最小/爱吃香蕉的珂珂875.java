package Top100二刷.二分查找.二分法求最小;

import java.util.Arrays;

public class 爱吃香蕉的珂珂875 {
    public static void main(String[] args) {
        爱吃香蕉的珂珂875 test = new 爱吃香蕉的珂珂875();
        System.out.println(test.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(test.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(test.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r= Arrays.stream(piles).max().getAsInt();
        while (l<=r){
            int m=l+(r-l)/2;
            int sum=0;
            for (int pile:piles){
                sum+=(pile+m-1)/m;
            }
            if (sum>h){
                l=m+1;
            }else {
                r=m-1;
            }
        }
        return l;

    }
}
