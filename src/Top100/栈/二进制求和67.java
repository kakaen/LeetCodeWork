package Top100.栈;

import java.util.Arrays;

public class 二进制求和67 {
    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        System.out.println(solution67.addBinary("1010", "1011"));
    }
}
class Solution67{
    public String addBinary(String a,String b){
        //两个String计算求和
        char[] aarray = a.toCharArray();
        char[] barray = b.toCharArray();
        int len1=aarray.length;
        int len2=barray.length;
        int i=len1-1;
        int j=len2-1;
        StringBuilder builder=new StringBuilder();
        int flag=0; //计算是否有进位1
        for (i=len1-1,j=len2-1;i>=0&&j>=0;i--,j--){
            int num=(aarray[i]-'0')+(barray[j]-'0')+flag; //
            flag=num/2;
            builder.append(num%2);
        }
        while (i>=0){
            int num=(aarray[i]-'0')+flag; //
            flag=num/2;
            builder.append(num%2);
            i--;
        }
        while (j>=0){
            int num=(barray[j]-'0')+flag;
            flag=num/2;
            builder.append(num%2);
            j--;
        }
        if (flag!=0){
            builder.append(flag);
        }
        return builder.reverse().toString();
    }
}
