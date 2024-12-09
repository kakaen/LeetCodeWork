package Top100.矩阵;

public class Z字形变换6 {
    public static void main(String[] args) {
        Z字形变换6 test = new Z字形变换6();
        System.out.println(test.convert("PAYPALISHIRING", 3));
        System.out.println(test.convert("PAYPALISHIRING", 4));
    }
    public String convert(String s,int numRows){
        //一个周期是 2*R-2个元素
        int n=s.length();
        if (numRows==1||numRows>=n) return s;
        int cols=(n+2*numRows-3)/(2*numRows-2)*(numRows-1);
        System.out.println(cols);
        char[][] chars=new char[numRows][cols];
        int i=0; //遍历s字符串
        boolean flag=true; //判断是否是向下移动
        int row=0,col=0;
        while (i<n){
            char ch=s.charAt(i);
            chars[row][col]=ch;
            if (row==numRows-1){
                flag=false;
            }else if (row==0){
                flag=true;
            }
            if (flag){
                row++; //向下移动
            }else {
                row=row-1;
                col=col+1; //向右上移动
            }
            i++;
        }
        StringBuilder builder=new StringBuilder();
        for (int k=0;k<chars.length;k++){
            for (int v=0;v<chars[0].length;v++){
                if (chars[k][v]=='\u0000') continue;
                builder.append(chars[k][v]);
            }
        }
        return builder.toString();
    }
    public String convert2(String s,int numRows) {
        int n = s.length();
        int t = 2 * numRows - 2;
        int r = 0; //遍历的
        int c = 0;
        String ans = "";
        //添加第一行的元素
        for (c=0;c+r<n;c=c+t){
            ans+=s.charAt(c);
        }
        for (int i=0;i<numRows;i++){ //枚举每一行
            for (int j=0;j+i<n;j=j+t){ //枚举每个要添加的列
                ans+=s.charAt(j+i);
//                if (i>0&&)
            }

        }

        return ans;
    }
}
