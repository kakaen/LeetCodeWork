package 代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 组合77 {
    public static void main(String[] args) {

    }
}
class Solution77{
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combine(int n,int k){
        dfs(1,n,k);
        return result;
    }
    public void dfs(int starIndex,int n,int k){
        //如果当前path中的元素个数等于k，说明到达
        if (path.size()==k){
            result.add(path);
            return;
        }
        for (int i=starIndex;i<=n;i++){
            path.add(i);
            dfs(i+1,n,k);
            path.remove(path.size()-1);
        }
    }
}
