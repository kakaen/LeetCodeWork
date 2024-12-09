package Top100;

public class 去除重复字母316 {
    public static void main(String[] args) {

    }
}
class Solution316{
    public String removeDuplicateLetters(String s){
        //使用单调栈来维护字符的递增操作
        boolean[] vis=new boolean[26]; //判断是否存在
        int[] num=new int[26];
        char[] array=s.toCharArray();
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<array.length;i++){
            char ch=array[i];
            if (!vis[ch-'a']){
                //如果栈非空，且栈顶元素大于待插入元素
                while (builder.length()>0&&builder.charAt(builder.length()-1)>ch){
                    //如果栈顶元素大于0；
                    if (num[builder.charAt(builder.length()-1)-'a']>0){
                        vis[builder.charAt(builder.length()-1)-'a']=false;
                        builder.deleteCharAt(builder.length()-1);
                    }else {
                        break;
                    }
                }
            }
        }
        return "n";
    }
}
