package 排序算法;

import com.sun.org.apache.bcel.internal.generic.FALOAD;

import java.util.Arrays;
import java.util.Random;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr=new int[100];
        int n=arr.length;
        Random random = new Random();
        for (int i=0;i<n;i++){
            arr[i]= random.nextInt(100)+1;
        }
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        System.out.println("排序后");
        sort(arr);
    }
    public static void sort(int[] arr){
        int n=arr.length;
        boolean isChange= false; //判断是否交换过
        int temp=0;
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-1-i;j++){
                if (arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    isChange=true;
                }
            }
            if (!isChange) break;
        }
        System.out.println(Arrays.toString(arr));
    }
}
