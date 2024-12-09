package 回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 组合总数III216 {
    public static void main(String[] args) {

    }
}
class Solution {
    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking2(1,k,n);
        return result;
    }
    public void backTracking(int starIndex,int k,int n){
        if (path.size()==k){
            if (n==0) result.add(new ArrayList<>(path));
            return;
        }
        for (int i=starIndex;i<=9;i++){
            path.add(i);
            backTracking(i+1,k,n-i);
            path.remove(path.size()-1);
        }
    }
    /**
     * 选或不选的操作,i表示还有多少个数可以选，初始为9.表示有9个数可以选择
     */
    public void backTracking2(int i,int k,int n){
        //剪枝操作
        int d=k-path.size(); //还要选d个数
        //剪枝1，小于最小的0，剪枝2还需要大于
        if (path.size()==k&&n==0) {
            result.add(new ArrayList<>(path));
            return;
        }
        //终止递归循环
        if (i==10) return;
        //不选i
        if (i>d){
            backTracking2(i+1,k,n);
        }
        //选i
        path.add(i);
        backTracking2(i+1,k,n-i);
        path.remove(path.size()-1);
    }
}
