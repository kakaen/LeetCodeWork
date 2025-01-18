package 图论;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 所有可能的路径_797 {
    public static void main(String[] args) {
        int[][] graph=new int[][]{{1,2},{3},{3},{}};
        int[][] graph2=new int[][]{{4,3,1},{3,2,4},{3},{4},{}};
        所有可能的路径_797 test = new 所有可能的路径_797();
        List<List<Integer>> res = test.allPathsSourceTarget(graph2);
        for (List<Integer> list:res){
            System.out.println(list);
        }
    }
    public List<List<Integer>> res=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        int n=graph.length;
        //从节点0到节点n-1的路径输出
        path.add(0);
        DFS(0,graph);
        return res;
    }
    public void BFS(int start,int[][] graph){
        Deque<Integer> stack=new ArrayDeque<>();
        stack.push(start);
        while (!stack.isEmpty()){
            int s=stack.poll();
            for (int i=0;i<graph[s].length;i++){

            }
        }
    }
    public void DFS(int start,int[][] graph){
        //说明到达了n-1节点
        if (start==graph.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<graph[start].length;i++){
            path.add(graph[start][i]);
            DFS(graph[start][i],graph);
            path.remove(path.size()-1);
        }
    }
}
