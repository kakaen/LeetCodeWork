package Top100二刷;

import java.util.Arrays;
import java.util.Scanner;

public class 下一个排列31 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        function2(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void function2(int[] nums){
        //两次遍历的方式，从右往左进行遍历，找到第一个a[i-1]<a[i]
        int n=nums.length;
        int index=-1;
        for (int i=n-2;i>=0;i--){
            if (nums[i]>=nums[i+1]){
                index=i;
                break;
            }
        }
    }
    public static void function(int[] nums){
        int index1=-1;
        int n=nums.length;
        //首先从左遍历数组，找到最后一个nums[i]<nums[i+1]的下标
        for (int i=0;i<n-1;i++){
            if (nums[i]<nums[i+1]){
                index1=Math.max(index1,i);
            }
        }
        if (index1==-1){
            //说明数组是降序排列
            int left=0,right=n-1;
            while (left<right){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
                right--;
            }
        }
        //交换
        int temp=nums[index1];
        nums[index1]=nums[index1+1];
        nums[index1+1]=temp;
        //从index1+2往后都是单调递减的元素，因此需要进行调整顺序
        int index2=index1+2;
        int left=index2,right=n-1;
        while (left<right){
            temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        for (int i=index1+1;i<n-1;i++){
            if (nums[i]>nums[i+1]){
                temp=nums[i];
                nums[i]=nums[i+1];
                nums[i+1]=temp;
            }
        }
    }
}
