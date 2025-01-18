package Top100二刷.动态规划;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角118 {
    public static void main(String[] args) {
        杨辉三角118 test = new 杨辉三角118();
        List<List<Integer>> generate = test.generate(1);
        for (List<Integer> list:generate){
            System.out.println(list);
        }
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        //dp[i][j]=dp[i-1][j-1]+dp[i-1][j]
        List<Integer> first=new ArrayList<>();first.add(1); //初始第一行
        res.add(first);
        for (int i=1;i<numRows;i++){
            List<Integer> curList=new ArrayList<>();
            List<Integer> preList = res.get(i - 1);
            for (int j=0;j<=i;j++){  //共有0--i个元素
                int count=0;
                if (j-1>=0) count+=preList.get(j-1);
                if (j<i) count+=preList.get(j);
                curList.add(count);
            }
            res.add(curList);
        }
        return res;

    }
}
