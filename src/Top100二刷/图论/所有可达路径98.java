package Top100二刷.图论;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 所有可达路径98 {
    public static List<Integer> path=new ArrayList<>();
    public static List<List<Integer>> res=new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] grid = new int[N + 1][N + 1]; //使用邻接矩阵来实现
        for (int i = 0; i < M; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            grid[s][t] = 1;
        }
        //int[]类型转为Arrays类型
        int[] arr=new int[]{1,3,4};

        path.add(1);
        dfs(grid,1);
       for (List<Integer> list:res){
           for (int i=0;i<list.size();i++){
               if (i<list.size()-1){
                    System.out.print(list.get(i)+" ");
               }else{
                   System.out.print(list.get(i));
               }
           }
           System.out.println();

       }
    }
    //i表示当前的出发点
    public static void dfs(int[][] grid,int i){
        //表示到达了n节点
        if (i==grid.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
        //遍历所有的节点
        for (int j=1;j<grid.length;j++){
            if (grid[i][j]==0) continue;
            path.add(j);
            dfs(grid,j);

            path.remove(path.size()-1);
        }
    }
}
