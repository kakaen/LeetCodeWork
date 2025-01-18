package 图论;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 寻找图中是否存在路径1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited=new boolean[n];
        List<Integer>[] table=new List[n];
        for (int i=0;i<n;i++){
            table[i]=new ArrayList<>();
        }

        //进行组装edges
        for (int i=0;i<edges.length;i++){
            table[edges[i][0]].add(edges[i][1]);
            table[edges[i][1]].add(edges[i][0]);
        }
        return BFS(source,destination,visited,table);
    }
    public boolean BFS(int source,int destination,boolean[] visited,List<Integer>[] table){
        Deque<Integer> deque=new ArrayDeque<>();
        deque.push(source);
        visited[source]=true;
        while(!deque.isEmpty()){
            int s=deque.poll();
            for (int i:table[s]){
                if (!visited[i]){
                    if (i==destination) return true;
                    visited[i]=true;
                    deque.push(i);
                }
            }
        }
        return false;
    }
}
