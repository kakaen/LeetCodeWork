package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class 设计相邻元素求和服务3242 {
    public static void main(String[] args) {
        NeighborSum neighborSum = new NeighborSum(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});
        System.out.println(neighborSum.adjacentSum(1));
        System.out.println(neighborSum.adjacentSum(4));
        System.out.println(neighborSum.diagonalSum(4));
        System.out.println(neighborSum.diagonalSum(8));

    }
}
class NeighborSum {
    public int[][] prGrid;
    //存储行下标的map；
    private Map<Integer,Integer> rowMap;
    //存储列下标的map；
    private Map<Integer,Integer> colMap;
    private int n;
    private int m;
    public NeighborSum(int[][] grid) {
        n=grid.length;

        rowMap=new HashMap<>();
        colMap=new HashMap<>();
        prGrid=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                rowMap.put(grid[i][j],i);
                colMap.put(grid[i][j],j);
                prGrid[i][j]=grid[i][j];
            }
        }
    }
    //对角线元素,(i-1,j-1),(i-1,j+1),(i+1,j-1),(i+1,j+1)
    public int diagonalSum(int value) {
        int  i = rowMap.get(value);//获取i坐标
        int j=colMap.get(value);
        int resSum=0;
        if (i-1>=0){
            if (j-1>=0) resSum+=prGrid[i-1][j-1];
            if (j+1<n) resSum+=prGrid[i-1][j+1];
        }
        if(i+1<n){
            if (j-1>=0) resSum+=prGrid[i+1][j-1];
            if (j+1<n) resSum+=prGrid[i+1][j+1];
        }
        return resSum;
    }
    //相邻元素
    public int adjacentSum(int value) {
        int  i = rowMap.get(value);//获取i坐标
        int j=colMap.get(value);
        int resSum=0;
        if(i-1>=0) resSum+=prGrid[i-1][j];
        if (i+1<n) resSum+=prGrid[i+1][j];
        if (j-1>=0) resSum+=prGrid[i][j-1];
        if (j+1<n) resSum+=prGrid[i][j+1];
        return resSum;
    }
}


