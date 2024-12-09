package Top100.数组;

import java.util.ArrayList;
import java.util.List;

public class Z字变化6 {
    public static void main(String[] args) {

    }
    //方法一使用二维矩阵进行模拟
    public String convert(String s,int numRows){
        int n=s.length();
        //每个周期是2r-2个元素，占用r-1列。
        int t=2*numRows-2;
        int c=(n+t-1)/t; //得到周期数
        int cols=c*(numRows-1);
        char[][] chars=new char[numRows][cols];
        for (int i=0;i<n;i++){

        }
        return "";
    }
}
