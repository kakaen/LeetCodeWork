package 代码随想录.回溯算法.组合问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 第77题组合 {
    public static void main(String[] args) {
        Soution77 soution77 = new Soution77();
        List<List<Integer>> combine = soution77.combine(1, 1);
        for (List<Integer> list:combine){
            System.out.println(list.toString());
        }

    }
}
class Soution77{
    //返回范围[1,n]中所有可能的k个数的组合
    public static List<List<Integer>> res=new ArrayList<>();
    public static List<Integer> path=new ArrayList<>();//存放单次的路径
    public List<List<Integer>> combine(int n,int k){
        //第一个数，可以从1-n中选取
        backTracking(n,1,k);
        return res;
    }
    //表示从start开始
    public void backTracking(int n,int start,int k){
        //在这里可以进行剪枝优化
        if (path.size()+(n-start+1)<k){
            return;
        }
        if (k==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<=n;i++){
            path.add(i);
            backTracking(n,i+1,k-1);
            path.remove(path.size()-1);
        }
    }
}
