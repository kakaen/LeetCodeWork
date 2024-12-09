package 回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 选和不选的子集型78 {
    public static void main(String[] args) {

    }
}
class Solution78I{
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums,0);
        return result;
    }
    public void backTracking(int[] nums,int starIndex){

        if (starIndex==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //不选当前元素
        backTracking(nums,starIndex+1);
        //选当前元素
        path.add(nums[starIndex]);
        backTracking(nums,starIndex+1);
        path.remove(path.size()-1);
    }
}
