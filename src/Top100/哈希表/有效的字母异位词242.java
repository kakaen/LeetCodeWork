package Top100.哈希表;

import java.util.HashMap;
import java.util.Map;

public class 有效的字母异位词242 {
    public static void main(String[] args) {
        有效的字母异位词242 test = new 有效的字母异位词242();
        System.out.println(test.isAnagram("anagram", "nagaram"));
        System.out.println(test.isAnagram("rat", "car"));
    }
    public boolean isAnagram(String s,String t){
        //字母异位词，使用两个哈希表来双向映射
        Map<Character,Integer> map=new HashMap<>();
        for (char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (char ch:t.toCharArray()){
            if (!map.containsKey(ch)){
                return false;
            }
            map.put(ch,map.get(ch)-1);
            if (map.get(ch)==0) map.remove(ch);
        }
        return true;
    }
}
