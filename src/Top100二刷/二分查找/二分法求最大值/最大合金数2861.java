package Top100二刷.二分查找.二分法求最大值;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 最大合金数2861 {
    public static void main(String[] args) {
        最大合金数2861 test = new 最大合金数2861();

    }
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost){
        //n种不同金属，使用k台机器来制作
        //第i台机器，创建合金composition[i][j]份j类型金属。你有stock[i]份i类型金属
        //composition表示
        //最大话公司制作合金数量
        //先计算各个机器制作一个合金所需的成本
        List<Integer> mechaineCost=new ArrayList<>();
        for (int i=0;i<k;i++){
            int sum=0;
            for (int j=0;j<n;j++){
                sum+=composition.get(i).get(j)*cost.get(j);
            }
            mechaineCost.add(sum); //一个机器制作出来所需的成本
        }
        int ans=0;
        //遍历每个机器可以制作的最大合金数
        for (List<Integer> list:composition){
            ans=Math.max(ans,maxCount(budget,list,stock,cost));
        }
        return ans;
    }
    public int maxCount(int budget,List<Integer> list,List<Integer> stock,List<Integer> cost){
        int l=0;
        int r=0;
        int oneCost=0;
        //求最多可以制作多少合金金属
        for (int i=0;i<list.size();i++){
            r=Math.max(r,(stock.get(i)+list.get(i)-1)/list.get(i));
            oneCost+=list.get(i)*cost.get(i);
        }
        r+=(budget+oneCost-1)/oneCost;
        while (l<=r){
            int m=l+(r-l)/2;
            if (check(m,budget,list,stock,cost)){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return r;
    }
    public boolean check(int m,int budget,List<Integer> list,List<Integer> stock,List<Integer> cost){
        //总共需要的原材料
        List<Integer> collect = list.stream().map(x -> x * m).collect(Collectors.toList());
        long sumCost=0;
        for (int i=0;i<collect.size();i++){
            if (stock.get(i)<collect.get(i)){
                sumCost+= (collect.get(i)-stock.get(i))*cost.get(i);
            }
        }
        return budget>=sumCost;
    }
}
