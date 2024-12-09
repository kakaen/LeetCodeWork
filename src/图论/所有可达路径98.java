package 图论;

import javafx.scene.transform.Scale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 所有可达路径98 {
    public static void main(String[] args) {
        int N,M; //表示图中有N个节点和M条边
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();//表示有多少个节点
        //这个是使用邻接矩阵来存储边的信息的
        boolean[][] edge=new boolean[N+1][N+1]; //因为有N个节点所以申请N+1的空间
        //我们创建一个邻接表来存储相关边的信息
        List<Integer>[] table=new List[N+1]; //总共有N个节点
        M=scanner.nextInt(); //输出M条边
        //输入边的相关信息
        for (int i=0;i<M;i++){
            int start=scanner.nextInt();
            int end=scanner.nextInt();
            edge[start][end]=true;
        }
        List<Integer> path=new ArrayList<>(); //存放所有路径
        List<List<Integer>> res=new ArrayList<>();//存放所有的路径答案
        path.add(1);
        //求所有的可到达路径，从节点1开始进行遍历
        dfs(1,edge,path,res);
        if (res.size()==0){
            System.out.println(-1);
        }
        for (List<Integer> p:res){
            for (int i=0;i<p.size();i++){
                if (i<p.size()-1){
                    System.out.print(p.get(i)+" ");
                }else{
                    System.out.print(p.get(i));
                }
            }
        System.out.println();
        }
    }
    //表示从start出发
    public static void dfs(int start,boolean[][] edge,List<Integer> path,List<List<Integer>> res){
        if (start==edge.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
        //进行遍历start节点的所有出度
        for (int i=1;i<edge.length;i++){
            if (edge[start][i]==false) continue; //如果不存在边则直接跳过
            path.add(i); //这里下标需要加一
            dfs(i,edge,path,res);
            //回溯
            path.remove(path.size()-1);
        }
    }
}
