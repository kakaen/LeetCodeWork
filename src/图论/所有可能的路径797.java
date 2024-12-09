package 图论;

import java.util.ArrayList;
import java.util.List;

public class 所有可能的路径797 {
    public static void main(String[] args) {

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
