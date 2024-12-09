package Top100二刷.回溯算法;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 全排列46 {
    public static void main(String[] args) {
        全排列46 test = new 全排列46();
        int[] nums=new int[]{1,2,3};
        test.permute(nums);
    }
    public List<List<Integer>> permute(int[] nums){
        //返回数组的全排列
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        boolean[] used=new boolean[nums.length]; //用来记录该元素是否已经使用过
        backTracking(nums,used,path,res);
        for (List<Integer> p:res){
            System.out.println(p);
        }
        return res;
    }
    public void backTracking(int[] nums,boolean[] used,List<Integer> path,List<List<Integer>> res){
        if (path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (used[i]) continue;
            path.add(nums[i]);
            used[i]=true;
            backTracking(nums,used,path,res);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
}
