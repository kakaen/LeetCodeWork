package Top100二刷;

import java.util.*;

public class 找到字符串中所有字母异位词438 {

    public List<Integer> findAnagrams(String s,String p){
        //找到所有异位词
        //将p转为map
        int[] table=new int[26]; //记录p的元素
        for (char ch:p.toCharArray()){
            table[ch-'a']++;
        }
        //异位词，因此是定长的滑动窗口
        int left=0,right=0;
        char[] chars=s.toCharArray();
        Map<Character,Integer> windows=new HashMap<>();
        int k=p.length(); //定长窗口长度
        List<Integer> res=new ArrayList<>();
        for (right=0;right<s.length();right++){
            char ch=chars[right];
            //说明ch字符不在p字符串中。
            if (table[ch-'a']==0){
                left=right+1;
                continue;
            }
            if (right-left+1<p.length()){
                continue;
            }
            if (compaireStr(s.substring(left,right+1),table)){
                res.add(left);
                left=left+1;
            }else{
                left++;
            }
        }
        return res;
    }
    public boolean compaireStr(String str,int[] table){
        int[] newTable=new int[26];
        for (Character ch:str.toCharArray()){
            newTable[ch-'a']++;
        }
        for (int i=0;i<newTable.length;i++){
            if (table[i]!=newTable[i]) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams2(String s,String p){
        //记录答案
        List<Integer> res=new ArrayList<>();
        //统计s的字符
        int[] cnts=new int[26];
        int[] cntp=new int[26];
        for (char ch:p.toCharArray()){
            cntp[ch-'a']++;
        }
        int left=0;
        for (int right=0;right<s.length();right++){
            //right字符入窗口
            cnts[s.charAt(right)-'a']++;
            if (right<p.length()-1){
                continue;
            }
            //此时滑动窗口达到定长，判断窗口是否一致
            if (Arrays.equals(cnts,cntp)){
                res.add(left);
            }
            //窗口左指针右移一位
            cnts[s.charAt(left)-'a']--;
            left++;
        }
        return res;
    }

    //不定长窗口来实现
    public List<Integer> findAnagrams3(String s,String p){
        List<Integer> res=new ArrayList<>();
        int[] cntp=new int[26];
        for (char ch:p.toCharArray()){
            cntp[ch-'a']++;
        }
        int[] cnts=new int[26];
        //枚举右字符，如果发现右字符出现的次数大于p中的字符
        int left=0,right=0;
        for (right=0;right<s.length();right++){
            char ch=s.charAt(right);
            //枚举子串的右字符
            cnts[ch-'a']++;
            while (cnts[ch-'a']>cntp[ch-'a']){
                cnts[s.charAt(left)-'a']--;
                left++;
            }
            if (right-left+1==p.length()){
                res.add(left);
            }
        }
        return res;
    }
    //找到字符串中所有字母异位词438，采用单个数组来实现，不定长窗口
    public List<Integer> findAnagrams4(String s,String p){
        List<Integer> res=new ArrayList<>();
        int[] table=new int[26]; //记录p字符的个数
        for (char ch:p.toCharArray()){
            table[ch-'a']++;
        }
        int n=s.length();
        int left=0;
        for (int right=0;right<n;right++) {
            //右指针入窗口，
            table[s.charAt(right) - 'a']--;
            //说明当前left不可以作为
            while (table[s.charAt(right) - 'a'] < 0) {
                table[s.charAt(left) - 'a']++;
                left++;
            }
            if (right - left + 1 == p.length()) {
                res.add(left);//resadd
                table[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return res;
    }
    //定长窗口
    public List<Integer> findAnagrams5(String s,String p){
        int[] table=new int[26];
        int[] table2=new int[26]; //保存s的窗口值
        //将p映射为table哈希表
        for (char ch:p.toCharArray()){
            table[ch-'a']++;
        }
        int left=0;
        List<Integer> res=new ArrayList<>();
        for (int right=0;right<s.length();right++){
            //右指针入窗口
            table2[s.charAt(right)-'a']++;
            if (right<p.length()-1) continue;
            //判断是否相当
            if (Arrays.equals(table,table2)){
                res.add(left);
            }
            table2[s.charAt(left)-'a']--;
            left++;
        }
        return res;
    }
    public static void main(String[] args) {
        找到字符串中所有字母异位词438 test = new 找到字符串中所有字母异位词438();
        List<Integer> anagrams = test.findAnagrams4("abab", "ab");
        List<Integer> anagram2s = test.findAnagrams4("cbaebabacd", "abc");
        System.out.println(anagrams.toString());
        System.out.println(anagram2s.toString());
    }
}
