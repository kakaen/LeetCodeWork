package 图论;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 使用邻接表来存储边信息的所有可达路径98 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        //创建邻接表来存储
        List<Integer>[] table=new List[N+1];
        //邻接表的初始化
        for (int i=0;i<N+1;i++){
            table[i]=new ArrayList<>();
        }
        //构建边的信息
        for (int i=0;i<M;i++){
            int start=scanner.nextInt();
            int end=scanner.nextInt();
            table[start].add(end);
        }
        //进行
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        path.add(1);
        dfs(1,table,path,res);
        if (res.size()==0){
            System.out.println(-1);
        }
        //遍历res
        for (List<Integer> pa:res){
            for (int i=0;i<pa.size()-1;i++){
                System.out.print(pa.get(i)+" ");
            }
            System.out.println(pa.get(pa.size()-1));
        }
        scanner.close();
    }
    public static void dfs(int startNode,List<Integer>[] table,List<Integer> path,List<List<Integer>> res){
        if (startNode==table.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i:table[startNode]){
            path.add(i);
            dfs(i,table,path,res);
            path.remove(path.size()-1);
        }
    }
}
