package 代码随想录.回溯算法.组合问题;

import java.util.ArrayList;
import java.util.List;

public class 组合总和III216 {
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k,int n){
        //找出所有相加之和为n的k个数的组合
        backTracking(k,1,n);
        return res;
    }
    public void backTracking(int k,int start,int n){
        //满足
        if (n==0&&path.size()==k){
            res.add(new ArrayList<>(path));
        }
        for (int i=start;i<=9;i++){
            path.add(i);
            backTracking(k,i+1,n-i);
            path.remove(path.size()-1);

        }
    }
}
