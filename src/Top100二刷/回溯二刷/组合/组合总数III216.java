package Top100二刷.回溯二刷.组合;

import 设计模式.工厂模式.工厂方法模式;

import java.util.ArrayList;
import java.util.List;

public class 组合总数III216 {
    public static void main(String[] args) {
        组合总数III216 test = new 组合总数III216();
        List<List<Integer>> lists = test.combinationSum3(3, 7);
        for (List<Integer> list:lists){
            System.out.println(list.toString());
        }
    }
    public List<List<Integer>> combinationSum3(int k,int n){
        //找出所有相加之和为n的k个数的组合，只使用1-9，每个数字最多使用一次
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        backtracking(res,path,1,n,k);
        return res;
    }
    public void backtracking(List<List<Integer>> res,List<Integer> path,int index,int n,int k){
        //选或者不选的方法
        if (path.size()==n){
            if (k==0){
                res.add(new ArrayList<>(path));
            }
        }

        //不选这个数字
        backtracking(res,path,index+1,n,k);
        //选这个数字


    }
}
