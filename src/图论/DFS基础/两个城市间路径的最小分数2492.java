package 图论.DFS基础;

import 动态规划算法.不同的二叉搜索树96;

import java.util.*;

public class 两个城市间路径的最小分数2492 {
    public static void main(String[] args) {
        两个城市间路径的最小分数2492 test = new 两个城市间路径的最小分数2492();
        int[][] roads = new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}};
        int[][] roads2 = new int[][]{{1, 2, 2}, {1, 3, 4}, {3, 4, 7}};
        int[][] roads3 = new int[][]{{4,5,7468},{6,2,7173},{6,3,8365},{2,3,7674},{5,6,7852},{1,2,8547},{2,4,1885},{2,5,5192},
        {1,3,4065},{1,4,7357}};
        System.out.println(test.minScore(4, roads));
        System.out.println(test.minScore(4, roads2));
        System.out.println(test.minScore(6, roads3));
    }

    public int minScore(int n, int[][] roads) {
        //使用邻接表来存储图
        List<int[]>[] edges=new List[n+1]; //list存储的是到
        for (int i=1;i<edges.length;i++){
            edges[i]=new ArrayList<>();
        }
        //构造邻接表
        for (int[] edge:roads){
            int from=edge[0]; int to=edge[1]; int dis=edge[2];
            edges[from].add(new int[]{to,dis});
        }
        boolean[] visited = new boolean[n + 1];

        //从节点一出发
        visited[1] = true;
        BFS(1, edges, visited);
        return min;
    }
    public int min=Integer.MAX_VALUE;
    public void BFS(int start,List<int[]>[] edges,boolean[] visited){
        Deque<Integer> deque=new ArrayDeque<>();
        deque.push(start);
        while (!deque.isEmpty()){
            int i = deque.poll();
            for (int[] edge : edges[i]) {
                min=Math.min(min,edge[1]);
                if (!visited[edge[0]]){
                    visited[edge[0]]=true;
                    deque.push(edge[0]);
                }
            }
        }
    }
    public void DFS(int star, int[][] edges,boolean[] visited){
        for (int i=0;i<edges.length;i++){
            if (edges[star][i]!=0) min=Math.min(min,edges[star][i]);
            if (!visited[i]&&edges[star][i]!=0){
                visited[i]=true;
                DFS(i,edges,visited);
            }
        }
    }
}


