package 回溯算法;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class 子集78 {
    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        int[] nums={1,2,3};
        List<List<Integer>> subsets = solution78.subsets(nums);
        for (List<Integer> list:subsets){
            System.out.println(list.toString());
        }
    }
}
class Solution78 {
    public List<List<Integer>> result=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public Queue<Integer> path2=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        backTracking(0,nums);
        return result;
    }

    /**
     * 两种思路，一是站在答案的视角，每次必须选择一个数
     * @param index
     * @param nums
     */
    public void backTracking(int index,int[] nums){
        result.add(new ArrayList<>(path));
        if (index==nums.length){
            return;
        }
        for (int i=index;i<nums.length;i++){
            path.add(nums[i]);
            backTracking(i+1,nums);
            path.remove(path.size()-1);
        }
    }
}
