package Top100;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵54 {
    public static void main(String[] args) {

    }
}
class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        //创建一个状态量作为顺序
        int[] flag=new int[]{1};

        int l=0,r=matrix[0].length-1,t=0,b=matrix.length-1,x=0;
        while (true){
            //从左到右遍历了一遍
            for (int i=l;i<=r;i++) list.add(matrix[t][i]);
            if(++t>b) break; //top向下移动一行
            for (int i=t;i<=b;i++) list.add(matrix[i][r]);
            if (--r<l) break;
            for (int i=r;i>=l;i--) list.add(matrix[b][i]);
            if (--b<t) break;
            for (int i=b;i>=t;i--) list.add(matrix[i][l]);
            if(++l>r) break;
        }
        return list;

    }
}