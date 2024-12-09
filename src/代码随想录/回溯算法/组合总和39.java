package 代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 组合总和39 {
    public static void main(String[] args) {

    }
}
class Solution39 {
    public List<List<Integer>> result=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(target,0,candidates,0);
        return result;
    }
    public void backTracking(int target,int sum,int[] candidates,int starIndex){
        if (target==sum){
            result.add(new ArrayList<>(path));
        } else if (sum>target) {
            return;
        }
        for (int i=0;i<candidates.length;i++){
            path.add(candidates[i]);
            sum+=candidates[i];
            backTracking(target,sum,candidates,i);
            path.remove(path.size()-1);
            sum-=candidates[i];
        }
    }
}