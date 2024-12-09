package 双指针算法;

public class 比较退格的字符串844 {
    public static void main(String[] args) {
        Solution844 solution844 = new Solution844();
        String s="xywrrmp";
        String t="xywrrmu#p";
        System.out.println(solution844.backspaceCompare(s, t));
    }
}
class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        //#表示退格
        StringBuilder builder=new StringBuilder();
        int i=0;
        while (i<s.length()){
            //如果当前字符是‘#’
            if (s.charAt(i)=='#'){
                //如果当前字母集不为0
                if (builder.length()!=0){
                    builder.deleteCharAt(builder.length()-1);
                }
            }else {
                builder.append(s.charAt(i));
            }
            i++;
        }
        String newS=builder.toString();
        int j=0;
        builder.delete(0,builder.length());
        while (j<t.length()){
            //如果当前字符是‘#’
            if (t.charAt(j)=='#'){
                //如果当前字母集不为0
                if (builder.length()!=0){
                    builder.deleteCharAt(builder.length()-1);
                }
            }else {
                builder.append(t.charAt(j));
            }
            j++;
        }
        String newT=builder.toString();
        System.out.println(newS);
        System.out.println(newT);
        return  newS.equals(newT);
    }
    //使用双指针算法进行学习
    public boolean backspaceCompare2(String s,String t){
        int skipS=0,skipT=0;
        int i=s.length()-1,j=t.length()-1;
        while (i>=0||j>0){
            while (i>=0){
                if (s.charAt(i)=='#'){
                    skipS++;
                    i--;
                } else if (skipS>0) {
                    skipS--;
                    i--;
                }else {
                    break;
                }
            }
            while (j>=0){
                if (t.charAt(j)=='#'){
                    skipT++;
                    j--;
                }else if (skipT>0){
                    skipT--;
                    j--;
                }else {
                    break;
                }
            }
            if (i>=0&&j>=0){
                if (s.charAt(i)!=t.charAt(j)){
                    return false;
                }
            }else if (i>=0||j>=0){
                return false;
            }
                i--;
                j--;
        }
        return true;

    }
}
