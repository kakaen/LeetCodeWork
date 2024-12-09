package 每日一题;

public class 三角形的最大高度3200 {
    public static void main(String[] args) {
        三角形的最大高度3200 test = new 三角形的最大高度3200();
        System.out.println(test.maxHeightOfTriangle(2, 1));
        System.out.println(test.maxHeightOfTriangle(2, 4));
        System.out.println(test.maxHeightOfTriangle(1,1));
    }
    public int maxHeightOfTriangle(int red,int blue){
      //第一层的颜色不确定，可能为red，或者是blue
        int blevel=0,rlevel=0; //blue作为第一层
        int rlevel2=0,blevel2=0; //red作为第一层
        int red2=red,blue2=blue;
        for (int i=1;;i=i+2){
            if (blue>=i){
                blue=blue-i;
                blevel++;
            }
            if (red>=i){
                red=red-i;
                rlevel2++;
            }
            if (blue<i&&red<i) break;
        }
        for (int i=2;;i=i+2){
            if (red2>=i){
                rlevel++;
                red2=red2-i;
            }
            if (blue2>=i){
                blevel2++;
                blue2=blue2-i;
            }
            if (red2<i&&blue2<i) break;
        }
        int h1=0;
        if (blevel<=rlevel){
            h1=2*blevel;
        }else{
            h1=2*rlevel+1;
        }
        int h2=0;
        if (rlevel2<=blevel2){
            h2=2*rlevel2;
        }else{
            h2=2*blevel2+1;
        }
        return Math.max(h1,h2);
    }

}
