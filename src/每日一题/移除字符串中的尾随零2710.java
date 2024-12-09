package 每日一题;

import sun.java2d.pipe.SolidTextRenderer;

public class 移除字符串中的尾随零2710 {
    public static void main(String[] args) {
        Solution2710 solution2710 = new Solution2710();
        System.out.println(solution2710.removeTrailingZeros("512303000"));
    }
}
class Solution2710 {
    public String removeTrailingZeros(String num) {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<num.length();i++){
            stringBuilder.append(num.charAt(i));
        }
        while (stringBuilder.charAt(stringBuilder.length()-1)=='0'){
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        return stringBuilder.toString();
    }
}
