package 图论;

import java.text.DateFormatSymbols;
import java.util.*;

public class 所有可能的路径797 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt(); //N个节点
        int M=scanner.nextInt(); //M条边
        int[][] grid=new int[N+1][N+1];
        for (int i=0;i<M;i++){
            int s=scanner.nextInt();
            int e=scanner.nextInt();
            grid[s][e]=1;
        }
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        path.add(1);
        DFS(1,grid,path,res);
        for (List<Integer> list:res){
            for (int i=0;i<list.size()-1;i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println(list.get(list.size()-1));
        }
        if (res.size()==0){
            System.out.println(-1);
        }
    }
    //BFS实现可达路径的遍历
    public static void BFS(int i,int[][] grid,List<Integer> path,List<List<Integer>> res){
        Deque<Integer> queue=new ArrayDeque<>(); //存储第一圈遍历的
        for (int k=1;k<grid.length;k++){
            if (grid[i][k]==1){
                queue.add(k);
            }
        }
    }
    //DFS实现可达路径的遍历，i表示开始节点
    public static void DFS(int i,int[][] grid,List<Integer> path,List<List<Integer>> res){
        //结束
        if (i==grid.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int k=1;k<grid.length;k++){
            if (grid[i][k]==0) continue;
            path.add(k);
            DFS(k,grid,path,res);
            path.remove(path.size()-1);
        }
    }
    //采用BFS来实现相关的搜索
    public List<List<Integer>> allPathsSourceTarget2(int[][] graph){
        List<List<Integer>> res=new ArrayList<>();
//        int size=graph.length()
        return null;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        path.add(0); //从节点0出发
        dfs(0,graph,path,res);
        return res;
    }
    public void dfs(int startNode,int[][] graph,List<Integer> path,List<List<Integer>> res){
        if (startNode==graph.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
        //去遍历graph[start]
        for (int i:graph[startNode]){
            path.add(i);
            dfs(i,graph,path,res);
            path.remove(path.size()-1);
        }
    }
}
