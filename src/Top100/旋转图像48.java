package Top100;

public class 旋转图像48 {
    public static void main(String[] args) {

    }
}
class Solution48 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        //第一步，先将元素按照对角线进行翻转
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //第二步逐行翻转元素
        for (int i=0;i<n;i++){
            int left=0,right=n-1;
            while (left<right){
                int tem=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=tem;
                left++;
                right--;
            }
        }
    }
}
