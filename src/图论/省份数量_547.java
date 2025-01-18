package 图论;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 省份数量_547 {
    public static void main(String[] args) {
        省份数量_547 test = new 省份数量_547();
        System.out.println(test.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(test.findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
    }
    public int findCircleNum(int[][] isConnected){
        //n个城市，计算连通图的数量
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
//        List<Integer>[] table=new List[n];
//        for (int i=0;i<n;i++){
//            table[i]=new ArrayList<>();
//        }
//        for (int i=0;i<n;i++){
//            for (int j=0;j<isConnected[i].length;j++){
//                if (isConnected[i][j]==1){
//                    table[i].add(j);
//                }
//            }
//        }
        int count=0;
        for (int i=0;i<n;i++){
            if (!visited[i]){
                visited[i]=true;
                count++;
//                DFS(i,visited,table);
                BFS(i,visited,isConnected);
            }
        }
        return count;
    }
    //采用广度优先遍历
    public void BFS(int start,boolean[] visited,int[][] isConnected){
        Deque<Integer> deque=new ArrayDeque<>();
        deque.push(start);
        while (!deque.isEmpty()){
            int s=deque.poll();
            for (int i=0;i<isConnected[s].length;i++){
                if (!visited[i]&&isConnected[s][i]==1){
                    visited[i]=true;
                    deque.add(i);
                }
            }
        }
    }
    public void DFS(int start,boolean[] visited,List<Integer>[] edges){
        for (int e:edges[start]){
            if (!visited[e]){
                visited[e]=true;
                DFS(e,visited,edges);
            }
        }
    }
}
