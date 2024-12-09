package 回溯算法;

import java.util.*;

public class 组合总和II40 {
    public static void main(String[] args) {

    }
}
class Solution40 {
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> result=new ArrayList<>();
    public Set<Integer> set=new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return result;
    }
    public void backTracking(int i,int[] candidates,int target){
        //边界条件
        if (i==candidates.length||target<0) return;
        if (target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        //不选
        if (set.contains(candidates[i])){
            backTracking(i+1,candidates,target);
        }
        //选
        path.add(candidates[i]);
        set.add(candidates[i]);
        backTracking(i+1,candidates,target-candidates[i]);
        path.remove(path.size()-1);
        set.remove(candidates[i]);
    }
}
