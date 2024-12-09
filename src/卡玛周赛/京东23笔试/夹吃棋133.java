package 卡玛周赛.京东23笔试;



import java.util.Scanner;

public class 夹吃棋133 {
    public static void main(String[] args) {
        int t;
        Scanner scanner = new Scanner(System.in);
        t=scanner.nextInt();

        char[][] chars=new char[3][3];
       String[] res=new String[t];
        for (int i=0;i<t;i++){
            for (int j=0;j<3;j++){
                chars[j]=scanner.next().toCharArray();
            }
            res[i]=function(chars);
        }
        for (String str:res){
            System.out.println(str);
        }
    }
    public static java.lang.String function(char[][] array){
        int countBlack=0;
        int countWrite=0;
        //判断行元素的
        for (int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == '.') continue;
                if (i == 1) {
                    if (array[i][j] == '*' && array[i - 1][j] == 'o' && array[i + 1][j] == 'o') countWrite++;
                    if (array[i][j] == 'o' && array[i - 1][j] == '*' && array[i + 1][j] == '*') countBlack++;
                }
                if (j == 1) {
                    if (array[i][j] == '*' && array[i][j - 1] == 'o' && array[i][j + 1] == 'o') countWrite++;
                    if (array[i][j] == 'o' && array[i][j - 1] == '*' && array[i][j + 1] == '*') countBlack++;
                }
                if (i == 0 && j == 0) {
                    if (array[0][0] == '*' && array[0][1] == 'o' && array[1][0] == 'o') countWrite++;
                    if (array[0][0] == 'o' && array[0][1] == '*' && array[1][0] == '*') countBlack++;
                } else if (i == 0 && j == 2) {
                    if (array[0][2] == '*' && array[1][2] == 'o' && array[0][1] == 'o') countWrite++;
                    if (array[0][2] == 'o' && array[1][2] == '*' && array[0][1] == '*') countBlack++;
                } else if (i == 2 && j == 0) {
                    if (array[2][0] == '*' && array[1][0] == 'o' && array[2][1] == 'o') countWrite++;
                    if (array[2][0] == 'o' && array[1][0] == '*' && array[2][1] == '*') countBlack++;
                } else if (i == 2 && j == 2) {
                    if (array[2][2] == '*' && array[1][2] == 'o' && array[2][1] == 'o') countWrite++;
                    if (array[2][2] == 'o' && array[1][2] == '*' && array[2][1] == '*') countBlack++;
                }
            }
        }
        if (countWrite==countBlack){
            return "draw";
        }else {
            return countBlack>countWrite?"kou":"yukan";
        }
    }
}
