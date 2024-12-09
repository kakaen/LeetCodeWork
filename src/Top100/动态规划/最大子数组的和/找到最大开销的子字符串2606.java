package Top100.动态规划.最大子数组的和;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class 找到最大开销的子字符串2606 {
    public static void main(String[] args) {
        找到最大开销的子字符串2606 test = new 找到最大开销的子字符串2606();
        System.out.println(test.maximumCostSubstring("adaa", "d", new int[]{-100}));
    }
    public int maximumCostSubstring(String s,String chars,int[] vals){
        //只有小写字母
        //字符的价格，如果字符不在字符串chars中，那它的价格是字母表中的排序，
        //在chars中，他的价值为，vals[i]。返回s的所有子串中的最大开销
        Map<Character,Integer> map=new HashMap<>(); //将chars中的字符和下标建立映射关系
        for (int i=0;i<chars.length();i++){
            map.put(chars.charAt(i),i);
        }
        int max=0;
        int count=0; //前i-1个字符的开销
        //然后遍历S中的每个下标，如果前i-1个下标的和大于0，则加上前i-1个的和，否则，单独
        for (char ch:s.toCharArray()){
            if (count>0){
                count=count+(map.containsKey(ch)?vals[map.get(ch)]:ch-'a'+1);
            }else{
                count=map.containsKey(ch)?vals[map.get(ch)]:ch-'a'+1;
            }
            max=Math.max(max,count);
        }
        return max;
    }

}
