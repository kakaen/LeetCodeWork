package 美团2024;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q=scanner.nextInt();
        for (int i=0;i<q;i++){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int k=scanner.nextInt();
            function(n,m,k);
        }
    }
    public static void function(int n,int m,int k){
        //a[i][j]=j+i*m;
        int[][] values=new int[n][m]; //表示单元dp[i][j]的值
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                values[i][j]=j+i*m;
            }
        }
        int i=0,j=0;//初始位置
        int total=0;
        while (k>0){
//            nums[i-1][j],nums[i+1][j];nums[i][j-1];nums[i][j+1];
            int max=0;

            int nexi=i;
            int nexj=j;
            if (i-1>=0){
                if (max<values[i-1][j]){
                    nexi=i-1;
                    max=values[i-1][j];
                }
            }
            if (i+1<n){
                if (max<values[i+1][j]){
                    nexi=i+1;
                    max=values[i+1][j];
                }

//                i=i+1;
            }
            if (j-1>=0){
                if (max<values[i][j-1]){
                    nexj=j-1;
                    max=values[i][j-1];
                }

            }
            if (j+1<m){
                if (max<values[i][j+1]){
                    nexj=j+1;
                    max=values[i][j+1];
                }

            }
            total+=max;
            k--;
            i=nexi;
            j=nexj;
        }
        System.out.println(total);

    }
}
