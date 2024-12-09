package 难度训练;

import java.util.Scanner;

public class 最佳苏通时间 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] record=new int[n][m];
        for (int i=0;i<n;i++){
            record[i]=new int[m];
            for (int j=0;j<m;j++){
                record[i][j]=scanner.nextInt();
            }
        }
        System.out.println(function(record));
    }
    public static int function(int[][] record){
        int n=record.length;
        int m=record[0].length;
        for (int i=0;i<n;i++){
            for (int j=m-1;j>0;j--){
                record[i][j]=record[i][j]-record[i][j-1];
            }
        }
        int total=0;
        for (int j=0;j<m;j++){
            int min=Integer.MAX_VALUE;
            for (int i=0;i<n;i++){
                if (record[i][j]<min){
                    min=record[i][j];
                }
            }
            total+=min;
        }
        return total;
    }
}
