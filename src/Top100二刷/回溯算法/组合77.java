package Top100二刷.回溯算法;

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
    List<Integer> path=new ArrayList<>();
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n,int k){
        backtracking(1,n,k);
        return res;
    }
    public void backtracking(int star,int n,int k){
        //返回【1，n】中的k个数
        if (path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        //在这个位置进行优化
        //k-path.size<=n-i+1; i<=n-(k-path.size)+1
        for (int i=star;i<=n-(k-path.size())+1;i++){
            path.add(i);
            backtracking(i+1,n,k);
            path.remove(path.size()-1);
        }
    }
}
