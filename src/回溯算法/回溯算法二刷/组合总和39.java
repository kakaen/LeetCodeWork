package 回溯算法.回溯算法二刷;

import java.util.ArrayList;
import java.util.List;

public class 组合总和39 {
    public List<List<Integer>> res=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates,int target){
        //无重复的整数数组candidate和一个目标整数target
        //找出使数字和为目标数target的不同组合
        dfs(candidates,0,target);
        return res;
    }
    public void dfs(int[] candidates,int start,int target){
        if (target<0) return;
        if (target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        //
        for (int i=start;i<candidates.length;i++){
            path.add(candidates[i]);
            dfs(candidates,i,target-candidates[i]);
            path.remove(path.size()-1);
        }
    }
}
