package Top100二刷.回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 子集78 {
    public static void main(String[] args) {
        子集78 tets = new 子集78();
        List<List<Integer>> subsets = tets.subsets(new int[]{1, 2, 3});
        for (List<Integer> p:subsets){
            System.out.println(p);
        }
    }
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        dfs(nums,0,path,res);
        return res;
    }
    public void dfs(int[] nums,int start,List<Integer> path,List<List<Integer>> res){
        if (start==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        //不选该元素
        dfs(nums,start+1,path,res);
        //选该元素
        path.add(nums[start]);
        dfs(nums,start+1,path,res);
        path.remove(path.size()-1);
    }
    public void backTracking(int[] nums,int start,List<Integer> path,List<List<Integer>> res){
        res.add(new ArrayList<>(path));
        if (start==nums.length) return;
        for (int i=start;i<nums.length;i++){
            path.add(nums[i]);
            backTracking(nums,i+1,path,res);
            path.remove(path.size()-1);
        }
    }

}
