package Top100.矩阵;

public class 搜索二维矩阵II240 {
    public static void main(String[] args) {

    }
}
class Solution240{
    public boolean searchMatrix(int[][] matrix,int target){
        //每行的元素从左到右升序排列
        int n=matrix.length;
        int m=matrix[0].length;
        //每列的元素从上到下升序排列
        //从右上角开始查找
        int i=0,j=m-1; //从右上角开始
        while (i<n&&j>=0){ //还有剩余元素
            if (matrix[i][j]==target) return true;
            if (matrix[i][j]<target){
                i++; //这一行元素都小于target，排除
            }else{
                j--;
            }
        }
        return false;

    }
}
