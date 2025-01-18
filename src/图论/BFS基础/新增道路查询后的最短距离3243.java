package 图论.BFS基础;

import java.util.*;

public class 新增道路查询后的最短距离3243 {
    public static void main(String[] args) {
        新增道路查询后的最短距离3243 test = new 新增道路查询后的最短距离3243();
        int[][] arr=new int[][]{{2,4},{0,2},{0,4}};
        int[][] arr2=new int[][]{{0,3},{0,2}};
        test.shortestDistanceAfterQueries(5,arr);
        test.shortestDistanceAfterQueries(4,arr2);
    }
    public int min;
    public int count=0;
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] edges=new ArrayList[n];
        for (int i=0;i<n;i++){
            edges[i]=new ArrayList<>();
        }
        //构筑图
        for (int i=0;i<n-1;i++){
            edges[i].add(i+1);
        }

        int[] answer=new int[queries.length];
        for (int i=0;i<queries.length;i++){
            edges[queries[i][0]].add(queries[i][1]); //向图中加入一条边
            if (i>0&&queries[i][0]==queries[i-1][0]&&queries[i][1]<queries[i-1][0]){
                answer[i]=answer[i-1];
            }else{
                answer[i]=BFS(n,edges);
            }
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }
    public int BFS(int n,List<Integer>[] edges){
        Deque<Integer> deque=new ArrayDeque<>();
        int[] dist=new int[n];
        for (int i=1;i<n;i++){
            dist[i]=-1;
        }
        deque.add(0);
        while (!deque.isEmpty()){
            int s=deque.poll();
            for (int e:edges[s]){
                if (dist[e]>=0){
                    continue;
                }
                deque.add(e);
                dist[e]=dist[s]+1;
            }
        }
        return dist[n-1];
    }
    public void DFS(int start,List<Integer>[] edges){
        if (start==edges.length-1){
            min=Math.min(min,count);
            return;
        }
        //遍历从start出发可以到达的节点值
        for (int i:edges[start]){
            count++;
            DFS(i,edges);
            count--;
        }
    }
}
