package 回溯算法.回溯算法二刷;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;
public class 分割回文串131 {
    public List<List<String>> partition(String s){
        //将s分割成子串
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        backtracking(0,s,res,path);
        return res;
    }
    public void backtracking(int start,String s,List<List<String>> res,List<String> path){
        if (start>=s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<s.length();i++){
            if (isPalindrome(s,start,i)){
                String str=s.substring(start,i+1);
                path.add(str);
            }else{
                continue;
            }
            backtracking(i+1,s,res,path);
            path.remove(path.size()-1);
        }
    }
    public boolean isPalindrome(String s,int start,int end){
        while (start<end){
            if (s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
