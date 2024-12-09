package 每日一题;

public class 最少翻转次数使二进制矩阵回文II3240 {
    public int minFlips(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int total=0; //要修改的元素。
        //如果为都为奇数的话，中间元素必为0
        if (m%2!=0&&n%2!=0){
            total+=grid[m/2][n/2];
        }
        return 0;
    }
}
