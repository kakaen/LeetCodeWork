package Top100.哈希表;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 快乐数202 {
    public boolean isHappy(int n){
        Set<Integer> set=new HashSet<>(); //设置为不重复的集合
        while (n!=1&&!set.contains(n)){
            set.add(n);
            n=toNum(n);
        }
        return n==1;
    }
    public int toNum(int n){
        int ans=0;
        while (n>0){
            ans+=(n%10)*(n%10);
            n=n/10;
        }
        return ans;
    }
}
