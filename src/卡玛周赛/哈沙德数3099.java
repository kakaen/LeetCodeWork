package 卡玛周赛;

import java.util.Scanner;

public class 哈沙德数3099 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x=scanner.nextInt();
        solution(x);
    }
    public static void solution(int number){
        int count=0;
        int copyNum=number;
        while (number>0){
            count+=number%10;
            number=number/10;
        }
        if (copyNum%count==0){
            System.out.println(count);
        }else {
            System.out.println(-1);
        }
    }
}
