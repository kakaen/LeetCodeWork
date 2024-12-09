package 卡玛周赛;

import java.util.Scanner;

public class FirstA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,k;
        n=scanner.nextInt();
        k=scanner.nextInt();
        String str=null;
        while (scanner.hasNext()){
            n=scanner.nextInt();
            k=scanner.nextInt();
            str=scanner.next();
        }
        System.out.println("n="+n);
        System.out.println("k="+k);
        System.out.println(str);
    }
}
