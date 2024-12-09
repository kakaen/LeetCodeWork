package Top100.矩阵;

public class 反转字符串中的单词151 {
    public static void main(String[] args) {
        反转字符串中的单词151 test = new 反转字符串中的单词151();
        System.out.println(test.reverseWords(" the sky is blue  "));
    }
    public String reverseWords(String s){
      s=s.trim();
      StringBuilder builder=new StringBuilder();
      int j=s.length()-1,i=j;
      while (i>=0){
          while (i>=0&&s.charAt(i)!=' '){
              i--;
          }
          builder.append(s.substring(i+1,j+1)+" ");
          while (i>=0&&s.charAt(i)==' '){
              i--;
          }
          j=i;
      }
      return builder.toString().trim();
    }
}
