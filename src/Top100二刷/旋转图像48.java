package Top100二刷;

public class 旋转图像48 {
    public void rotate(int[][] matrix){
        int n=matrix.length;
        //先将图像按照主对角线反转
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                int tem=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tem;
            }
        }
        //先将图像每行反转
        for (int i=0;i<n;i++){
            for (int j=0;j<n/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
        //将矩阵按照主对角线进行反转
        for (int i=0;i<n;i++){
            for (int j=0;j<n-i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=temp;
            }
        }
    }
}
