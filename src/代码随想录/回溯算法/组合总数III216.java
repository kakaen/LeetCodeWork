package 代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 组合总数III216 {
    public static void main(String[] args) {

    }
}
class Solution216 {
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> result=new ArrayList<>();
    public int count=0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(1,k,n,0);
        return result;
    }
    public void backTracking(int starIndex,int k,int n,int sum){
        if (path.size()==k){
            if (sum==n) result.add(new ArrayList<>(path));
            return;
        }
        for (int i=starIndex;i<=9;i++){
            path.add(i);
            sum+=i;
            backTracking(starIndex+1,k,n,sum);
            path.remove(path.size()-1);
            sum-=i;
        }
    }
}