package Top100二刷;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer> res=new ArrayList<>(); //添加结果的
        int top=0;
        int end=m-1;
        int left=0;
        int right=n-1;
        while (true){
            //遍历第top层
            for (int j=left;j<=right;j++){
                res.add(matrix[top][j]);
            }
            top++;
            if (top>end) break;
            //遍历right列
            for (int i=top;i<=end;i++){
                res.add(matrix[right][i]);
            }
            right--;
            if (right<left) break;
            //遍历end层
            for (int j=right;j>=left;j--){
                res.add(matrix[end][j]);
            }
            end--;
            if (end<top) break;
            for (int i=end;i>=top;i--){
                res.add(matrix[i][left]);
            }
            left++;
            if (left>right) break;
        }
        return res;
    }
}
