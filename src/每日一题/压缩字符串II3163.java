package 每日一题;

public class 压缩字符串II3163 {
    public static void main(String[] args) {
        压缩字符串II3163 test = new 压缩字符串II3163();
        System.out.println(test.compressedString("abcdef"));
        System.out.println(test.compressedString("aaaaaabbcdeff"));
        System.out.println(test.compressedString("aaaaaaaaaaaaaabb"));
    }
    public String compressedString(String word){
       StringBuilder builder=new StringBuilder();
       int count=1;
       int n=word.length();
       int left=0,right=0;
       //left指向第一个不为
       for (right=1;right< n;right++){
           if (count<9&&word.charAt(left)==word.charAt(right)){
               count++;
           }else {
               builder.append(String.valueOf(count));
               builder.append(word.charAt(left));
               left=right;
               count=1;
           }
       }
        //最后还需要进行添加left的值
        builder.append(String.valueOf(count));
        builder.append(word.charAt(left));
       return builder.toString();
    }
}
