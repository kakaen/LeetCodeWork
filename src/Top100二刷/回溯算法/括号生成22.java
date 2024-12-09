package Top100二刷.回溯算法;

import 贪心算法.分发饼干455;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 括号生成22 {
    public static void main(String[] args) {
        括号生成22 test = new 括号生成22();
        for (String s : test.generateParenthesis(3)) {
            System.out.println(s);
        }

    }
    public List<String> generateParenthesis(int n){
        //数字n代表生成括号的对数，设计
        List<String> res=new ArrayList<>();
        char[] path=new char[n*2]; //每个合法的括号应该是2*n个长度
        dfs2(n,0,path,0,0,res);
        return res;
    }
    public void dfs2(int n,int start,char[] path,int open,int close,List<String> res){
        if (start==2*n){
            res.add(new String(path));
            return;
        }
        if (open<n){
            path[start]='(';
            dfs2(n,start+1,path,open+1,close,res);
        }
        if (close<open){
            path[start]=')';
            dfs2(n,start+1,path,open,close+1,res);
        }

    }
    public void dfs(int n,int start,char[] path,List<String> res){
        if (start==2*n){
            if (isAvalib(path)){
                res.add(new String(path));
            }
            return;
        }
        //选(
        path[start]='(';
        dfs(n,start+1,path,res);
        //选')'
        path[start]=')';
        dfs(n,start+1,path,res);
    }
    //判断char数组是否合法
    public boolean isAvalib(char[] path){
        Deque<Character> stack=new ArrayDeque<>();
        for (char ch:path){
            if (ch=='('){
                stack.push(ch);
            }else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
