package 回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 组合总和39 {
    public static void main(String[] args) {

    }
}
class Solution39_2{
    public List<List<Integer>> res=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates,int target){
        //无重复元素的整数数组
        backTracking(candidates,target);
        return res;
    }
    public void backTracking(int[] candidates,int target){
        if (target<0) return;
        if (target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<candidates.length;i++){
            path.add(candidates[i]);
            backTracking(candidates,target-candidates[i]);
            path.remove(path.size()-1);
        }
    }
}
