package 图论.DFS基础;

import java.util.*;

public class 寻找图中是否存在路径1971 {
    public static void main(String[] args) {
        寻找图中是否存在路径1971 test = new 寻找图中是否存在路径1971();
        int[][] edges=new int[][]{{0,1},{1,2},{2,0}};
        int[][] edges2=new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(test.validPath(3, edges, 0, 2));
        System.out.println(test.validPath(6, edges2, 0, 5));
    }
    public boolean validPath(int n,int[][] edges,int source,int destination){
        //创建图
        List<Integer>[] grades=new ArrayList[n];
        boolean[] visited=new boolean[n];
        for (int i=0;i<n;i++){
            grades[i]=new ArrayList<>();
        }
        //构建图
        for (int[] edge:edges){
            grades[edge[0]].add(edge[1]);
            grades[edge[1]].add(edge[0]);
        }
        return BFS(grades,source,destination,visited);
    }
    public boolean BFS(List<Integer>[] grade,int source,int destination,boolean[] visited){
        Deque<Integer> deque=new ArrayDeque<>();
        visited[source]=true;
        deque.push(source);
        while (!deque.isEmpty()){
            Integer node = deque.poll();
            if (node==destination) return true;
            for (int e:grade[node]){
                if (!visited[e]){
                    visited[e]=true;
                    deque.push(e);
                }
            }
        }
        return false;
    }
    public boolean DFS(List<Integer>[] grade,int source,int destination,boolean[] visited){
        if (source==destination){
            return true;
        }
        visited[source]=true;
        boolean flag=false;
        for (int node:grade[source]){
            if (!visited[node]){
                visited[node]=true;
                flag=flag||DFS(grade,node,destination,visited);
            }
        }
        return flag;
    }
    public boolean validPath2(int n,int[][] edges,int source,int destination){
        boolean ans=false;
        //构造邻接表
        List<Integer>[] table=new List[n];
        for (int i=0;i<n;i++){
            table[i]=new ArrayList<>();
        }
        //构造邻接表
        for (int[] edge:edges){
            table[edge[0]].add(edge[1]);
            table[edge[1]].add(edge[0]);
        }

        boolean[] visited=new boolean[n];
        ans=DFS2(table,source,destination,visited);
        return ans;
    }
    //DFS2使用链表的方式来实现深度优先
    public boolean DFS2(List<Integer>[] tables,int source,int destination,boolean[] visited){
        if (source==destination){
            return true;
        }
        //将节点设置为true，表示已访问过
        visited[source]=true;

        for (int node:tables[source]){
            if (!visited[node]&&DFS2(tables,node,destination,visited)){
                return true;
            }
        }
        return false;
    }

}
