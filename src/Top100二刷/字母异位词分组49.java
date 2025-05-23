package Top100二刷;

import java.util.*;

public class 字母异位词分组49 {
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        //所有字符串的key按照降序进行排列
        Map<String,List<String>> map=new HashMap<>();
        for (String str:strs){
            String key=sortStr(str);
            if (map.containsKey(key)){
                map.get(key).add(str);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }
        }
        for (Map.Entry<String,List<String>> entry:map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
    public String sortStr(String str){
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        //字母异位词
        List<List<String>> res=new ArrayList<>();
        //所有字符串的key都按照，降序进行排列
        Map<String,List<String>> map=new HashMap<>();
        int[] chs=new int[26];
        for (String str:strs){
            String sortKey=sortKey(str);
            if (map.containsKey(sortKey)){
                map.get(sortKey).add(str);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortKey,list);
            }
        }
        for (List<String> list:map.values()){
            res.add(list);
        }
        return res;
    }
    public String sortKey(String str){
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
