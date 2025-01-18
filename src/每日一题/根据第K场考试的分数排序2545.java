package 每日一题;

import java.util.Arrays;

public class 根据第K场考试的分数排序2545 {
    public static void main(String[] args) {
        根据第K场考试的分数排序2545 test = new 根据第K场考试的分数排序2545();
        int[][] score=new int[][]{{10,6,9,1},{7,5,11,2},{4,8,3,15}};
        int[][] ints = test.sortTheStudents(score, 2);
        for (int[] arr:ints){
            System.out.println(Arrays.toString(arr));
        }
    }
    public int[][] sortTheStudents(int[][] score,int k){
        int m=score.length;
//        int n=score[0].length;
        //按照第k场的考试分数从高到低完成对这些学生的排序
        for (int i=0;i<m-1;i++){
            for (int j=i+1;j<m;j++){
                if (score[j][k]>score[i][k]){
                    int[] temp=score[i];
                    score[i]=score[j];
                    score[j]=temp;
                }
            }
        }
        return score;
    }
}
