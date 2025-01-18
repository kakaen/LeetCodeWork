package 每日一题;

public class 将日期转换为二进制表示3280 {
    public static void main(String[] args) {
        将日期转换为二进制表示3280 test = new 将日期转换为二进制表示3280();
        StringBuilder builder=new StringBuilder();
        System.out.println(test.convertDateToBinary("2080-02-29"));
    }
    //库函数的写法
    public String convertDateToBinary2(String date){
        //将date字符串切割
        String[] strs = date.split("-");
        for (int i=0;i< strs.length;i++){
            strs[i] = Integer.toBinaryString(Integer.parseInt(strs[i]));
        }
        return String.join("-",strs);
    }
    public String convertDateToBinary(String date){
        //将string转为二进制的表示
        int n=date.length();
        int num=0;
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<n;i++){
            char ch = date.charAt(i);
            if (ch!='-'){
                num=num*10+ch-'0';
            }else{
                //将num转为二进制表示
                builder.append(reverseBinary(new StringBuilder(),num)).append("-");
                num=0;
            }
        }
        builder.append(reverseBinary(new StringBuilder(),num));
        return builder.toString();
    }


    public String reverseBinary(StringBuilder builder,int num){
        while (num!=0){
            int a=num%2;
            num=num/2;
            builder.append(a);
        }
        return builder.reverse().toString();
    }
}
