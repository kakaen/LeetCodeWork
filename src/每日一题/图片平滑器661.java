package 每日一题;

import java.util.Arrays;

public class 图片平滑器661 {
    public static void main(String[] args) {
        图片平滑器661 test = new 图片平滑器661();
        int[][] ints = test.imageSmoother(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        int[][] ints2 = test.imageSmoother(new int[][]{{100, 200, 100}, {200, 50, 200}, {100, 200, 100}});
        for (int[] p:ints2){
            System.out.println(Arrays.toString(p));
        }
    }
    public int[][] imageSmoother(int[][] img){
        int m=img.length;int n=img[0].length;
        int[][] newimg=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int total=0; //计算有多少个单元格满足条件
                int sum=0;
                for (int k=i-1;k<=i+1;k++){
                    for (int v=j-1;v<=j+1;v++){
                        if (k>=0&&k<m&&v>=0&&v<n){
                        sum+=img[k][v];
                        total++;
                        }
                    }
                }
                if (sum!=0) newimg[i][j]=sum/total;
            }
        }
        return newimg;
    }
}
