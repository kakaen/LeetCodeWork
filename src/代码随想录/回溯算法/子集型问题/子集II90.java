package 代码随想录.回溯算法.子集型问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集II90 {
}
class Solution90 {
    public List<List<Integer>> result=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //先把nums进行排序
        Arrays.sort(nums);

        return result;
    }
    public void backTracking(int[] nums,int starIndex){
        result.add(new ArrayList<>(path)); //将节点加入到结果集中
        if (path.size()== nums.length) return;
        for (int num:nums){
            path.add(num);

        }
    }
}