package 难度训练;

public class 将日期转为二进制表示 {
}
class Solution3280 {
    public String convertDateToBinary(String date) {
        String[] strs=date.split("-");
        StringBuilder stringBuilder=new StringBuilder();
        for (String str:strs){
            stringBuilder.append(func(str));
            stringBuilder.append("-");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
    public String func(String str){
        String res="";
        Integer n = Integer.valueOf(str);
        //除k倒取余的方法
        while (n!=0){
            res=n%2+res;
            n=n/2;
        }
        //将数字转为二进制表示
        return res;
    }
}