package 代码随想录.回溯算法.子集型问题;

import java.util.ArrayList;
import java.util.List;

public class 子集78 {
    public static void main(String[] args) {

    }
}
class Solution78{
    public List<List<Integer>> res=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums){
        backtracking(0,nums);
        return res;
    }
    public void backtracking(int starIndex,int[] nums){
        //每一个元素都要加入
        res.add(new ArrayList<>(path));
        if (starIndex==nums.length) return;
        for (int i=starIndex;i<nums.length;i++){
            path.add(nums[i]);
            backtracking(i+1,nums);
            path.remove(path.size()-1);
        }
    }

}