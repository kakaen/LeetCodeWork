package Top100二刷;

public class 矩阵置为零73 {
    public void setZeroes(int[][] matrix){
        //将第一行和第一列作为flag数组，如果nums[i,j]为0
        //则将行num[0][j]置为0，nums[i][0]置为0
        boolean flagRow=false; //判断第一行是否存在0
        boolean flagCol=false; //判断第一列是否存在0
        int m=matrix.length;
        int n=matrix[0].length;
        for (int j=0;j<n;j++){
            if (matrix[0][j]==0) flagRow=true;
        }
        for (int i=0;i<m;i++){
            if (matrix[i][0]==0) flagCol=true;
        }
        //遍历
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        //赋值为0
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (matrix[0][j]==0||matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if (flagRow){
            for (int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
        if (flagCol){
            for (int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }

}
