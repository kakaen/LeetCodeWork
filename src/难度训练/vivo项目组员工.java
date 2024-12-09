package 难度训练;

import java.util.Scanner;

public class vivo项目组员工 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] staff=new int[n];
        for (int i=0;i<n;i++){
            staff[i]=scanner.nextInt();
        }

    }
    public static void F(int[] staff){
        int groups=0;
        int n=staff.length;
        int i=0;
        while (i<n){
            if (staff[i]==1){
                //老员工
                groups++;
                if (i+1<n&&staff[i+1]==0){
                    //检查下一个是否为新员工
                    i+=2;
                }
            }
        }
    }
}
