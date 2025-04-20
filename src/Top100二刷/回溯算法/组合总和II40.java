package Top100二刷.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和II40 {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    boolean[] userd;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //can中所有数字只能使用一次
        userd=new boolean[candidates.length];
        Arrays.sort(candidates);
        backtracking(0,candidates,target);
        return res;
    }
    public void backtracking(int start,int[] candidates,int target){
        if (target<0) return;
        if (target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        //我的start也
        for (int i=start;i<candidates.length;i++){
            //因为对于同一层来说，你的i都是大于start的
            //而对于同一树枝来说，
            if(i>start&&candidates[i]==candidates[i-1]) continue; //对统一层数使用过的元素进行跳过；
            path.add(candidates[i]);
            backtracking(i+1,candidates,target-candidates[i]);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        组合总和II40 test = new 组合总和II40();
        List<List<Integer>> lists = test.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }
}
