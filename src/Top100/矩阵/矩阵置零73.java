package Top100.矩阵;

public class 矩阵置零73 {
    public void setZeros(int[][] matrix){

        //第一行和第一列，存储是否元素为0
        boolean rowFlag=false; //判断第一行的元素是否存在0元素
        boolean colFlag=false;
        int m=matrix.length; //行总数
        int n=matrix[0].length; //列总数
        for (int i=0;i<m;i++){
            if (matrix[i][0]==0) colFlag=true; //说明第一列存在0；
        }
        for (int j=0;j<n;j++){
            if (matrix[0][j]==0) rowFlag=true; //说明第一行存在0；
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
       for (int i=1;i<m;i++){
           for (int j=1;j<n;j++){
               if (matrix[0][j]==0||matrix[i][0]==0) matrix[i][j]=0;
           }
       }
       if (rowFlag){
           for (int j=0;j<n;j++){
               matrix[0][j]=0;
           }
       }
       if (colFlag){
           for (int i=0;i<m;i++){
               matrix[i][0]=0;
           }
       }
    }
}
