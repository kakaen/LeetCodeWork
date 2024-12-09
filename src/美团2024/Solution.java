package 美团2024;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int k=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        fuction2(nums,m,k);
    }
    public static void fuction2(int[] nums,int m,int k){
        Arrays.sort(nums);
        int n=nums.length;
        int left=0,right=0;
        //窗口大小m
        int res=n;
        for (right=m-1;right<n;right++){
//            if (right<m-1) continue;
            //窗口指
            //判断窗口值,并更新
            if (nums[right]-nums[left]<=k){
                res--;
            }
            left++;
        }
        System.out.println(res);
    }
}
