package Top100二刷;

public class 搜索二维矩阵II240 {
    public boolean searchMatrix(int[][] matrix,int target){
        //搜索二维矩阵中的target数
        int m=matrix.length;
        int n=matrix[0].length;
        //matrix从左到右是升序排列的
        //matrix从上到下是升序排列的
        //从右上角开始查找，如果当前元素
        int i=0;
        int j=n-1;
        while (i<n&&j>=0){
            if (matrix[i][j]==target) return true;
            if (matrix[i][j]<target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
    //使用二分查找的方式
    public boolean searchMatrix2(int[][] matrix,int target){
        //对于每一行元素，使用二分查找来查询
        int m=matrix.length; //行数
        int n=matrix[0].length; //列数
        for (int i=0;i<m;i++){
            //使用二分查找
            if (binarySearch(matrix[i],target)) return true;
        }
        return false;
    }
    //返回
    public boolean binarySearch(int[] nums,int target){
        int i=0,j=nums.length-1;
        while (i<=j){
            int mid=(i+j)/2;
            if (nums[mid]==target) return true;
            if (nums[mid]<target){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return false;
    }
}
