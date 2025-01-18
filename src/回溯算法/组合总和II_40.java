package 回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 组合总和II_40 {
    public List<List<Integer>> res=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //candidate中的每个数字只有一次
        dfs(candidates,0,target);
        return res;
    }
    public void dfs(int[] candidates,int startIndex,int target){
        if (startIndex==candidates.length||target<0) return;
        if (target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=startIndex;i<candidates.length;i++){
            path.add(candidates[i]);
            dfs(candidates,i,target-candidates[i]);
            path.remove(path.size()-1);
        }
    }
}
