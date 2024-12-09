package 动态规划算法;

import java.util.Scanner;

public class 买股票的最佳时机121 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        Solution121_ solution121 = new Solution121_();
        System.out.println(solution121.maxProfit(arr));
    }
}
class Solution121_{
    public int maxProfit(int[] prices){
        //循环遍历，维护最小成本
        int res=Integer.MIN_VALUE;
        int cout=Integer.MAX_VALUE;//买股票的成本
        for (int i=0;i<prices.length;i++){
            cout=Math.min(cout,prices[i]);
            res=Math.max(prices[i]-cout,res);
        }
        return res;
    }
}
