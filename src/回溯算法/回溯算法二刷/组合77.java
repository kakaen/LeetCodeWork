package 回溯算法.回溯算法二刷;

import 动态规划算法.打家劫舍.统计放置房子的方式数2320;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 组合77 {
    public static List<Integer> path=new ArrayList<>();
    public static List<List<Integer>> res=new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();

        组合77 test = new 组合77();
        test.dfs(n,1,k);
        for (List<Integer> p:res){
            System.out.println(p);
        }
    }
    public void dfs(int n,int startIndex,int k){

        if (path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        //进行剪枝操作,如果i的下标
        for (int i=startIndex;i<=n-(k-path.size())+1;i++){
            path.add(i);
            dfs(n,i+1,k);
            path.remove(path.size()-1);
        }
    }
}
