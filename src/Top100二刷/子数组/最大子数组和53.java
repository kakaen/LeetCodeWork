package Top100二刷.子数组;

import java.util.Scanner;

public class 最大子数组和53 {
    public int maxSubArray(int[] nums){
        //找出一个具有最大和的连续子数组，返回其最大和
        int ans=nums[0];
        int n=nums.length;
        int sum=0;
        for (int i=0;i<n;i++){
            //加上这个当前i下标的元素
            //判断是否大于等于0
            if (sum<=0){
                sum=nums[i];
            }else {
                sum+=nums[i];
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        最大子数组和53 test = new 最大子数组和53();
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int i = test.maxSubArray(arr);
        System.out.println(i);
    }
}
