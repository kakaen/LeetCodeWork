package Top100;

public class 矩阵置零73 {
    public static void main(String[] args) {

    }
}
class Solution73 {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        //可以使用矩阵的第一行(的每个元素是否存在0)和第一列(每行是否存在0)进行标记该行
        boolean flagCol0=false,flagRow0=false;
        for (int i=0;i<m;i++){
            if (matrix[i][0]==0) flagCol0=true;
        }
        for (int j=0;j<n;j++){
            if (matrix[0][j]==0) flagRow0=true;
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (matrix[i][j]==0) matrix[i][0]=matrix[0][j]=0;
            }
        }
        //遍历第一行，如果元素为0则将该列全部置为
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (matrix[i][0]==0||matrix[0][j]==0) matrix[i][j]=0;
            }
        }
        if (flagRow0){
            for (int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
        if (flagCol0){
            for (int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }
}
