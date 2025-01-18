package 图论.DFS基础;

import java.util.*;

public class 统计无向图中无法互相到达点对数2316 {
    public static void main(String[] args) {
        统计无向图中无法互相到达点对数2316 test = new 统计无向图中无法互相到达点对数2316();
//        System.out.println(test.countPairs(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        System.out.println(test.countPairs(7,new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}}));
    }
    //求联通分量中每个分量的节点数量
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] table=new List[n];
        boolean[] visited=new boolean[n];
        for (int i=0;i<n;i++){
            table[i]=new ArrayList<>();
        }
        for (int i=0;i<edges.length;i++){
            table[edges[i][0]].add(edges[i][1]);
            table[edges[i][1]].add(edges[i][0]);
        }
        long ans=0;
        int total=0;
        for (int i=0;i<n;i++){
            if (!visited[i]){
                int curCount=DFS(i,visited,table);
                ans=ans+curCount*total;
                total+=curCount;
            }
        }
        return ans;
    }
    //使用DFS来实现每个联通分量中节点的个数
    public int DFS(int start,boolean[] visited,List<Integer>[] table){
        int size=1;
        visited[start]=true;
        for (int i:table[start]){
            if (!visited[i]){
                visited[i]=true;
                size+=DFS(i,visited,table);
            }
        }
        return size;
    }
    public int BFS(int start,boolean[] visited,List<Integer>[] table){
        int count=0;
        Deque<Integer> deque=new ArrayDeque<>();
        deque.push(start);
        visited[start]=true;
        count++;
        while (!deque.isEmpty()){
            int s=deque.poll();
            for (int i:table[s]){
                if (!visited[i]){
                    count++;
                    visited[i]=true;
                    deque.push(i);
                }
            }
        }
        return count;
    }

}
