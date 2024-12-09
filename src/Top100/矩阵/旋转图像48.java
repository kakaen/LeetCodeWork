package Top100.矩阵;

public class 旋转图像48 {
    public static void main(String[] args) {
        旋转图像48 test = new 旋转图像48();
        int[][] matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        test.rotate(matrix);
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                System.out.println(matrix[i][j]);
            }
        }
    }
    public void rotate(int[][] matrix){
        //第一步先将矩阵按照主对角线进行变换
        int n=matrix.length;
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //再反转
        for (int i=0;i<n;i++){
            for (int j=0;j<n/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }
    }

}
