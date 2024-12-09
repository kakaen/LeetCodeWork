package 回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 组合216 {
    public static void main(String[] args) {

    }
}
class Solution216{
    public List<List<Integer>> res=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k,int n){
        //找出所有相加之和为n的k个数的组合
        backtracking(1,n,k);
        //
        return res;
    }
    public void backtracking(int startIndex,int n,int k){
        if (n<0) return;
        if (path.size()==k){
            if (n==0) res.add(new ArrayList<>(path));
        }
        for (int i=startIndex;i<=9;i++){
            path.add(i);
            backtracking(i+1,n-i,k);
            path.remove(path.size()-1);
        }
    }
}
