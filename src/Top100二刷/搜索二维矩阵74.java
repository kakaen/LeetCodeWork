package Top100二刷;

public class 搜索二维矩阵74 {
    public static void main(String[] args) {
        搜索二维矩阵74 test = new 搜索二维矩阵74();
        int[][] matrix=new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix2=new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(test.searchMatrix(matrix, 3));
        System.out.println(test.searchMatrix(matrix2, 32));
    }
    public boolean searchMatrix(int[][] matrix,int target){
        int m=matrix.length;
        int n=matrix[0].length;
        //我们从右上角开始遍历，如果右上角的元素小于target，则遍历下一行
        for (int i=0;i<m;i++){
            if (matrix[i][n-1]<target) continue;
            int l=0,r=n-1;
            while (l<=r){
                int mid=l+(r-l)/2;
                if (matrix[i][mid]==target){
                    return true;
                } else if (matrix[i][mid]>target) {
                  r=mid-1;
                }else{
                    l=mid+1;
                }
            }
        }
        return false;
    }
    public boolean searchMatrix2(int[][] matrix,int target){
        int i=0;
        int j=matrix[0].length-1;
        while (i<matrix.length&&j>=0){
            if (matrix[i][j]==0) return true;
            if (matrix[i][j]<target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
