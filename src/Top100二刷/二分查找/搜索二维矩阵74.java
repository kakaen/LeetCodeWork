package Top100二刷.二分查找;

public class 搜索二维矩阵74 {
    public boolean searchMatrix(int[][] matrix,int target){
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]==target){
                    return true;
                }else if(matrix[i][j]<target){
                    break;
                }

            }
        }
        return false;
    }
    public boolean searchMatrix2(int[][] matrix,int target){
        //我们可以在第一列中进行使用二分查找，查找到最后一个小于等于target的值，这样target一定在该行
        //小于等于target
        int m=matrix.length;
        int n=matrix[0].length;
        int l=0,r=n-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (matrix[mid][0]<=target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        int row=r;
        l=0;r=n-1;
        //如果left小于等于right

        while (l<=r){
            int mid=l+(r-l)/2;
            if (matrix[row][mid]==target){
                return true;
            } else if (matrix[row][mid]>target) {
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        搜索二维矩阵74 test = new 搜索二维矩阵74();
        int[][] matrix=new int[][]{{1,3,5,7},{10,11,16,17},{23,30,34,60}};
        System.out.println(test.searchMatrix2(matrix, 13));
    }
}
