package 回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 组合总和III_216 {
    public static void main(String[] args) {

    }
}
class Solution216_2{
    public List<List<Integer>> res=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k,int n){
        //找出所有相加之和为n的k个数的组合
        backTracking(0,n,k);
        return res;
    }
    public void backTracking(int startIndex,int n,int k){
        //1.进行剪枝优化，如果n小于0则直接返回
        if (n<0){
            return;
        }
        if (path.size()==k){
            if (n==0) res.add(new ArrayList(path)); //如果为k个数
            return;
        }
        for (int i=startIndex;i<n;i++){
            path.add(i);
            backTracking(i+1,n-i,k);
            path.remove(path.size()-1);
        }
    }

}
