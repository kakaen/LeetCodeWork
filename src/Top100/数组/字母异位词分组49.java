package Top100.数组;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class 字母异位词分组49 {
    public static void main(String[] args) {

    }
}
class Solution49{
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map=new HashMap<>();
         for (String str:strs){
             char[] arr=str.toCharArray();
             Arrays.sort(arr);
             String s=new String(arr);
             if (map.containsKey(s)){
                 map.get(s).add(str);
             }else{
                 ArrayList<String> strings = new ArrayList<>();
                 strings.add(str);
                 map.put(s,strings);
             }

         }
        return new ArrayList<>(map.values());
    }
}
