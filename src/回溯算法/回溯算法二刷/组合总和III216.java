package 回溯算法.回溯算法二刷;

import 动态规划算法.打家劫舍.统计放置房子的方式数2320;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 组合总和III216 {
    public static List<Integer> path=new ArrayList<>();
    public static List<List<Integer>> res=new ArrayList<>();
    public static void main(String[] args) {
        //相加为n的k个数的组合
        //不能包含相同组合
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        组合总和III216 tets = new 组合总和III216();
        tets.dfs(n,1,k);
        for (List<Integer> p:res){
            System.out.println(p);
        }

    }
    public void dfs(int n,int start,int k){
        //进行剪枝操作
        int d=k-path.size(); //还有多少个元素
        //剪枝是如果当前元素和已经超过，或者
        if (n<0||n>(start*2-d+1)*d/2) return;
        if (k==0){
            if (n==0) res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<=9;i++){
            path.add(i);
            dfs(n-i,i+1,k-1);
            path.remove(path.size()-1);
        }
    }
}
