package 代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 子集78 {
}
class Solution78 {
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        dfs(0,nums,0);
        return result;
    }
    public void dfs(int i,int[] nums,int starIndex){
        //每次都将path加入到结果中
        result.add(path);//递归到的每个节点都是答案
        if (i==nums.length) return; //如果当前递归到i,则返回
        for (int j=0;i<nums.length;i++){
            path.add(nums[j]);
            dfs(i+1,nums,starIndex);
            path.remove(path.size()-1);
        }
    }
}