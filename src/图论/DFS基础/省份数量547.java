package 图论.DFS基础;

import 图论.岛屿的数量深度DFS实现;

import java.util.ArrayDeque;
import java.util.Deque;

public class 省份数量547 {
    public static void main(String[] args) {
        省份数量547 test = new 省份数量547();
        System.out.println(test.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(test.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        System.out.println(test.findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        //就是计算连通图
        boolean[] visited=new boolean[n];
        int ans=0;
        for (int i=0;i<n;i++){
            if (!visited[i]){
                ans++;
                visited[i]=true;
                DFS(isConnected,i,visited);
            }
        }
        return ans;
    }
    //采用DFS的方式进行遍历
    public void DFS(int[][] isConnected,int start,boolean[] visited){

        for (int i=0;i<isConnected[start].length;i++){
            if (!visited[i]&&isConnected[start][i]==1){
                visited[i]=true;
                DFS(isConnected,i,visited);
            }
        }
    }
    //采用BFS的方式来遍历
    public void BFS(int[][] isConnected,int start,boolean[] visited){
        Deque<Integer> deque=new ArrayDeque<>();
        visited[start]=true;
        deque.push(start);
        while (!deque.isEmpty()){
            Integer node = deque.poll(); //弹出的是第几个
            for (int i=0;i<isConnected[node].length;i++){
                if (!visited[i]&&isConnected[node][i]==1){
                    visited[i]=true;
                    deque.push(i);
                }
            }
        }
    }
}
