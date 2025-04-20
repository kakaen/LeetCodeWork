package Top100二刷.滑动窗口.定长滑动窗口;

import javax.security.auth.callback.CallbackHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 找到字符串中所有字母异位词438 {
    public static void main(String[] args) {
        找到字符串中所有字母异位词438 test = new 找到字符串中所有字母异位词438();
        String s="cbaebabacd";
        String p="abc";
        List<Integer> anagrams = test.findAnagrams2(s, p);
        for (Integer i:anagrams){
            System.out.println(i);
        }
    }
    public List<Integer> findAnagrams2(String s,String p){
        int sLength=s.length();
        int pLength=p.length();
        int left=0,right=0;
        int[] arrayS=new int[26];
        int[] arrayP=new int[26];
        for (char ch:p.toCharArray()){
            arrayP[ch-'a']++;
        }
        List<Integer> res=new ArrayList<>();
        for (right=0;right<sLength;right++){
            char ch=s.charAt(right);
            arrayS[ch-'a']++;
            if (right<pLength-1) continue;
            //判断当前窗口是否满足异位词
            if (check(arrayS,arrayP)){
                res.add(left);
            }
            char leftChar=s.charAt(left);
            arrayS[leftChar-'a']--;
            left++;
        }
        //res返回
        return res;
    }
    public boolean check(int[] arrayS,int[] arrayP){
        for (int i=0;i<arrayS.length;i++){
            if (arrayS[i]!=arrayP[i]) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int[] arry1=new int[26];
        int[] arry2=new int[26];
        Map<Character,Integer> compareMap=new HashMap<>();
        for (char ch:p.toCharArray()){
            compareMap.put(ch,compareMap.getOrDefault(ch,0)+1);
            arry2[ch-'a']++;
        }
        for (right = 0; right < n1; right++) {
            char ch=s.charAt(right);
            //ch入窗口
            arry1[ch-'a']++;
            map.put(ch,map.getOrDefault(ch,0)+1);
            //
            if (right<n2-1) continue;
            //扩展左边界，使得
            if (check(map,compareMap)){
                res.add(left);
            }else{
                char leftCh=s.charAt(left);
                Integer i = map.get(leftCh);
                if (i==1){
                    map.remove(leftCh);
                }else {
                    map.put(leftCh,map.get(leftCh)-1);
                }
                left++;
            }
        }
        return res;
    }
    //进行比较，判断是否为
    public boolean check(Map<Character,Integer> map,Map<Character,Integer> compareMap){
        if (map.size()!=compareMap.size()){
            return false;
        }
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            char key=entry.getKey();
            if (compareMap.get(key)!=entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
