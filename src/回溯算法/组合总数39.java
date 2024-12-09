package 回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 组合总数39 {
    public static void main(String[] args) {

    }
}
class Solution39 {
    public List<List<Integer>> result = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(0, candidates, target);
        return result;
    }
    public void backTracking(int i,int[] candidates,int target){
        if (target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        //剪枝，当target小于0时返回
        if (target<0||i==candidates.length) return;

        //不选i
        backTracking(i+1,candidates,target);
        //选i
        path.add(candidates[i]);
        backTracking(i,candidates,target-candidates[i]);
        path.remove(path.size()-1);
    }
}
