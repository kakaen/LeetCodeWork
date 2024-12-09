package 难度训练;

import java.util.HashMap;
import java.util.Map;

public class 哈沙德数3099 {
    public static void main(String[] args) {
        Solution3099 solution3099 = new Solution3099();
        System.out.println(solution3099.sumOfTheDigitsOfHarshadNumber(18));
    }
}
class Solution3099{
    public int sumOfTheDigitsOfHarshadNumber(int x){
        int count=x;
        int num=0;
        //计算各个位置之和
        while (count>0){
            num=num+count%10;
            count=count/10;
            Map<Integer,Integer> map=new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            }
        }
        return x%num==0?num:-1;
    }
}
