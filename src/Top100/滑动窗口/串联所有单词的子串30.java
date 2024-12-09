package Top100.滑动窗口;

import java.util.*;

public class 串联所有单词的子串30 {
    public static void main(String[] args) {

    }
    public List<Integer> findSubstring(String s,String[] words){
        //String[]中有很多个string
        int n=words.length; //总共有n个单词。因此也就有n个串联子串。
        List<Integer> res=new ArrayList<>(); //
        int[] index=new int[n]; //存储每个单词在s中的下标
        Map<String,Integer> map=new HashMap<>();
        for (int i=0;i<n;i++){
            map.put(words[i],i);
        }
        //s都是由words中的字符组成的
        Set<String> set=new HashSet<>(); //记录滑动窗口中的string
        int left=0,right=0; //left指向的是s中的word的单词
        for (right=0;right<n;right++){

        }
        return res;
    }
}
