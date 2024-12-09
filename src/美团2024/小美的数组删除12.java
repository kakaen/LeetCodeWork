package 美团2024;

import java.util.Scanner;

public class 小美的数组删除12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //表示共有多少组数据
        int T=scanner.nextInt();
        int n=scanner.nextInt(); //数组中的元素数量
        int k=scanner.nextInt(); //删除整个数组
        int x=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
    }
}
