package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class 构成整天的下标对数目I3184 {
    public static void main(String[] args) {
        构成整天的下标对数目I3184 test = new 构成整天的下标对数目I3184();
        System.out.println(test.countCompleteDayPairs(new int[]{12, 12, 30, 24, 24}));
        System.out.println(test.countCompleteDayPairs(new int[]{72,48,24,3}));
    }
    public int countCompleteDayPairs(int[] hours){
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int hour:hours){
            int key=hour%24;
            if (map.containsKey((24-key)%24)){
                count+=map.get((24-key)%24);
            }
            map.put(key,map.getOrDefault(key,0)+1);
        }
        return count;
    }
    public int countCompleteDayPairs2(int[] hours){
        int[] count=new int[24];
        int pairs=0;
        for (int t:hours){
            pairs+=count[(24-t%24)%24];
            count[t%24]++;
        }
        return pairs;
    }
}
