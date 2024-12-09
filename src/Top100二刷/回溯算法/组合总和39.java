package Top100二刷.回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 组合总和39 {
    public static void main(String[] args) {
        组合总和39 test = new 组合总和39();
        int[] candidates=new int[]{2,3,6,7};
        List<List<Integer>> lists = test.combinationSum(candidates, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
    public List<List<Integer>>combinationSum(int[] candidates,int target){
        //找出组合为target的所有不同组合
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        dfs2(candidates,0,target,path,res);
        return res;
    }
    //采用选或者不选的方式来进行递归遍历
    public void dfs2(int[] candidates,int start,int target,List<Integer> path,List<List<Integer>> res){
        if (target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        if (target<0||start==candidates.length){
            return;
        }
        //不选该元素
        dfs2(candidates,start+1,target,path,res);
        //选can[start]元素
        path.add(candidates[start]);
        dfs2(candidates,start,target-candidates[start],path,res);
        path.remove(path.size()-1);
    }
    public void dfs(int[] candidates,int start,int target,List<Integer> path,List<List<Integer>> res){
        if (target<0){
            return;
        } else if (target==0) {
            res.add(new ArrayList<>(path));
        }
        for (int i=start;i<candidates.length;i++){
            path.add(candidates[i]);
            dfs(candidates,i,target-candidates[i],path,res);
            path.remove(path.size()-1);
        }
    }

}
