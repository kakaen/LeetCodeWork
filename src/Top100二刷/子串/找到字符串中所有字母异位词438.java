package Top100二刷.子串;

import java.util.ArrayList;
import java.util.List;

public class 找到字符串中所有字母异位词438 {
    public static void main(String[] args) {
        找到字符串中所有字母异位词438 test = new 找到字符串中所有字母异位词438();
        String s="cbaebabacd";
        String p="abc";
        List<Integer> anagrams = test.findAnagrams(s, p);
        System.out.println(anagrams.toString());
    }
    public List<Integer> findAnagrams2(String s,String p){
        List<Integer> res=new ArrayList<>();
        int[] arr=new int[26];
        int pLength=p.length();
        int sLength=s.length();
        for (char ch:p.toCharArray()){
            arr[ch-'a']++;
        }
        int left=0,right;
        for (right=0;right<sLength;right++){
            char rightCh=s.charAt(right);
            int index=rightCh-'a';
            arr[index]--;
            //判断是否小于0
            while (arr[index]<0){
                arr[p.charAt(left)-'a']++;
                left++;
            }
            if (right-left+1==pLength){
                res.add(left);
            }
        }

        return res;
    }

    public List<Integer> findAnagrams(String s,String p){
        //给定字符串s和p，找到s中所有p的异位词的子串
        List<Integer> res=new ArrayList<>();
        int[] arr=new int[26];
        for (char ch:p.toCharArray()){
            arr[ch-'a']++;
        }
        int k=p.length();
        //滑动窗口
        int[] window=new int[26];
        int left=0,right=0;
        for (right=0;right<s.length();right++){
            //righ入窗口
            char ch=s.charAt(right);

            window[ch-'a']++;
            if (right<k-1) continue;
            //判断当前window是否满足异位词
            if (check(window,arr)){
                res.add(left);
            }
            char leftch=s.charAt(left);
            left++;
            window[leftch-'a']--;
        }
        return res;
    }
    private boolean check(int[] window,int[] arr){
        for (int i=0;i<window.length;i++){
            if (window[i]!=arr[i]) return false;
        }
        return true;
    }
}
