package Top100.哈希表;

import java.util.*;

public class 字母异位词分组49 {
    public static void main(String[] args) {
        字母异位词分组49 test = new 字母异位词分组49();
        String[] strs=new String[]{""};
        String[] strs2=new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(test.groupAnagrams(strs));
        System.out.println(test.groupAnagrams(strs2));
    }
    public List<List<String>> groupAnagrams(String[] strs){
        //字母异位词，重新排列源
        List<List<String>> res=new ArrayList<>();
        //字母异位词，将字母异位词.
        StringBuilder builder=new StringBuilder();
        //先将所有元素进行排序
        Map<String,List<String>> map=new HashMap<>();
        for (String str:strs){
            String key=sortStr(str);
            if (!map.containsKey(key)){
                List<String> re=new ArrayList<>();
                re.add(str);
                map.put(key,re);
            }else{
                map.get(key).add(str);
            }
        }
        for (List<String> list:map.values()){
            res.add(list);
        }
        return res;
    }
    public String sortStr(String str){
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
