package Top100二刷.回溯算法;

import java.util.*;

public class 组合总数III216 {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n){
        backtracking(1,k,n);
        return res;
    }
    public void backtracking(int start,int k,int n){
        if (n<0) return;
        if (path.size()==k){
            if (n==0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i=start;i<=9-(k-path.size())+1;i++){
            path.add(i);
            backtracking(i+1,k,n-i);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        组合总数III216 test = new 组合总数III216();
        List<List<Integer>> lists = test.combinationSum3(3, 7);
        for (List<Integer> lsit:lists){
            System.out.println(lsit);
        }
    }
}
