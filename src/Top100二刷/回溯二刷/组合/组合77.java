package Top100二刷.回溯二刷.组合;

import java.util.ArrayList;
import java.util.List;

public class 组合77 {
    public static void main(String[] args) {
        组合77 test = new 组合77();
        List<List<Integer>> combine = test.combine(4, 2);
        for (List<Integer> list:combine){
            System.out.println(list.toString());
        }
    }
    public List<List<Integer>> combine(int n,int k){
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        //给定n和k，返回[1,n]中所有可能的k个数的组合
        //从1开始
        backtracking(res,1,n,path,k);
        return res;
    }
    public void backtracking(List<List<Integer>> res,int index,int n,List<Integer> path,int k){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        //实现剪枝操作
        //已选择的元素：path.size()
        //当前的下标 i
        //还需要选择：k-path.size()个元素
        //当前集合还剩多少个元素：n-i+1;
        // 如果 k-path.size()>n-i+1;则无法实现  i>n+1-k+path.size()
        //即i必须
        for (int i=index;i<=n-(k-path.size())+1;i++){
            path.add(i);
            backtracking(res,i+1,n,path,k);
            path.remove(path.size()-1);
        }
    }
}
