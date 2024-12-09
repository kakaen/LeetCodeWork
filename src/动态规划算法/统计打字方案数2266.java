package 动态规划算法;

public class 统计打字方案数2266 {
    public static void main(String[] args) {

    }
}
class Solution2266 {
    public String[] MAPPING=new String[]{"","","abc","def","ghi","jkl","mno","pdrs","tuv","wxyz"};
    public int countTexts(String pressedKeys) {
        //按出字母需要按对应字母i次
        //Bob收到的数
        long count=0; //记录总数
        char[] charArr=pressedKeys.toCharArray();
        //先得到Alice总共发了多少字符
        int[] dp=new int[pressedKeys.length()+1];
        int preindex=0;
        for (int i=1;i<pressedKeys.length();i++){
            if (charArr[preindex]!=charArr[i]){

            }
        }
        int result=0;
        return result;
    }
}
