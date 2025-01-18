package 图论.DFS基础;

import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;

import java.util.ArrayList;
import java.util.List;

public class 所有可能的路径797 {
    public static void main(String[] args) {
        所有可能的路径797 test = new 所有可能的路径797();
        int[][] graph={{1,2},{3},{3},{}};
        List<List<Integer>> lists = test.allPathSourceTarget(graph);
        for (List<Integer> list:lists){
            System.out.println(list);
        }
    }
    public List<List<Integer>> allPathSourceTarget(int[][] graph){
        int n=graph.length; //n个节点
        boolean[] visited=new boolean[n];
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        DFS(graph,0,res,path);
        return res;
    }
    public void DFS(int[][] graph,int start,List<List<Integer>> res,List<Integer> path){
        if (start==graph.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<graph[start].length;i++){
            path.add(graph[start][i]);
            DFS(graph,graph[start][i],res,path);
            path.remove(path.size()-1);
        }

    }
}
