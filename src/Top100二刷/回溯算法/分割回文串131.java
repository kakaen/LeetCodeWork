package Top100二刷.回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串131 {
    public List<List<String>> partition(String s) {
        //字符串s将s分割成一些子串，每个子串都是回文串，返回s的所有可能方案
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        dfs(0,s,res,path);
        return res;
    }
    public void backTracking(int starIndex,String s,List<List<String>> res,List<String> path){
        if (starIndex==s.length()){
            res.add(new ArrayList<>());
            return;
        }
        //每一层的进行遍历
        for (int i=starIndex;i<s.length();i++){
            if (isPalindrome(s,starIndex,i)){
                path.add(s.substring(starIndex,i+1));
                backTracking(i+1,s,res,path);
                path.remove(path.size()-1);
            }
        }
    }
    //递归的函数，dfs表示从starIndex位置进行切割
    public void dfs(int starIndex,String s,List<List<String>> res,List<String> path){
        if (starIndex==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        //进行递归循环
        for (int i=starIndex;i<s.length();i++){ //枚举子串的结束位置
            //如果（startIndex，i）这个字符串是回文串的话
            if (isPalindrome(s,starIndex,i)){
                //获取切割的子串
                String str=s.substring(starIndex,i+1);
                path.add(str);
                dfs(i+1,s,res,path);
                //恢复原样
                path.remove(path.size()-1);
            }
        }
    }
    //判断是否为回文子串。回文子串
    public boolean isPalindrome(String s,int starIndex,int endIndex){
        while (starIndex<=endIndex){
            if (s.charAt(starIndex)!=s.charAt(endIndex)){
                return false;
            }
            starIndex++;
            endIndex--;
        }
        return true;
    }
}
