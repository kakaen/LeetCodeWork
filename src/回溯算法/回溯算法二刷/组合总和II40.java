package 回溯算法.回溯算法二刷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和II40 {
    public static void main(String[] args) {
        组合总和II40 test = new 组合总和II40();
        int[] can=new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> lists = test.combinationSum2(can, 8);
        for (List<Integer> p:lists){
            System.out.println(p);
        }
    }
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,target);
        return res;
    }
    public void dfs(int[] candidates,int start,int target){
        if (target<0) return;
        if (target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<candidates.length;i++){
            if (i>start&&candidates[i]==candidates[i-1]) continue;
            path.add(candidates[i]);
            dfs(candidates,i+1,target-candidates[i]);
            path.remove(path.size()-1);
        }
    }

}
