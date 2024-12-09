package 代码随想录.哈希表;

import java.util.HashSet;
import java.util.Set;

public class 快乐数202 {
}
class Solution202 {
    public boolean isHappy(int n) {
        //每一次将该数替换为它每个位置上的数字的平方和。
        //然后重复这个过程直到这个数变为1
        Set<Integer> record=new HashSet<>();
        while (n!=1&&!record.contains(n)){
            record.add(n);
            n=replace(n);
        }
        return n==1;
    }
    public int replace(int n){
        int result=0;
        while (n>0){
            int x=n%10;
            result+=x*x;
            n=n/10;
        }
        return result;
    }
}