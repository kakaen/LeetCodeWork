package Top100二刷.回溯二刷.子集;

import java.util.ArrayList;
import java.util.List;

public class 字母大小写全排列784 {
    public static void main(String[] args) {
        字母大小写全排列784 test = new 字母大小写全排列784();
        String str="a1b2";
        test.letterCasePermutation(str);
        test.letterCasePermutation("3z4");
        test.letterCasePermutation("0");
    }
    public List<String> letterCasePermutation(String s){
        List<String> res=new ArrayList<>();
        char[] chars=s.toCharArray();
        backtracking(res,chars,0);

        return res;
    }
    public void backtracking(List<String> res,char[] path,int index){
        //每次都需要将path加入到最终结果集中
        res.add(new String(path));

        int j=index;
        while (j<path.length){
            //如果当前下标对应的元素是数字，则直接跳过
            if (path[j]>='1'&&path[j]<='9'){
                j++;

            }else{
                //将该位置的字母小写变为大写，或者大写变小写
                if (Character.isLowerCase(path[j])){
                    path[j]=Character.toUpperCase(path[j]);
                }else{
                    path[j]=Character.toLowerCase(path[j]);
                }
                backtracking(res,path,j+1);
                if (Character.isLowerCase(path[j])){
                    path[j]=Character.toUpperCase(path[j]);
                }else{
                    path[j]=Character.toLowerCase(path[j]);
                }
                j++;
            }
        }

    }
}
