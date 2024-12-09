package ACM模式练习;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class 输入输出练习 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(in.hasNextLine());
        while (in.hasNext()){
            int a=in.nextInt();
            int b=in.nextInt();
            System.out.println(a+b);
        }
    }
    public static void solution(int[] arr,int k){
        int count=0;
        //可变窗口,有多少个0，就是取余为0
        int left=0,right=0;
        long total=1;
        for(int num:arr){
            total*=num;
        }
        for(right=0;right<arr.length;right++){
            //有窗口入
            total=total/arr[right];
            //判断是否满足条件
            while(left<=right&&total%((long)Math.pow(10,k))!=0){
                total=total*arr[left++];
            }
            if(total%((long)Math.pow(10,k))==0){
                count++;
            }
        }
        System.out.println(count);
    }
}
