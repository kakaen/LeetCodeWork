package 难度训练;

public class Ip地址无效化1108 {
    public static void main(String[] args) {
        Solution1108 solution1108 = new Solution1108();
        System.out.println(solution1108.defangIPaddr("1.1.1.1"));
    }
}
class Solution1108{
    public String defangIPaddr(String address){
        StringBuilder builder=new StringBuilder();
        char[] charArray = address.toCharArray();
        for (int i=0;i<charArray.length;i++){
            if (charArray[i]=='.'){
                builder.append("[.]");
            }else{
                builder.append(charArray[i]);
            }
        }
        return builder.toString();
    }
}
