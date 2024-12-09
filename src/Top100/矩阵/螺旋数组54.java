package Top100.矩阵;

import java.util.ArrayList;
import java.util.List;

public class 螺旋数组54 {
    public List<Integer> spiralOrder(int[][] matrix ){
        int topIndex=0,rightIndex=matrix[0].length-1,leftIndex=0,tailIndex=matrix.length-1;
        List<Integer> res=new ArrayList<>();
        while (true){
            for (int i=leftIndex;i<=rightIndex;i++){
                res.add(matrix[topIndex][i]);
                //left-->right
            }
            topIndex++;
            if (topIndex>tailIndex) break;
            for (int i=topIndex;i<=tailIndex;i++){
                //top-->tail
                res.add(matrix[i][rightIndex]);
            }
            rightIndex--;
            if (rightIndex<leftIndex) break;
            for (int i=rightIndex;i>=leftIndex;i--){
                //right--->left
                res.add(matrix[tailIndex][i]);
            }
            tailIndex--;
            if (tailIndex<topIndex) break;
            for (int i=tailIndex;i>=topIndex;i--){
                res.add(matrix[i][leftIndex]);
            }
            leftIndex++;

            if (leftIndex>rightIndex) break;
        }
        return res;
    }
}
