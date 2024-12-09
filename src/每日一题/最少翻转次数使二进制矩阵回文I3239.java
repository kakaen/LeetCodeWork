package 每日一题;

public class 最少翻转次数使二进制矩阵回文I3239 {
    public int minlips(int[][] grid){
        //先计算所有行回文所需次数
        int m=grid.length;
        int n=grid[0].length;
        int l,r;
        int rowCount=0;
        for (int[] row:grid){
            l=0;
            r=row.length-1;
            while (l<r){
                if (row[l]!=row[r]) rowCount++;
                l++;r--;
            }
        }
        int colCount=0;
        for (int j=0;j<n;j++){
            l=0;
            r=m-1;
            while (l<r){
                if (grid[l][j]!=grid[r][j]){
                    colCount++;
                }
                l++;r--;
            }
        }
        return Math.min(rowCount,colCount);
    }

    public static void main(String[] args) {
        最少翻转次数使二进制矩阵回文I3239 test = new 最少翻转次数使二进制矩阵回文I3239();
        System.out.println(test.minlips(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 1}}));
        System.out.println(test.minlips(new int[][]{{0, 1}, {0, 1}, {0, 0}}));
    }
}
