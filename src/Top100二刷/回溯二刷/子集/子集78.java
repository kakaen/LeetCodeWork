package Top100二刷.回溯二刷.子集;

import java.util.ArrayList;
import java.util.List;

public class 子集78 {
    public List<List<Integer>> subsets(int[] nums){
        //返回该数组所有可能的子集
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        backtracking(0,nums,res,path);
        return res;
    }
    public void backtracking(int index,int[] nums,List<List<Integer>> res,List<Integer> path){
        //因为是子集，就不需要进行判断什么条件，每个path都需要加入到结果集中
        res.add(new ArrayList<>(path));
        if (index==nums.length) return;

        for (int i=index;i<nums.length;i++){
            path.add(nums[i]);
            backtracking(i+1,nums,res,path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        子集78 test = new 子集78();
        List<List<Integer>> subsets = test.subsets(new int[]{1, 3, 2});
        for (List<Integer> list:subsets){
            System.out.println(list.toString());
        }
    }
}
