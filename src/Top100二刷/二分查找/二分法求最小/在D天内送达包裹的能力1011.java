package Top100二刷.二分查找.二分法求最小;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 在D天内送达包裹的能力1011 {
    public static void main(String[] args) {
        在D天内送达包裹的能力1011 test = new 在D天内送达包裹的能力1011();
        int[] weights=new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(test.shipWithinDays(weights, 5));
        System.out.println(test.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(test.shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }
    public int shipWithinDays(int[] weights, int days) {
        int l=Arrays.stream(weights).max().getAsInt();

        int sumWeight= Arrays.stream(weights).sum();
        int r=sumWeight;
        while (l<=r){
            int m=l+(r-l)/2;
            //如果当前值不满足
            if (!check(weights,m,days)){
                l=m+1;
            }else {
                r=m-1;
            }
        }

        return (int)l;
    }
    //判断是否可以运送完成
    public boolean check(int[] weights,int totalWeights,int days){
        int sumDays=0;
        int sumWeight=0;
        for (int weight:weights){
            if (sumWeight+weight<=totalWeights){
                sumWeight+=weight;
            }else{
                sumDays++;
                sumWeight=weight; //第二天再搬
            }
        }
        sumDays++;
        return sumDays<=days;
    }

    }
