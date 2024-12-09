package Top100.链表;

public class 判断矩阵是否满足条件3142 {
    public static void main(String[] args) {

    }
}
class Solution3142{
    public boolean satisfiesConditions(int[][] grid){
        //每一列必须都相同
        //每一行必须不同
        int m=grid.length;
        int n=grid[0].length;
        //比例每一行的每个元素
        for (int i=0;i<m;i++){
            for (int j=0;j<n-1;j++){
                if (grid[i][j]==grid[i][j+1]){
                    return false;
                }
            }
        }
        //记录每一列，判断是否一致
        for (int j=0;j<n;j++){
            for (int i=0;i<m-1;i++){
                if (grid[i][j]!=grid[i+1][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
