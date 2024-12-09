package 回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串131 {
    public static void main(String[] args) {

    }
}
class Solution131 {
    public List<List<String>> result=new ArrayList<>();
    public List<String> path=new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTracking(s,0);
        return result;
    }

    public void backTracking(String s,int starIndex){
        if (starIndex==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i=starIndex;i<s.length();i++){
            if (isTrue(s.substring(starIndex,i+1))){
                path.add(s.substring(starIndex,i+1));
                backTracking(s,i);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isTrue(String s){
        int left=0,right=s.length()-1;
        while (left<right){
            if (s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
