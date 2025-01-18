package 图论;

import java.util.*;

public class BFS方式进行搜索图的路径 {
    public static void main(String[] args) {
        //使用BFS进行查询
        int N,M; //表示图中有N个节点和M条边
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();//表示有多少个节点
        //这个是使用邻接矩阵来存储边的信息的
        boolean[][] edge=new boolean[N+1][N+1]; //因为有N个节点所以申请N+1的空间
        //这个就是队列
        Queue<List<Integer>> queue=new LinkedList<>();
        queue.add(new ArrayList<>());
    }
}
