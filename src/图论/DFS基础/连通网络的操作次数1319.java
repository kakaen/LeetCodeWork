package 图论.DFS基础;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 连通网络的操作次数1319 {
    public static void main(String[] args) {
        连通网络的操作次数1319 test = new 连通网络的操作次数1319();
        int[][] connections=new int[][]{{0,1},{0,2},{1,2}};
        int[][] connections2=new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}};
        System.out.println(test.makeConnected3(4, connections));
        System.out.println(test.makeConnected3(6, connections2));
    }
    //使用邻接表来存储边的信息
    public int makeConnected3(int n,int[][] connections){
        if (connections.length<n-1){
            return -1;
        }
        List<Integer>[] edges=new List[n];
        for (int i=0;i<n;i++){
            edges[i]=new ArrayList<>();
        }
        for (int[] connection:connections){
            edges[connection[0]].add(connection[1]);
            edges[connection[1]].add(connection[0]);
        }
        boolean[] visited=new boolean[n];
        int ans=0; //计算连通分量
        for (int i=0;i<n;i++){
            if (!visited[i]){
                ans++;
                visited[i]=true;
               BFS3(i,visited,edges);
            }
        }
        return ans-1;
    }
    public void BFS3(int startNode,boolean[] visited,List<Integer>[] edges){
        Deque<Integer> stack=new ArrayDeque<>();
        stack.push(startNode);
        while (!stack.isEmpty()){
            int node=stack.poll();
            for (int i:edges[node]){
                if (!visited[i]){
                    visited[i]=true;
                    stack.push(i);
                }
            }
        }

    }
    public void DFS(int startNode,boolean[] visited,List<Integer>[] edges){
        for (int i:edges[startNode]){
            if (!visited[i]){
                visited[i]=true;
                DFS(i,visited,edges);
            }
        }
    }
    public int makeConnected2(int n,int[][] connections){
        List<Integer>[] edgeTale=new List[n];
        //构造邻接表
        for (int i=0;i<n;i++){
            edgeTale[i]=new ArrayList<>();
        }
        for (int[] connection:connections){
            edgeTale[connection[0]].add(connection[1]);
            edgeTale[connection[1]].add(connection[0]);
        }
        boolean[] visited=new boolean[n];
        //首先计算连通个数
        int countChannel=0;
        int EdgeCount=0; //多余的边
        for (int i=0;i<n;i++){
            if (!visited[i]){
                countChannel++;
                EdgeCount+=BFS2(i,visited,edgeTale);
            }
        }
        if (EdgeCount>=(countChannel-1)) return countChannel-1;
        return -1;

    }
    //我们需要计算这个连通图中的多的线数，这个多的线数可以拆除用到别处
    public int BFS2(int startNode,boolean[] visited,List<Integer>[] grid){
        Deque<Integer> stack=new ArrayDeque<>();
        int nodeCount=1;
        int nodeEdge=0;
        visited[startNode]=true;
        stack.push(startNode);
        while (!stack.isEmpty()){
            int node=stack.poll();
            for (int i:grid[node]){
                if (!visited[i]){
                    nodeCount++;
                    visited[i]=true;
                    stack.push(i);
                }
            }
            nodeEdge+=grid[node].size();
        }

        return nodeEdge/2-(nodeCount-1);
    }
    public int makeConnected(int n,int[][] connections){
        //首先是有多少个连通图网络,并且计算每个连通图的环路路数
        int[][] grid=new int[n][n];
        //访问
        boolean[] visited=new boolean[n];
        for (int[] connection:connections){
            grid[connection[0]][connection[1]]=1;
            grid[connection[1]][connection[0]]=1;
        }
        //首先计算连通个数
        int countChannel=0;
        int EdgeCount=0; //多余的边
        for (int i=0;i<n;i++){
            if (!visited[i]){
                countChannel++;
                EdgeCount+=BFS(i,visited,grid);
            }
        }
        if (EdgeCount>=(countChannel-1)) return countChannel-1;
        return -1;
    }
    //我们需要计算这个连通图中的多的线数，这个多的线数可以拆除用到别处
    public int BFS(int startNode,boolean[] visited,int[][] grid){
        Deque<Integer> stack=new ArrayDeque<>();
        int nodeCount=1;
        int nodeEdge=0;
        visited[startNode]=true;
        stack.push(startNode);
        while (!stack.isEmpty()){
            int node=stack.poll();
            for (int i=0;i<grid.length;i++){
                if (grid[node][i]==1){
                    nodeEdge++;
                }
                if (!visited[i]&&grid[node][i]==1){
                    nodeCount++;
                    visited[i]=true;
                    stack.push(i);
                }
            }
        }

        return nodeEdge/2-(nodeCount-1);
    }
}
